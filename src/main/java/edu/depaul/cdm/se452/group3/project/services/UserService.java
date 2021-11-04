package edu.depaul.cdm.se452.group3.project.services;

import edu.depaul.cdm.se452.group3.project.dao.UserRepository;
import edu.depaul.cdm.se452.group3.project.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Services will be used for CURD add data to database, delete data, lookup data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getCurrentUserObject() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        Optional<User> user = userRepository.findByusername(userName);
        return user.get();
    }

    //example of a function that will take a User object and save it to the database
    public User addUserToDatabase(User user) {
        userRepository.save(user);
        return user;
    }
}
