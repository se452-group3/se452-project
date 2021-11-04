package edu.depaul.cdm.se452.group3.project.dao;

import edu.depaul.cdm.se452.group3.project.entities.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
    Profile findFirstByuid(int uid);
}
