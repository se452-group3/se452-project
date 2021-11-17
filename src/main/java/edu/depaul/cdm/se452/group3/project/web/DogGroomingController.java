package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.dao.DogGroomingRepository;
import edu.depaul.cdm.se452.group3.project.entities.DogGrooming;
import edu.depaul.cdm.se452.group3.project.entities.DogSitting;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.DogGroomingService;
import edu.depaul.cdm.se452.group3.project.services.DogSittingService;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.depaul.cdm.se452.group3.project.dao.DogSittingRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DogGroomingController {

    // RETRIEVING information for the header
    // (profile pic + shopping cart)
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProfileService profileService;

    // Setting up the database/service so the html can use it
    @Autowired
    private DogGroomingRepository dogGroomingRepository;
    @Autowired
    private DogGroomingService dogGroomingService;




    // GET
    // for initially loading the page
    @GetMapping("/grooming") // what url the server will generate this response
    public String dogGrooming(Model model){
        model.addAttribute("newGrooming", new DogGrooming()); // html page to respond with
        return "grooming";
    }
    // POST
    // for sending in the form
    @PostMapping("/grooming")
    public String addGroomingJob(DogGrooming grooming){
        dogGroomingService.addDogGrooming(grooming);
        return"redirect:/";
    }




    // functions for DELIVERING information needed for the header
    // (profile pic + shopping cart)
    @ModelAttribute("userProfile")
    public Profile currentProfile(){
        return profileService.getCurrentProfile();
    }
    @ModelAttribute("cartSize")
    public void populateCartModel(Model model){
        model.addAttribute("cartSize", shoppingCartService.getCartSize());
    }

}
