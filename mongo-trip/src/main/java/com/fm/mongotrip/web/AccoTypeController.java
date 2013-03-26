package com.fm.mongotrip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.mongotrip.domain.AccoType;
import com.fm.mongotrip.repository.AccoTypeRepository;

@Controller
@RequestMapping("/accoType")
public class AccoTypeController {
	
@Autowired private AccoTypeRepository accoTypeRepository;
	
	@RequestMapping
	public String getList(Model model){
		model.addAttribute("accoTypes", accoTypeRepository.findAll());
		return "accotypelist";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAdd(Model model){
		model.addAttribute("accoType", new AccoType());
		return "accotypeadd";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String postAdd(@ModelAttribute("accoType") AccoType accoType){
		accoTypeRepository.save(accoType);
		return "redirect:/accoType";
	}

}
