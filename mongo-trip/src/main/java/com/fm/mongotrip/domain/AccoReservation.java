package com.fm.mongotrip.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class AccoReservation {
	@Id
	private String id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date inDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date outDate;
	@DBRef
	private Acco acco;
	@DBRef
	private Location location;
	@DBRef
	private Trip trip;
	private List<Map<String, Boolean>> eatings;
	
	private String comment;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public Acco getAcco() {
		return acco;
	}
	public void setAcco(Acco acco) {
		this.acco = acco;
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
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public List<Map<String, Boolean>> getEatings() {
		return eatings;
	}
	public void setEatings(List<Map<String, Boolean>> eatings) {
		this.eatings = eatings;
	}
	
	

}
