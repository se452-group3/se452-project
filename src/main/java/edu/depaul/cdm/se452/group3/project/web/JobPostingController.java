package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.dao.DogSittingRepository;
import edu.depaul.cdm.se452.group3.project.dao.DogWalkingRepository;
import edu.depaul.cdm.se452.group3.project.dao.JobPostingRepository;
import edu.depaul.cdm.se452.group3.project.entities.JobPosting;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JobPostingController {
    @Autowired
    private JobPostingRepository jobPostingRepository;

    @Autowired
    private JobPostingService jobPostingService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private DogSittingRepository dogSittingRepository;

    @Autowired
    private DogSittingService dogSittingService;

    @Autowired
    private DogWalkingRepository dogWalkingRepository;
    @Autowired
    private DogWalkingService dogWalkingService;


    @GetMapping("/jobposting")
    public String jobs (Model model){
        List<JobPosting> jobs = new ArrayList<>();
        jobPostingRepository.findAll().forEach(job -> jobs.add(job));

        model.addAttribute("jobs", jobs);

        return "jobposting";
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
