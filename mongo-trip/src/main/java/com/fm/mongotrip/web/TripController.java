package com.fm.mongotrip.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.mongotrip.domain.Itinerary;
import com.fm.mongotrip.domain.ItineraryDay;
import com.fm.mongotrip.domain.Location;
import com.fm.mongotrip.domain.Trip;
import com.fm.mongotrip.dto.ItineraryDto;
import com.fm.mongotrip.repository.AccoReservationRepository;
import com.fm.mongotrip.repository.AccoTypeRepository;
import com.fm.mongotrip.repository.ItineraryRepository;
import com.fm.mongotrip.repository.LocationRepository;
import com.fm.mongotrip.repository.TripRepository;

@Controller
@RequestMapping("/trip")
public class TripController {
	
	@Autowired private TripRepository tripRepository;
	@Autowired private LocationRepository locationRepository;
	@Autowired private ItineraryRepository itineraryRepository;
	@Autowired private AccoTypeRepository accoTypeRepository;
	@Autowired private AccoReservationRepository accoReservationRepository;
	
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
	
	@RequestMapping("/detail/{id}")
	public String getDetail(@PathVariable("id") String id, Model model){
		Trip trip = tripRepository.findOne(id);
		model.addAttribute(trip);
		model.addAttribute("accoReservations", accoReservationRepository.findByTrip(trip));
		return "tripdetail";
	}
	
	@RequestMapping(value="/addItinerary/{id}", method=RequestMethod.GET)
	public String getAddItinerary(@PathVariable("id") String id, Model model){
		Trip trip = tripRepository.findOne(id);
		ItineraryDto itineraryDto = new ItineraryDto();
		for (int i = 0; i <= trip.getTotalDays(); i++) {
			itineraryDto.getDays().add(new ItineraryDay());
		}
		model.addAttribute(itineraryDto);
		model.addAttribute("locations", locationRepository.findAll());
		model.addAttribute("accoTypes", accoTypeRepository.findAll());
		return "tripadditinerary";
	}
	
	@RequestMapping(value="/addItinerary/{id}", method=RequestMethod.POST)
	public String postAddItinerary(@PathVariable("id") String id, Model model,
			@ModelAttribute("itineraryDto") ItineraryDto itineraryDto){
		Itinerary itinerary = new Itinerary();
		List<ItineraryDay> itineraryDays = new ArrayList<ItineraryDay>();
		
		for (int i = 0; i < itineraryDto.getLocationIds().size(); i++) {
			Location location = locationRepository.findOne(itineraryDto.getLocationIds().get(i));
			ItineraryDay itineraryDay = itineraryDto.getDays().get(i);
			itineraryDay.setDay(i + 1);
			itineraryDay.setLocation(location);
			itineraryDays.add(itineraryDay);
		}
		
		itinerary.setDays(itineraryDays);
		itineraryRepository.save(itinerary);
		
		Trip trip = tripRepository.findOne(id);
		trip.setItinerary(itinerary);
		tripRepository.save(trip);
		
		model.addAttribute(itineraryDto);
		return "redirect:/trip/detail/" + id;
	}
	
	
	
	
	


}
