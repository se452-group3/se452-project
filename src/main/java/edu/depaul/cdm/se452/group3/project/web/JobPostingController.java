package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.entities.JobPosting;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.ShoppingCartService;
import edu.depaul.cdm.se452.group3.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobPostingController {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartService shoppingCartService;


    @GetMapping("/jobposting")
    public String jobs (Model model) {
        model.addAttribute("newJob", new JobPosting());
        return "jobposting";
    }

    @PostMapping("/jobposting")
    public String addJobs (){
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
