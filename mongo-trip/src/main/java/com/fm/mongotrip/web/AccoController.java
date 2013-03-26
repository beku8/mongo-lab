package com.fm.mongotrip.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fm.mongotrip.domain.Acco;
import com.fm.mongotrip.domain.Location;
import com.fm.mongotrip.repository.AccoRepository;
import com.fm.mongotrip.repository.AccoTypeRepository;
import com.fm.mongotrip.repository.LocationRepository;

@Controller
@RequestMapping("/acco")
public class AccoController {
	
	@Autowired private AccoRepository accoRepository;
	@Autowired private LocationRepository locationRepository;
	@Autowired private AccoTypeRepository accoTypeRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AccoController.class);
	
	@RequestMapping
	public String getList(Model model){
		model.addAttribute("accos", accoRepository.findAll());
		return "accolist";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAdd(Model model){
		model.addAttribute("acco", new Acco());
		model.addAttribute("locations", locationRepository.findAll());
		model.addAttribute("accoTypes", accoTypeRepository.findAll());
		return "accoadd";
	}
	
//	@RequestMapping(value="/add", method=RequestMethod.POST)
//	public String postAdd(@ModelAttribute("acco") Acco acco,
//			@RequestParam("accoTypeType") String accoType, @RequestParam("locationId") String location){
//		logger.info("accoType: {}, location id: {}", accoType, location);
//		acco.setAccoType(accoTypeRepository.findOne(accoType));
//		acco.setLocation(locationRepository.findOne(location));
//		accoRepository.save(acco);
//		return "redirect:/acco";
//	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String postAdd(@ModelAttribute("acco") Acco acco){
		accoRepository.save(acco);
		return "redirect:/acco";
	}
}
