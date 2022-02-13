package com.example.foodOrderApplication.global;

import com.example.foodOrderApplication.entity.Food;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Food> cart;
    static {
        cart = new ArrayList<Food>();

    }
}