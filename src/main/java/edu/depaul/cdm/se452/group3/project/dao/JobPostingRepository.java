package edu.depaul.cdm.se452.group3.project.dao;

import edu.depaul.cdm.se452.group3.project.entities.JobPosting;
import org.springframework.data.repository.CrudRepository;

public interface JobPostingRepository extends CrudRepository<JobPosting, Integer> {

}
