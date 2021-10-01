package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//This is where we define the objects for our tables

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    private int id;

    private String firstname;
    private String lastname;
}
