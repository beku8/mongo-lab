package com.fm.mongotrip.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.AutoPopulatingList;

import com.fm.mongotrip.domain.AccoReservation;

public class AccoReservationDto {
	
	private String id;
	private AccoReservation accoReservation;
	@SuppressWarnings("unchecked")
	private List<Map<String, Boolean>> eatings = new AutoPopulatingList<Map<String,Boolean>>((Class<? extends HashMap<String, Boolean>>) HashMap.class);
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AccoReservation getAccoReservation() {
		return accoReservation;
	}
	public void setAccoReservation(AccoReservation accoReservation) {
		this.accoReservation = accoReservation;
	}
	public List<Map<String, Boolean>> getEatings() {
		return eatings;
	}
	public void setEatings(List<Map<String, Boolean>> eatings) {
		this.eatings = eatings;
	}
	
	

}
