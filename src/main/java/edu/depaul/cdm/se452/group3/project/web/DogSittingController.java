package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.entities.DogSitting;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.DogSittingService;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.depaul.cdm.se452.group3.project.dao.DogSittingRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class DogSittingController {
    @Autowired
    private DogSittingRepository dogSittingRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private DogSittingService dogSittingService;

    @GetMapping("/sitter")
    public String dogSitting(Model model){
        model.addAttribute("newSitting", new DogSitting());
        return "sitter";
    }

    @ModelAttribute("userProfile")
    public Profile currentProfile(){
        return profileService.getCurrentProfile();
    }

    @PostMapping("/sitter")
    public String addSitterJob(DogSitting sitter){
        dogSittingService.addDogSitting(sitter);
        return"redirect:/";
    }
}
