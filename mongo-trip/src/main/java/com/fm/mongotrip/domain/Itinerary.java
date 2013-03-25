package com.fm.mongotrip.domain;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Itinerary {
	
	@Id
	private String id;
	private List<ItineraryDay> days;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<ItineraryDay> getDays() {
		return days;
	}
	public void setDays(List<ItineraryDay> days) {
		this.days = days;
	}
	
	
	
	

}
