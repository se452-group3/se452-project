package edu.depaul.cdm.se452.group3.project.services;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import edu.depaul.cdm.se452.group3.project.dao.DogGroomingRepository;
import edu.depaul.cdm.se452.group3.project.entities.DogGrooming;

@Service
public class DogGroomingService {

    @Autowired
    private DogGroomingRepository dogGroomingRepository;

    @Autowired
    private SeqGeneratorService seqGeneratorService;

    // function for the html to call
    // creates and adds a dogGrooming object to the database
    public void addDogGrooming(DogGrooming dogGrooming){


        // generate ID for our object
        // (by using another service)
        dogGrooming.setId(seqGeneratorService.getSeq(dogGrooming.SEQ_NAME));


        // grabbing the date from the html form
        // (formatting it for the database before actually adding)
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date groomingDate = new Date();
        try { groomingDate = (Date) formatter.parse(dogGrooming.getJobDateHolder()); }
        catch (ParseException e) { e.printStackTrace(); }
        // officially setting the date
        long tempTime = groomingDate.getTime();
        dogGrooming.setJobDate(new Timestamp(tempTime));


        // done, save the new dogGrooming object to the database
        dogGroomingRepository.save(dogGrooming);
    }

}
