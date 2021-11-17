package edu.depaul.cdm.se452.group3.project.services;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import edu.depaul.cdm.se452.group3.project.dao.DogPartyRepository;
import edu.depaul.cdm.se452.group3.project.entities.DogParty;

@Service
public class DogPartyService {

    @Autowired
    private DogPartyRepository dogGroomingRepository;
    @Autowired
    private SeqGeneratorService seqGeneratorService;

    // function for the html to call
    // creates and adds a dogGrooming object to the database
    public void addDogParty(DogParty dogParty){

        // generate ID for our object
        // (by using another service)
        dogParty.setId(seqGeneratorService.getSeq(dogParty.SEQ_NAME));

        // grabbing the date from the html form
        // (formatting it for the database before actually adding)
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date partyDate = new Date();
        try { partyDate = (Date) formatter.parse(dogParty.getJobDateHolder()); }
        catch (ParseException e) { e.printStackTrace(); }
        // officially setting the date
        dogParty.setJobDate(new Timestamp(  partyDate.getTime()  ));


        // done, save the new dogGrooming object to the database
        dogGroomingRepository.save(dogParty);
    }

}
