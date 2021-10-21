package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

//This is where we define the objects for our tables

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    private int id;
    private String uuid;
    private String userName;
    private String password;
    private String userType;
}
