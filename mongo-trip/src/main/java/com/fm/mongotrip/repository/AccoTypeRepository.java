package com.fm.mongotrip.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fm.mongotrip.domain.AccoType;

public interface AccoTypeRepository extends MongoRepository<AccoType, String> {

}
