package edu.depaul.cdm.se452.group3.project.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.depaul.cdm.se452.group3.project.entities.DogSitting;

public interface DogSittingRepository extends MongoRepository<DogSitting, Integer>{
    DogSitting addDogSitting(DogSitting dogSitting);
}
