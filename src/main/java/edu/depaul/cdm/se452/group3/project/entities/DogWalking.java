package edu.depaul.cdm.se452.group3.project.entities;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dogwalking")
public class DogWalking {
    @Transient
    public static final String SEQ_NAME = "walking_seq";

    @Id
    private int id;
    private Timestamp jobDate;
    private String jobDescption;
    private String jobLocation;
    private int totalDistance;
}
