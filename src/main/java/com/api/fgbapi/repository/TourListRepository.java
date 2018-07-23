package com.api.fgbapi.repository;

import com.api.fgbapi.model.TourList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TourListRepository extends MongoRepository<TourList, String> {
}
