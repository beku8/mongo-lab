package com.fm.mongotrip.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fm.mongotrip.domain.Location;

public interface LocationRepository extends MongoRepository<Location, String> {

}
