package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.dao.DogPartyRepository;
import edu.depaul.cdm.se452.group3.project.entities.DogParty;

import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.DogPartyService;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DogPartyController {

    // RETRIEVING information for the header
    // (profile pic + shopping cart)
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProfileService profileService;

    // Setting up the database/service so the html can use it
    @Autowired
    private DogPartyRepository dogPartyRepository;
    @Autowired
    private DogPartyService dogPartyService;




    // GET
    // for initially loading the page
    @GetMapping("/party") // what url the server will generate this response
    public String dogParty(Model model){
        model.addAttribute("newParty", new DogParty()); // html page to respond with
        return "party";
    }
    // POST
    // for sending in the form
    @PostMapping("/party")
    public String addPartyJob(DogParty party){
        dogPartyService.addDogParty(party);
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