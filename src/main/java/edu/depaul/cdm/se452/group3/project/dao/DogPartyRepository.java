package edu.depaul.cdm.se452.group3.project.dao;

import edu.depaul.cdm.se452.group3.project.entities.DogParty;
import org.springframework.data.repository.CrudRepository;

public interface DogPartyRepository  extends CrudRepository<DogParty, Integer> {
    DogParty findById(int id);
}
