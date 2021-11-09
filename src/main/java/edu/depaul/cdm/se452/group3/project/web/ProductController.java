package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.dao.ProductRepository;
import edu.depaul.cdm.se452.group3.project.entities.Product;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/new")
    public String product(Model model) {
        return "product";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        System.out.println(product);
        return "product";
    }

    @ModelAttribute("userProfile")
    public Profile currentProfile(){
        return profileService.getCurrentProfile();
    }
}
