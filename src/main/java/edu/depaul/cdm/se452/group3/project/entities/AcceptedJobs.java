package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "AcceptedJobs")
public class AcceptedJobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobID;
    private int ownerID;
    private int walkerID;
    private boolean jobLocal;

}
