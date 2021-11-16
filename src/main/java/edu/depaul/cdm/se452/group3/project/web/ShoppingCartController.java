package edu.depaul.cdm.se452.group3.project.web;

import edu.depaul.cdm.se452.group3.project.entities.Product;
import edu.depaul.cdm.se452.group3.project.entities.Profile;
import edu.depaul.cdm.se452.group3.project.services.ProductService;
import edu.depaul.cdm.se452.group3.project.services.ProfileService;
import edu.depaul.cdm.se452.group3.project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProfileService profileService;

    @GetMapping("/cart")
    public String Cart(Model model){
        model.addAttribute("cart", shoppingCartService.getCart());
        model.addAttribute("total", shoppingCartService.getTotal());
        return "cart";
    }

    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") int id){
        Product product = productService.getProduct(id);
        shoppingCartService.addToCart(product);
        return "redirect:/cart";
    }

    @GetMapping("/cart/delete/{index}")
    public String deleteFromCart(@PathVariable("index") int index){
        shoppingCartService.deleteItem(index);
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearCart(){
        shoppingCartService.clearCart();
        return "redirect:/cart";
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
