package edu.depaul.cdm.se452.group3.project.entities;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dogsitting")
public class DogSitting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp jobDate;
    private String jobDescption;
    private String jobLocation;
    private int serviceLevel;
}
