package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "dog_grooming")
public class DogGrooming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int          id;

    public int          userID;
    public int          providerID;
    public String       jobDescp;
    public Timestamp    jobDate;
    public String       jobLocation;
    public int          serviceLevel;

}