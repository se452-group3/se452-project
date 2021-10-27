package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobPostingController {



    @Autowired
    private UserService userService;


    @GetMapping("/job-postings")
    public String jobs (Model model) {
        return "jobposting";
    }
}
