package edu.depaul.cdm.se452.group3.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "mongo_seq")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MongoSeq {
    @Id
    private String id;
    private int seq;
}
