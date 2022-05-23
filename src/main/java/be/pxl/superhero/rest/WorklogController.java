package be.pxl.superhero.rest;

import be.pxl.superhero.api.MissionDTO;
import be.pxl.superhero.api.WorklogForm;
import be.pxl.superhero.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/worklog")
public class WorklogController {


	private final MissionService missionService;
	private final Logger LOGGER = Logger.getLogger(WorklogController.class.getName());

	@Autowired
	public WorklogController(MissionService missionService) {
		this.missionService = missionService;
	}

	@GetMapping
	public String getWorklog(Model model) {
		List<MissionDTO> missions = missionService.findAllMissions();
		model.addAttribute("missions", missions);
		return "worklog";
	}

	@GetMapping("/submit")
	public String submitWorkload(Model model) {
		List<MissionDTO> missions = missionService.findActiveMissions();
		model.addAttribute("missions", missions);
		model.addAttribute("worklogForm", new WorklogForm());
		System.out.println(missions);
		return "submit_worklog";
	}

	@PostMapping("/submit")
	public String submitWorkload(WorklogForm worklogForm) {
		LOGGER.info("Submitting worklog for mission: " + worklogForm.toString());
		return "redirect:/worklog";
	}
}
