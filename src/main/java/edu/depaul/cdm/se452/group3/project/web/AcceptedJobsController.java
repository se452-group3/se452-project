package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AcceptedJobsController {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;


    @GetMapping("/accepted_jobs")
    public String acceptedJobs (Model model) {
        return "acceptedjobs";
    }

    @ModelAttribute("userProfile")
    public Profile currentProfile(){
        return profileService.getCurrentProfile();
    }
}