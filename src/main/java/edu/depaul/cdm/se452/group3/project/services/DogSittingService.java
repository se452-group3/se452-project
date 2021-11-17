package edu.depaul.cdm.se452.group3.project.services;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import edu.depaul.cdm.se452.group3.project.dao.DogSittingRepository;
import edu.depaul.cdm.se452.group3.project.entities.DogSitting;

@Service
public class DogSittingService {

    @Autowired
    private DogSittingRepository dogSittingRepository;

    @Autowired
    private SeqGeneratorService seqGeneratorService;
    
    public void addDogSitting(DogSitting dogSitting){
        dogSitting.setId(seqGeneratorService.getSeq(dogSitting.SEQ_NAME));

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date sittingDate = new Date();
        try {
            sittingDate = (Date) formatter.parse(dogSitting.getJobDateHolder());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dogSitting.setJobDate(new Timestamp(sittingDate.getTime()));
        dogSittingRepository.save(dogSitting);
    }
}
