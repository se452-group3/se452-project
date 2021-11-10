package edu.depaul.cdm.se452.group3.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {
    @Transient
    public static final String SEQ_NAME = "product_seq";

    @Id
    private int id;
    private String productName;
    private String productDescription;
    private String CategoryId;
    private int Price;
    private String imageURL;

}
