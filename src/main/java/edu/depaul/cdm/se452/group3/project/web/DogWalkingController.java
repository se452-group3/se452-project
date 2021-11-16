package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.entities.DogWalking;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.DogWalkingService;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.depaul.cdm.se452.group3.project.dao.DogWalkingRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DogWalkingController {
    @Autowired
    private DogWalkingRepository dogWalkingRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private DogWalkingService dogWalkingService;

    @Autowired
    private ShoppingCartService shoppingCartService;


    @GetMapping("/walk")
    public String walk(Model model){
        model.addAttribute("newWalking", new DogWalking());
        return "walk";
    }

    @ModelAttribute("userProfile")
    public Profile currentProfile(){
        return profileService.getCurrentProfile();
    }

    @ModelAttribute("cartSize")
    public void populateCartModel(Model model){
        model.addAttribute("cartSize", shoppingCartService.getCartSize());
    }

    @PostMapping("/walk")
    public String addWalkingJob(DogWalking walking){
        dogWalkingService.addWalking(walking);
        return "redirect:/";
    }
}
