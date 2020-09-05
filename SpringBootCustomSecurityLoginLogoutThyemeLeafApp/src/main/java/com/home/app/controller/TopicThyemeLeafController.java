package com.home.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.home.app.entities.Topic;
import com.home.app.service.TopicService;

@Controller
@RequestMapping("/user")
public class TopicThyemeLeafController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/login")
	public ModelAndView login() {
		    return new ModelAndView("custom-login");
	}
	
	@GetMapping("/secure/topic-details")
	public ModelAndView getAllUserTopics() {
		    ModelAndView modelAndView = new ModelAndView();
		    modelAndView.addObject("usertopics", topicService.getAllTopics());
		    modelAndView.setViewName("topics");
		    return modelAndView;
    }
	@GetMapping("/error")
	public ModelAndView error() {
		    ModelAndView modelAndView = new ModelAndView();
		    String errorMessage= "You are not authorized for the requested data.";
		    modelAndView.addObject("errorMsg", errorMessage);
		    modelAndView.setViewName("error");
		    return modelAndView;
    }
} 