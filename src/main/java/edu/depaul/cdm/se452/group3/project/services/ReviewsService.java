package edu.depaul.cdm.se452.group3.project.services;

import edu.depaul.cdm.se452.group3.project.dao.ReviewsRepository;
import edu.depaul.cdm.se452.group3.project.entities.Reviews;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewsService {
    @Autowired
    private ReviewsRepository reviewsRepository;

    public void addReview(Reviews review) {
        reviewsRepository.save(review);
    }

    public List<Reviews> findAll() {
        return (List<Reviews>) reviewsRepository.findAll();
    }
}
