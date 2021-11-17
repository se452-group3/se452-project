package edu.depaul.cdm.se452.group3.project.entities;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int RID;
    private int UID;
    private int PID;
    public String comment;
    public int rating;


}
