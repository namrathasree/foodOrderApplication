package com.example.foodOrderApplication.repository;

import com.example.foodOrderApplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
