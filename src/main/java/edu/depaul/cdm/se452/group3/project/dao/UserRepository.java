package edu.depaul.cdm.se452.group3.project.dao;

import edu.depaul.cdm.se452.group3.project.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Interface User repository using the extends CrudRepository<User, Integer> in the class will allow us to call all the built-in CRUD functions
public interface UserRepository extends CrudRepository<User, Integer> {
    User findById(int id);

    Optional<User> findByusername(String username);
}
