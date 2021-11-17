package edu.depaul.cdm.se452.group3.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dogparty")
public class DogParty {
    @Transient // for automatically creating an id for this?
    public static final String SEQ_NAME = "party_seq";

    @Id // database key
    public int          id;

    // for changing the format of the date
    public String       jobDateHolder;
    public Timestamp    jobDate;
    // for sure used
    public String       jobDescription;
    public String       jobLocation;
    public int          serviceLevel;


}