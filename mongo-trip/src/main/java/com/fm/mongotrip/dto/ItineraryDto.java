package com.fm.mongotrip.dto;

import java.util.List;

import org.springframework.util.AutoPopulatingList;

import com.fm.mongotrip.domain.ItineraryDay;

public class ItineraryDto {
	
	private String id;
	private List<ItineraryDay> days = new AutoPopulatingList<ItineraryDay>(ItineraryDay.class);
	private List<String> locationIds = new AutoPopulatingList<String>(String.class);
	
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
	public List<String> getLocationIds() {
		return locationIds;
	}
	public void setLocationIds(List<String> locationIds) {
		this.locationIds = locationIds;
	}
	

}
