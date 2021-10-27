package edu.depaul.cdm.se452.group3.project.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import edu.depaul.cdm.se452.group3.project.dao.DogSittingRepository;
import edu.depaul.cdm.se452.group3.project.entities.DogSitting;

@Service
public class DogSittingService {

    @Autowired
    private DogSittingRepository dogSittingRepository;
    
    public DogSitting addDogSitting(DogSitting dogSitting){
        dogSittingRepository.save(dogSitting);
        return dogSitting;
    }
}
