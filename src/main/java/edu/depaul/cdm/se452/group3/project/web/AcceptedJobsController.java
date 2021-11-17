package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.dao.AcceptedJobsRepository;
import edu.depaul.cdm.se452.group3.project.entities.AcceptedJobs;
import edu.depaul.cdm.se452.group3.project.entities.JobPosting;
import edu.depaul.cdm.se452.group3.project.entities.Product;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.ShoppingCartService;
import edu.depaul.cdm.se452.group3.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AcceptedJobsController {
    @Autowired
    private AcceptedJobsRepository acceptedJobsRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartService shoppingCartService;


    @GetMapping("/acceptedjobs")
    public String acceptedJobs (Model model) {
        List<AcceptedJobs> acceptedJobs = new ArrayList<>();
        acceptedJobsRepository.findAll().forEach(acceptedJob -> acceptedJobs.add(acceptedJob));

        model.addAttribute("acceptedJobs", acceptedJobs);


        return "acceptedjobs";
    }

    @ModelAttribute("userProfile")
    public Profile currentProfile(){
        return profileService.getCurrentProfile();
    }

    @ModelAttribute("cartSize")
    public void populateCartModel(Model model){
        model.addAttribute("cartSize", shoppingCartService.getCartSize());
    }


}