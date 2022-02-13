package com.example.foodOrderApplication.service;

import com.example.foodOrderApplication.entity.Customer;
import com.example.foodOrderApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Boolean existsById(String userName){
        return customerRepository.existsById(userName);
    }

    public Customer findCustomerByUserName(String userName){
        return customerRepository.getById(userName);
    }

    public Customer findById(String userName) {
        return customerRepository.findById(userName).get();
    }

    public Customer updateCustomer(Customer existingCustomer) {
        return customerRepository.save(existingCustomer);
    }
}
