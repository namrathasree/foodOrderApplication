package com.example.foodOrderApplication.controller;

import com.example.foodOrderApplication.entity.Customer;
import com.example.foodOrderApplication.service.CustomerService;
import com.example.foodOrderApplication.service.FoodService;
import com.example.foodOrderApplication.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class CustomerController {
        @Autowired
        private CustomerService customerService;
        @Autowired
        private HotelService hotelService;
        @Autowired
        private FoodService foodService;

    //Home
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    //admin
    @RequestMapping("/adminHome")
    public String admin(){
        return "adminHome";
    }

    //Registration- after registering user will go to login page
    @GetMapping("/register")
    public String registrationForm() {
        return "register";
    }
    @PostMapping("/register")
    public String registration(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String phoneNumber=request.getParameter("phoneNumber");
        Customer customer;
        if(userName.equals("admin")){
            customer = new Customer(userName, name, address, password,phoneNumber,"ROLE_ADMIN");
        }
        else {
            customer = new Customer(userName, name, address, password,phoneNumber,"ROLE_USER");
        }
//        Customer customer = new Customer(userName, name, address, password,phoneNumber);
        customerService.createCustomer(customer);
        return "login";
    }

    //Login - after login user will go to the list of hotels page
    @RequestMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/hotels")
    public String hotels(Model model){
        model.addAttribute("hotels",hotelService.hotelList());
        return "hotels";
    }

    @GetMapping("/success")
    public String login(Principal principal) {
        String userName=principal.getName();
        if(userName.equals("admin")){
            return "redirect:/adminHome";
        }
        return "redirect:/hotels";
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        Customer customer;
//        if (customerService.existsById(userName)) {
//            customer = customerService.findCustomerByUserName(userName);
//            if (password.equals(customer.getPassword())) {
//                model.addAttribute("userName", userName);
//                model.addAttribute("hotels", hotelService.hotelList() );
//            } else {
//                model.addAttribute("message", "Wrong Password");
//                return "login";
//                //return "redirect:/login";
//            }
//        } else {
//            model.addAttribute("message", "Please enter valid User Name");
//            return "login";
//            //return "redirect:/login";
//        }
//        return "hotels";
    }


    @RequestMapping("/updateCustomerProfile")
    public String updateCustomerDetails(Principal principal, Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("customer",customerService.findById(principal.getName()));
        return "updateCustomerProfile";
    }


    @PostMapping("/restaurantDetails")
    public String updateCustomer(Principal principal,HttpServletRequest request,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        Customer existingCustomer= customerService.findById(request.getParameter("userName"));
        existingCustomer.setName(request.getParameter("name"));
//        existingCustomer.setEmail(request.getParameter("email"));
        existingCustomer.setAddress(request.getParameter("address"));
        existingCustomer.setPhoneNumber(request.getParameter("phoneNumber"));
        existingCustomer.setPassword(request.getParameter("password"));
        customerService.updateCustomer(existingCustomer);
        model.addAttribute("name",existingCustomer.getName());
        model.addAttribute("mobileNumber",existingCustomer.getPhoneNumber());
//        model.addAttribute("email",existingCustomer.getEmail());
        model.addAttribute("address",existingCustomer.getAddress());
        model.addAttribute("password",existingCustomer.getPassword());
        model.addAttribute("userName", existingCustomer.getUserName());
        return "redirect:/hotels";
    }

    @RequestMapping("/menu/{id}")
    public String viewMenu(Principal principal,@PathVariable Long id, HttpServletRequest request, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("menu",id);
        model.addAttribute("usermenu", foodService.foodList(id));
        return "menu";
    }
}
