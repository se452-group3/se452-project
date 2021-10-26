package edu.depaul.cdm.se452.group3.project.entities;

import java.sql.Timestamp;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dogWalking")
public class DogWalking {
    @Id
    private int walkingId;
    private Timestamp jobDate;
    private String jobDescption;
    private String jobLocation;
    private int totalDistance;
}
