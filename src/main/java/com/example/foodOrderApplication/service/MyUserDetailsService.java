package com.example.foodOrderApplication.service;

import com.example.foodOrderApplication.entity.Customer;
import com.example.foodOrderApplication.entity.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    public CustomerService customerService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        System.out.println(username);
        Customer user=customerService.findById(username);
        System.out.println(user.getUserName());
        return new MyUserDetails(user);
    }
}
