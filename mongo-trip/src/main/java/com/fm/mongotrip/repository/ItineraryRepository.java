package com.fm.mongotrip.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fm.mongotrip.domain.Itinerary;

public interface ItineraryRepository extends MongoRepository<Itinerary, String> {

}
