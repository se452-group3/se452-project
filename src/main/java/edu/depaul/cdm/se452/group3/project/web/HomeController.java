package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//These are the controllers that we use map the URL directory and to pass data to the HTML to use. We can use the services files to
//update the database and to lookup data for the controller to pass to HTML
@Controller
public class HomeController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
}
