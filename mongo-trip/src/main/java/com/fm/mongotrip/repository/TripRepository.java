package com.fm.mongotrip.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fm.mongotrip.domain.Trip;

public interface TripRepository extends MongoRepository<Trip, String>{


}
