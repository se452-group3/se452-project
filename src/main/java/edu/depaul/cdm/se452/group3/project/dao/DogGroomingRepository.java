package edu.depaul.cdm.se452.group3.project.dao;

import edu.depaul.cdm.se452.group3.project.entities.DogGrooming;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DogGroomingRepository extends MongoRepository<DogGrooming, Integer> {
    //DogGrooming findById(int id);
}