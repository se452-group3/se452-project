package edu.depaul.cdm.se452.group3.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.depaul.cdm.se452.group3.project.dao.DogSittingRepository;

@Controller
public class DogSittingController {
    @Autowired
    private DogSittingRepository dogSittingRepository;

    @GetMapping("/sitter")
    public String dogSitting(Model model){
        return "sitter";
    } 
}
