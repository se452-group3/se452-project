package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "Profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private int uid;
    private String bio;
    private String pictureurl;
    private String address;
    private String firstname;
    private String lastname;
    private int rating;

}
