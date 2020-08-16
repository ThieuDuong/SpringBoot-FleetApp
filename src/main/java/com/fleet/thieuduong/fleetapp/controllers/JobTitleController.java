package com.fleet.thieuduong.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.thieuduong.fleetapp.models.JobTitle;
import com.fleet.thieuduong.fleetapp.services.JobTitleService;

@Controller
public class JobTitleController {
	@Autowired
	private JobTitleService jobTitleService;

	@GetMapping("/jobtitles")
	public String getJobTitles(Model model) {
		model.addAttribute("jobtitles", jobTitleService.getJobTitles());
		return "JobTitle";
	}

	@PostMapping("/jobtitle/addNew")
	public String addNewJobTitle(JobTitle jobTitle) {
		jobTitleService.saveJobTitle(jobTitle);
		return "redirect:/jobtitles";
	}

	@RequestMapping("/jobtitle/findById")
	@ResponseBody
	public Optional<JobTitle> getJobTitleById(int id) {
		return jobTitleService.getJobTitleById(id);
	}

	@RequestMapping(value = "/jobtitle/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateJobTitle(JobTitle jobTitle) {
		jobTitleService.saveJobTitle(jobTitle);
		return "redirect:/jobtitles";
	}

	@RequestMapping(value = "/jobtitle/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteJobTitle(int id) {
		jobTitleService.deleteJobTitle(id);
		return "redirect:/jobtitles";
	}
}
