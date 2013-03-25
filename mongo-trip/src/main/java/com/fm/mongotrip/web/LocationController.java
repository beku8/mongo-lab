package com.fm.mongotrip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.mongotrip.domain.Location;
import com.fm.mongotrip.repository.LocationRepository;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	@Autowired private LocationRepository locationRepository;
	
	@RequestMapping
	public String getList(Model model){
		model.addAttribute("locations", locationRepository.findAll());
		return "locationlist";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAdd(Model model){
		model.addAttribute("location", new Location());
		return "locationadd";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String postAdd(@ModelAttribute("location") Location location){
		locationRepository.save(location);
		return "redirect:/location";
	}
	

}
