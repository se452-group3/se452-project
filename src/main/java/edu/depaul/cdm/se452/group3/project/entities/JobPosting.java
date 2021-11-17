package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "jobposting")
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String ownername;
    public String jobdescp;
    private String jobdateholder;
    public Timestamp jobdate;
    public String joblocation;
    public int offers;

}
