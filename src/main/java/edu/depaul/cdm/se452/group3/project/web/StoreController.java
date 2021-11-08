package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.dao.ProductRepository;
import edu.depaul.cdm.se452.group3.project.entities.Product;
import edu.depaul.cdm.se452.group3.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/store")
    public String home(Model model) {
        List<Product> allProducts = new ArrayList<>();
        productRepository.findAll().forEach(product -> allProducts.add(product));

        model.addAttribute("allProducts", allProducts);
        return "store";
    }
}
