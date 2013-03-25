package com.fm.mongotrip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.mongotrip.domain.Trip;
import com.fm.mongotrip.repository.TripRepository;

@Controller
@RequestMapping("/trip")
public class TripController {
	
	@Autowired private TripRepository tripRepository;
	
	@RequestMapping
	public String getList(Model model){
		model.addAttribute("trips", tripRepository.findAll());
		return "triplist";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAdd(Model model){
		model.addAttribute("trip", new Trip());
		return "tripadd";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String postAdd(@ModelAttribute("trip") Trip trip){
		tripRepository.save(trip);
		return "redirect:/trip";
	}
	
	


}
