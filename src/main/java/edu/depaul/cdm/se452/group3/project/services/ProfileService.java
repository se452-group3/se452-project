package edu.depaul.cdm.se452.group3.project.services;

import edu.depaul.cdm.se452.group3.project.dao.ProfileRepository;
import edu.depaul.cdm.se452.group3.project.dao.UserRepository;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profilerepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UserService userService;

    public Profile addProfileToDatabase(Profile profile) {
        profilerepo.save(profile);
        return profile;
    }

    public Profile getCurrentProfile() {
        User user = userService.getCurrentUserObject();
        Profile profile = profileRepository.findFirstByuid(user.getId());
        return profile;
    }
}
