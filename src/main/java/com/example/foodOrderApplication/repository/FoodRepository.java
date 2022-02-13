package com.example.foodOrderApplication.repository;

import com.example.foodOrderApplication.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food> findByHotelId(Long id);
}
