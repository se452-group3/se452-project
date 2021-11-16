package edu.depaul.cdm.se452.group3.project.services;

import edu.depaul.cdm.se452.group3.project.dao.JobPostingRepository;
import edu.depaul.cdm.se452.group3.project.entities.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    public void addJobPosing(JobPosting jobPosting) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date jobDate = new Date();
        try {
            jobDate = (Date) formatter.parse(jobPosting.getJobdateholder());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        jobPosting.setJobdate(new Timestamp(jobDate.getTime()));
        jobPostingRepository.save(jobPosting);
    }
}

