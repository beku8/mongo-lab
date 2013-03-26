package com.fm.mongotrip.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fm.mongotrip.domain.Acco;

public interface AccoRepository extends MongoRepository<Acco, String> {

}
