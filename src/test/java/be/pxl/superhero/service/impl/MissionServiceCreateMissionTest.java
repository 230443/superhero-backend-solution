package be.pxl.superhero.service.impl;

import be.pxl.superhero.api.CreateMissionRequest;
import be.pxl.superhero.api.MissionDTO;
import be.pxl.superhero.builder.MissionBuilder;
import be.pxl.superhero.domain.Mission;
import be.pxl.superhero.repository.MissionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ValidationException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MissionServiceCreateMissionTest {

	private static final String MISSION_NAME = "Secret mission";

	@Mock
	private MissionRepository missionRepository;

	@InjectMocks
	private MissionServiceImpl missionService;

	@Captor
	private ArgumentCaptor<Mission> missionCaptor;

	@Test
	void validationExceptionIsThrownWhenMissionNameNotUnique() {

		when(missionRepository.findMissionByName("Secret Mission"))
				.thenReturn(Optional.of(MissionBuilder.aMission().build()));

		ValidationException exception = assertThrows(ValidationException.class, () -> missionService.createMission(new CreateMissionRequest("Secret Mission")));

		assertEquals("Name already exists", exception.getMessage());


	}

	@Test
	void newMissionCreated() {

		when(missionRepository.findMissionByName(MISSION_NAME)).thenReturn(Optional.empty());
		when(missionRepository.save(Mockito.any(Mission.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
		CreateMissionRequest request = new CreateMissionRequest(MISSION_NAME);
		MissionDTO result = missionService.createMission(request);
		assertEquals(MISSION_NAME, result.getMissionName());

		Mockito.verify(missionRepository).save(missionCaptor.capture());

		Mission savedMission = missionCaptor.getValue();
		assertEquals(MISSION_NAME, savedMission.getName());
		assertFalse(savedMission.isDeleted());
		assertFalse(savedMission.isCompleted());

	}
}