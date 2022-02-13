package com.example.foodOrderApplication.service;

import com.example.foodOrderApplication.entity.Food;
import com.example.foodOrderApplication.entity.Hotel;
import com.example.foodOrderApplication.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public void addMenu(Food menu){
      foodRepository.save(menu);
    }

    public List<Food> foodList(Long id) {
        return foodRepository.findByHotelId(id);
    }

    public Food getById(Long id) {
        return foodRepository.getById(id);
    }
    public Optional<Food> getProductById(long id)
    {
        return foodRepository.findById(id);
    }
}
