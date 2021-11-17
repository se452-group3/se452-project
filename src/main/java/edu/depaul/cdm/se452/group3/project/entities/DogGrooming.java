package edu.depaul.cdm.se452.group3.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data


@Entity
@Table(name = "dog_grooming")

@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "doggrooming")
public class DogGrooming {
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Transient // for automatically creating an id for this?
    public static final String SEQ_NAME = "grooming_seq";

    @Id // database key
    public int          id;

    // may not be actually used
    public int          userID;
    public int          providerID;

    // for changing the format of the date
    public String       jobDateHolder;
    public Timestamp    jobDate;
    // for sure used
    public String       jobDescription;
    public String       jobLocation;
    public int          serviceLevel;


}