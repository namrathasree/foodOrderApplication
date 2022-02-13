package com.example.foodOrderApplication.controller;

import com.example.foodOrderApplication.entity.Food;
import com.example.foodOrderApplication.global.GlobalData;
import com.example.foodOrderApplication.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class CartController {
    @Autowired
    FoodService foodService;
    @RequestMapping("/addToCart/{id}")
    public String addToCart(Principal principal, @PathVariable Long id, Model model)
    {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        GlobalData.cart.add(foodService.getProductById(id).get());
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Food::getPrice).sum());
        model.addAttribute("cart",GlobalData.cart);
        return "cart";
    }
    @GetMapping("/cart")
    public String cartGet(Model model,Principal principal)
    {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Food::getPrice).sum());
        model.addAttribute("cart",GlobalData.cart);
        return "redirect:/cart";
    }
    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index,Principal principal,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        GlobalData.cart.remove(index);
        return "redirect:/cart";

    }
    @RequestMapping("/checkout")
    public String checkout(Model model,Principal principal){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Food::getPrice).sum());
        return "payNow";

    }
}