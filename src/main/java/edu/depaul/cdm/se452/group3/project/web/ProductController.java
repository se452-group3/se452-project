package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.dao.ProductRepository;
import edu.depaul.cdm.se452.group3.project.entities.Product;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.ProductService;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/product/new")
    public String product(Model model) {
        model.addAttribute("newProduct", new Product());
        return "product";
    }

    @PostMapping("/product/new")
    public String addProduct(Product product){
        productService.productSave(product);
        return "redirect:/store";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productRepository.findById(id);
        model.addAttribute("newProduct", product);
        return "product-edit";
    }

    @PostMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Product product) {
        Product findProduct = productRepository.findById(id);
        findProduct.setImageURL(product.getImageURL());
        findProduct.setProductName(product.getProductName());
        findProduct.setProductDescription(product.getProductDescription());
        findProduct.setPrice(product.getPrice());
        findProduct.setCategoryId(product.getCategoryId());

        productService.productSave(findProduct);
        return "redirect:/store";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model, @RequestParam(value = "filter", required = false) String filter) {
        productRepository.delete(productRepository.findById(id));
        if(filter != null){
            return  "redirect:/store?filter=" + filter;
        }
        else
            return "redirect:/store";
    }

    @ModelAttribute("userProfile")
    public Profile currentProfile(){
        return profileService.getCurrentProfile();
    }
    @ModelAttribute("cartSize")

    public void populateCartModel(Model model){
        model.addAttribute("cartSize", shoppingCartService.getCartSize());
    }
}
