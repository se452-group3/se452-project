package edu.depaul.cdm.se452.group3.project.services;

import edu.depaul.cdm.se452.group3.project.dao.UserRepository;
import edu.depaul.cdm.se452.group3.project.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Services will be used for CURD add data to database, delete data, lookup data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public String getCurrentUser() {
        User user = userRepo.findById(1);
        return user.getUserName();
    }

    //example of a function that will take a User object and save it to the database
    public User addUser(User user) {
        userRepo.save(user);
        return user;
    }
}
