package edu.depaul.cdm.se452.group3.project.entities;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dogsitting")
public class DogSitting {
    @Transient
    public static final String SEQ_NAME = "sitter_seq";
    
    @Id
    private int id;
    private String jobDateHolder;
    private Timestamp jobDate;
    private String jobDescption;
    private String jobLocation;
    private int serviceLevel;

}
