package com.fm.mongotrip.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Acco {
	@Id
	private String id;
	@DBRef
	private AccoType accoType;
	@DBRef
	private Location location;
	private String name;
	
	
	public Boolean getHasEating(){
		if(accoType != null){
			if(accoType.getBf() || accoType.getDinner() || accoType.getLunch() || accoType.getPf()){
				return true;
			}
		}
		
		return false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AccoType getAccoType() {
		return accoType;
	}
	public void setAccoType(AccoType accoType) {
		this.accoType = accoType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
	
}
