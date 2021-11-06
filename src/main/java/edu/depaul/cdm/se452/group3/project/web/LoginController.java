package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.dao.UserRepository;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.entities.User;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

//Login user and password is admin/password
@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        String errorMsg = null;
        if(error != null) {
            errorMsg = "Invalid user or password";
        }
        model.addAttribute("error", errorMsg);
        return "login";
    }

    @GetMapping("/create-account")
    public String getResetPasswordPage(@RequestParam(value = "error", required = false) String error, Model model) {
        String errorMsg = null;
        if(error != null) {
            errorMsg = "Username exist choose another one";
        }
        model.addAttribute("error", errorMsg);

        User newUser = new User();
        Profile newProfile = new Profile();
        model.addAttribute("newUser", newUser);
        model.addAttribute("newProfile", newProfile);
        return "/create-account";
    }

    @PostMapping("/create-account")
    public String addUser(User user, Profile profile) {
        if(userRepository.findByusername(user.getUsername()).isEmpty()){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            user.setUsertype("User");
            user.setUuid(UUID.randomUUID());
            user.setPassword(encoder.encode(user.getPassword()));
            userService.addUserToDatabase(user);

            profile.setUid(user.getId());
            profileService.addProfileToDatabase(profile);
            return "redirect:/login";
        }
        else
            return "redirect:/create-account?error=true";
    }
}
