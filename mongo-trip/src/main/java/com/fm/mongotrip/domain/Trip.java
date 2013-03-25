package com.fm.mongotrip.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Trip {
	
	@Id
	private String id;
	private String name;
	@DBRef
	private Itinerary itinerary;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date arrivalDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departureDate;
	private String travelAgencyId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public String getTravelAgencyId() {
		return travelAgencyId;
	}
	public void setTravelAgencyId(String travelAgencyId) {
		this.travelAgencyId = travelAgencyId;
	}
	public Itinerary getItinerary() {
		return itinerary;
	}
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	
	



}
