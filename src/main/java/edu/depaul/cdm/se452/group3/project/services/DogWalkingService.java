package edu.depaul.cdm.se452.group3.project.services;
import edu.depaul.cdm.se452.group3.project.dao.DogWalkingRepository;
import edu.depaul.cdm.se452.group3.project.entities.DogWalking;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date walkingDate = new Date();
        try {
            walkingDate = (Date) formatter.parse(walking.getJobDateHolder());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        walking.setJobDate(new Timestamp(walkingDate.getTime()));
        dogWalkingRepository.save(walking);
    }


}
