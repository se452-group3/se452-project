package edu.depaul.cdm.se452.group3.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.depaul.cdm.se452.group3.project.dao.DogWalkingRepository;

@Controller
public class DogWalkingController {
    @Autowired
    private DogWalkingRepository dogWalkingRepository;
    
    @GetMapping("/walk")
    public String walk(Model model){
        return "walk";
    }
}
