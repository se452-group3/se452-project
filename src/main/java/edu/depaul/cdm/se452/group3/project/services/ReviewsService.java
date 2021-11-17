package edu.depaul.cdm.se452.group3.project.services;

import edu.depaul.cdm.se452.group3.project.dao.ReviewsRepository;
import edu.depaul.cdm.se452.group3.project.entities.Reviews;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewsService {
    @Autowired
    private ReviewsRepository reviewsRepository;

    public void addReview(Reviews review) {
        reviewsRepository.save(review);
    }
}
