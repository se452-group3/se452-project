package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ReviewsController {

    @Autowired
    private UserService userService;


    @GetMapping("/reviews")
    public String reviews (Model model) {
        return "reviews";
    }
}
