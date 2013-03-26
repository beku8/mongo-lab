package com.fm.mongotrip.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AccoType {
	
	@Id
	private String type;
	
	private Boolean bf = false;
	private Boolean lunch = false;
	private Boolean dinner = false;
	private Boolean pf = false;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getBf() {
		return bf;
	}
	public void setBf(Boolean bf) {
		this.bf = bf;
	}
	public Boolean getLunch() {
		return lunch;
	}
	public void setLunch(Boolean lunch) {
		this.lunch = lunch;
	}
	public Boolean getDinner() {
		return dinner;
	}
	public void setDinner(Boolean dinner) {
		this.dinner = dinner;
	}
	public Boolean getPf() {
		return pf;
	}
	public void setPf(Boolean pf) {
		this.pf = pf;
	}
	
	
}
