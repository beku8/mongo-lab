package com.fm.mongotrip.web;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fm.mongotrip.domain.AccoReservation;
import com.fm.mongotrip.domain.AccoType;
import com.fm.mongotrip.domain.Location;
import com.fm.mongotrip.dto.AccoReservationDto;
import com.fm.mongotrip.repository.AccoRepository;
import com.fm.mongotrip.repository.AccoReservationRepository;
import com.fm.mongotrip.repository.AccoTypeRepository;
import com.fm.mongotrip.repository.LocationRepository;
import com.fm.mongotrip.repository.TripRepository;
import com.fm.mongotrip.util.DateUtil;

@Controller
@RequestMapping("/accoReservation")
public class AccoReservationController {
	
	@Autowired private AccoReservationRepository accoReservationRepository;
	@Autowired private AccoRepository accoRepository;
	@Autowired private AccoTypeRepository accoTypeRepository;
	@Autowired private LocationRepository locationRepository;
	@Autowired private TripRepository tripRepository;
	
	@RequestMapping(value="/add/{accoType}/{tripId}/{locationId}/{startDate}/{endDate}",method=RequestMethod.GET)
	public String getAdd(Model model,@PathVariable("accoType") String accoTypeType,
			@PathVariable("tripId") String tripId, @PathVariable("locationId") String locationId,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
		AccoType accoType = accoTypeRepository.findOne(accoTypeType);
		Location location = locationRepository.findOne(locationId);
		model.addAttribute("accos", accoRepository.findByAccoTypeAndLocation(accoType, location));
		
		AccoReservationDto accoReservationDto = new AccoReservationDto();
		Integer totalDays = DateUtil.getDaysBetween(DateUtil.parseISO(startDate), DateUtil.parseISO(endDate));
		Map<String, Boolean> eatingMap = accoType.getDefaultEatingMap();
		for (int i = 0; i < totalDays; i++) {
			accoReservationDto.getEatings().add(eatingMap);
		}
		model.addAttribute(accoReservationDto);
		model.addAttribute("eatingTypes", eatingMap.keySet());
		return "accoreservationadd";
	}
	
	@RequestMapping(value="/add/{accoType}/{tripId}/{locationId}/{startDate}/{endDate}",method=RequestMethod.POST)
	public String postAdd(Model model,
			@ModelAttribute("accoReservationDto") AccoReservationDto accoReservationDto,
			@PathVariable("accoType") String accoTypeType,
			@PathVariable("tripId") String tripId, @PathVariable("locationId") String locationId,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
		AccoReservation accoReservation = accoReservationDto.getAccoReservation();
		accoReservation.setLocation(locationRepository.findOne(locationId));
		accoReservation.setTrip(tripRepository.findOne(tripId));
		accoReservation.setInDate(DateUtil.parseISO(startDate));
		accoReservation.setOutDate(DateUtil.parseISO(endDate));
		accoReservation.setEatings(accoReservationDto.getEatings());
	
		accoReservationRepository.save(accoReservation);
		
		return "redirect:/trip/detail/" + tripId;
	}
	

	

}
