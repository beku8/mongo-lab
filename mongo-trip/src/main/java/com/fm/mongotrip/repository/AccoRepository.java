package com.fm.mongotrip.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fm.mongotrip.domain.Acco;
import com.fm.mongotrip.domain.AccoType;
import com.fm.mongotrip.domain.Location;

public interface AccoRepository extends MongoRepository<Acco, String> {
	
	List<Acco> findByAccoTypeAndLocation(AccoType accoType, Location location);

}
