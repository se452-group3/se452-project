package edu.depaul.cdm.se452.group3.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product implements Serializable {
    @Transient
    public static final String SEQ_NAME = "product_seq";

    @Id
    private int id;
    private String productName;
    private String productDescription;
    private String CategoryId;
    private double Price;
    private String imageURL;

}
