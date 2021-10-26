package edu.depaul.cdm.se452.group3.project.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.depaul.cdm.se452.group3.project.entities.DogWalking;

public interface DogWalkingRepository extends MongoRepository<DogWalking, Integer>{
    DogWalking findByID(int id);
    DogWalking addWalker(DogWalking dogWalker);
    DogWalking deleteWalker(int id);
}
