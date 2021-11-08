package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

public class ReviewsController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;


    @GetMapping("/reviews")
    public String reviews (Model model) {
        return "reviews";
    }

    @ModelAttribute("userProfile")
    public Profile currentProfile(){
        return profileService.getCurrentProfile();
    }
}
