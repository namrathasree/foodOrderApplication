package com.example.foodOrderApplication.repository;

import com.example.foodOrderApplication.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

}
