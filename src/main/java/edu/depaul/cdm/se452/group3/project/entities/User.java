package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

//This is where we define the objects for our tables

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private UUID uuid;
    private String username;
    private String password;
    private String usertype;

}
