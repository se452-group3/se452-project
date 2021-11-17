package edu.depaul.cdm.se452.group3.project.services;

import edu.depaul.cdm.se452.group3.project.entities.Product;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class ShoppingCartService {
    private List<Product> cart = new ArrayList<>();

    public void addToCart(Product product){
        cart.add(product);

    }
    public List<Product> getCart(){
        return cart;
    }

    public int getCartSize(){
        if (cart.isEmpty()){
            return 0;
        }
        else{
            return cart.size();
        }
    }

    public void clearCart(){
        cart.clear();
    }

    public void deleteItem(int index){
        cart.remove(index);
    }

    public double getTotal (){
        DecimalFormat format = new DecimalFormat("0.00");
        double total = 0;
        for(Product product : cart){
            double productPrice = product.getPrice();
            total += productPrice;
        }
        return  Double.parseDouble(format.format(total));
    }

}
