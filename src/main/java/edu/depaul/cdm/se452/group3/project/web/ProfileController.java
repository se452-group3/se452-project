package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.dao.ProfileRepository;
import edu.depaul.cdm.se452.group3.project.dao.UserRepository;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.entities.User;
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
public class ProfileController {
    @Autowired
    private UserService userServ;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/editprofile")
    public String profile(Model model) {
        User user = userServ.getCurrentUserObject();
        Profile profile = profileRepository.findFirstByuid(user.getId());
        model.addAttribute("userProfile", profile);
        return "editprofile";
    }

    @PostMapping("/editprofile/update")
    public String editProfile(Profile updatedProfile, Model model) {
        User currentUser = userServ.getCurrentUserObject();
        Profile currentProfile = profileRepository.findFirstByuid(currentUser.getId());
        updatedProfile.setPid(currentProfile.getPid());
        updatedProfile.setUid(currentUser.getId());
        profileRepository.save(updatedProfile);
        return "redirect:/editprofile";
    }

    @ModelAttribute("cartSize")
    public void populateCartModel(Model model){
        model.addAttribute("cartSize", shoppingCartService.getCartSize());
    }
}
