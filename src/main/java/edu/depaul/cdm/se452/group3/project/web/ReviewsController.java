package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.dao.ReviewsRepository;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.entities.Reviews;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.ReviewsService;
import edu.depaul.cdm.se452.group3.project.services.ShoppingCartService;
import edu.depaul.cdm.se452.group3.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private ReviewsService reviewsService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping
    public String reviews (Model model) {
        List<Reviews> reviews = new ArrayList<>();
        reviewsRepository.findAll().forEach(review -> reviews.add(review));

        return "reviews";
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
