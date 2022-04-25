package be.pxl.superhero.service.impl;

import be.pxl.superhero.api.SuperheroRequest;
import be.pxl.superhero.exception.ResourceNotFoundException;
import be.pxl.superhero.repository.SuperheroRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class SuperheroServiceImplUpdateSuperhero {
	private static final Long SUPERHERO_ID = 15L;

	@Mock
	private SuperheroRepository superheroRepository;

	@InjectMocks
	private SuperheroServiceImpl superheroService;

	@Test
	public void ThrowsResourceNotFoundExceptionWhenThereIsNoSuperheroWithGivenId() {
		when(superheroRepository.findById(SUPERHERO_ID)).thenReturn(Optional.empty());
		SuperheroRequest superheroRequest = new SuperheroRequest("first", "last", "name");
		ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class, () -> superheroRepository.findById(SUPERHERO_ID));



	}

}
