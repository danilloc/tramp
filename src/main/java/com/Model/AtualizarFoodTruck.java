package com.Model;

import com.DAO.FoodTruckDAO;
import com.Model.FoodTruck;

import java.util.Optional;

public class AtualizarFoodTruck {
    public static void main(String[] args) {
        FoodTruckDAO dao = new FoodTruckDAO();

        dao.findById(5);
        Optional<FoodTruck> foodTruckOptional = dao.findById(5);

        FoodTruck foodTruck = foodTruckOptional.get();
        System.out.println(foodTruck.getId()) ;

        dao.update(foodTruck);
    }
}
