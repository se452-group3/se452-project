package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private int uid;
    private String bio;
    private String pictureUrl;
    private String address;
    private String firstname;
    private String lastname;
    private int rating;
    private String review;

}
