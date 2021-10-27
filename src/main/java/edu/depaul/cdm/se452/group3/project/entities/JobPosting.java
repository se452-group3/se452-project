package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "job_posting")
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String ownerName;
    public String jobDescp;
    public Timestamp jobDate;
    public String jobLocation;
    public int offers;

}
