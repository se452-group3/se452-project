package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class FragmentsController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/fragments/header")
    public String home(Model model) {
        return "/fragments/header";
    }

    @ModelAttribute
    public Profile currentProfile(){
        return profileService.getCurrentProfile();
    }

    @ModelAttribute("userProfiles")
    public void populateModel(Model model){
        model.addAttribute("userProfile", currentProfile());
    }
}
