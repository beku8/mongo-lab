package com.fm.mongotrip.domain;

public class ItineraryDay {
	
	private Integer day;
	private Location location;
	private String comment;
	private String accoType;
	
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAccoType() {
		return accoType;
	}
	public void setAccoType(String accoType) {
		this.accoType = accoType;
	}
	
	
	

}
