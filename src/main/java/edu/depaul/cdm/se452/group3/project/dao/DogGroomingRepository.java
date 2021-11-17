package edu.depaul.cdm.se452.group3.project.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.depaul.cdm.se452.group3.project.entities.DogGrooming;

public interface DogGroomingRepository extends MongoRepository<DogGrooming, Integer>{
    DogGrooming findById(int id);
}