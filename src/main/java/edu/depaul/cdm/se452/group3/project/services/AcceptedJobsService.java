package edu.depaul.cdm.se452.group3.project.services;

import edu.depaul.cdm.se452.group3.project.dao.AcceptedJobsRepository;
import edu.depaul.cdm.se452.group3.project.entities.AcceptedJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcceptedJobsService {

    @Autowired
    private AcceptedJobsRepository acceptedJobsRepository;

    public Optional<AcceptedJobs> getAcceptedJobs(int jobid) {
        Optional<AcceptedJobs> acceptedJob = acceptedJobsRepository.findById(jobid);
        return acceptedJob;
    }
}
