package be.pxl.superhero.service.impl;

import be.pxl.superhero.api.MissionDTO;
import be.pxl.superhero.api.SuperheroDTO;
import be.pxl.superhero.builder.MissionBuilder;
import be.pxl.superhero.builder.SuperheroBuilder;
import be.pxl.superhero.domain.Mission;
import be.pxl.superhero.domain.Superhero;
import be.pxl.superhero.repository.MissionRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MissionServiceImplTest {

	private static final String MISSION_NAME = "Secret mission";

	@Mock
	private MissionRepository missionRepository;

	@InjectMocks
	private MissionServiceImpl missionService;

	@Captor
	private ArgumentCaptor<Mission> missionCaptor;

	@Test
	void findAllMissions() {
		Mission mission1 = MissionBuilder.aMission().withName("m1").build();
		Mission mission2 = MissionBuilder.aMission().withName("m2").build();

		when(missionRepository.findAll()).thenReturn(Arrays.asList(mission1, mission2));

		List<MissionDTO> allMissions = missionService.findAllMissions();
		assertThat(allMissions.stream().map(MissionDTO::getMissionName).collect(Collectors.toList()))
				.hasSize(2)
				.containsExactly("m1", "m2");
	}

	@Test
	void findMissionById() {
		Mission m1 = MissionBuilder.aMission().build();

		when(missionRepository.findById(MissionBuilder.ID)).thenReturn(Optional.of(m1));

		MissionDTO retrieved = missionService.findMissionById(MissionBuilder.ID);
		assertEquals(retrieved.getMissionName(), m1.getName());
	}

	@Test
	@Disabled
	void updateMission() {
	}

	@Test
	@Disabled
	void deleteMission() {
	}
}