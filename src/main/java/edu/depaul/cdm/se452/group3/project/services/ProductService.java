package edu.depaul.cdm.se452.group3.project.services;

import edu.depaul.cdm.se452.group3.project.dao.ProductRepository;
import edu.depaul.cdm.se452.group3.project.dao.UserRepository;
import edu.depaul.cdm.se452.group3.project.entities.MongoSeq;
import edu.depaul.cdm.se452.group3.project.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private SeqGeneratorService seqGeneratorService;

    public void productSave(Product product){
        if (product.getId() == 0)
            product.setId(seqGeneratorService.getSeq(product.SEQ_NAME));
        productRepo.save(product);

    }
}
