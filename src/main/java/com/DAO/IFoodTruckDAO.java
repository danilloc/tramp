package com.DAO;

import com.Model.FoodTruck;

import java.util.List;
import java.util.Optional;

public interface IFoodTruckDAO {

    FoodTruck save(FoodTruck foodTruck);
    FoodTruck update(FoodTruck foodTruck);
    void delete (int id);
    List<FoodTruck> findAll();
    Optional<FoodTruck> findById(int id);

}
