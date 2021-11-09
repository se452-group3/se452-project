package edu.depaul.cdm.se452.group3.project.web;

import ch.qos.logback.core.hook.DelayingShutdownHook;
import edu.depaul.cdm.se452.group3.project.dao.ProductRepository;
import edu.depaul.cdm.se452.group3.project.entities.Product;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
public class StoreController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProfileService profileService;

    @GetMapping("/store")
    public String home(@RequestParam(value = "filter", required = false) String filter, Model model) {
        List<Product> allProducts = new ArrayList<>();;
        productRepository.findAll().forEach(product -> allProducts.add(product));

        if(filter != null) {
            List<Product> products = allProducts.stream().filter(product -> product.getCategoryId().equalsIgnoreCase(filter)).collect(Collectors.toList());
            allProducts.clear();
            products.forEach(product -> allProducts.add(product));
            model.addAttribute("filter", filter);
        }

        model.addAttribute("allProducts", allProducts);
        return "store";
    }

    @ModelAttribute("userProfile")
    public Profile currentProfile(){
        return profileService.getCurrentProfile();
    }
}
