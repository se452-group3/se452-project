package edu.depaul.cdm.se452.group3.project.dao;

import edu.depaul.cdm.se452.group3.project.entities.DogParty;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DogPartyRepository  extends MongoRepository<DogParty, Integer> {
    //DogParty findById(int id);
}
