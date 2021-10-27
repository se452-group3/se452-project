package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "acceptedjobs")
public class AcceptedJobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobid;
    private int ownerID;
    private int walkerID;
    private boolean joblocal;

}
