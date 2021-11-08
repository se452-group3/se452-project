package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.depaul.cdm.se452.group3.project.dao.DogSittingRepository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DogSittingController {
    @Autowired
    private DogSittingRepository dogSittingRepository;

    @Autowired
    private ProfileService profileService;

    @GetMapping("/sitter")
    public String dogSitting(Model model){
        return "sitter";
    }

    @ModelAttribute("userProfile")
    public Profile currentProfile(){
        return profileService.getCurrentProfile();
    }
}
