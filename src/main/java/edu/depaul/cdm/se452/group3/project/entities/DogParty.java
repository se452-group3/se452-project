package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "DogParty")
public class DogParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int          id;

    public Timestamp    partyDate;
    public String       partyLocation;
    public int          numRSVP;

}