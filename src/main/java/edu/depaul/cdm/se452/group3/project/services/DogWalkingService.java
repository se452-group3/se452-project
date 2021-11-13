package edu.depaul.cdm.se452.group3.project.services;
import edu.depaul.cdm.se452.group3.project.dao.DogWalkingRepository;
import edu.depaul.cdm.se452.group3.project.entities.DogWalking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogWalkingService {
    
    @Autowired
    private DogWalkingRepository dogWalkingRepository;

    @Autowired
    private SeqGeneratorService seqGeneratorService;

    public void addWalking(DogWalking walking){
        walking.setId(seqGeneratorService.getSeq(walking.SEQ_NAME));
        dogWalkingRepository.save(walking);
    }


}
