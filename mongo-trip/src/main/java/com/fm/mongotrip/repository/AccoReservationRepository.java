package com.fm.mongotrip.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fm.mongotrip.domain.AccoReservation;
import com.fm.mongotrip.domain.Trip;

public interface AccoReservationRepository extends MongoRepository<AccoReservation, String> {
	
	List<AccoReservation> findByTrip(Trip trip);

}
