package com.Model;

import com.DAO.FoodTruckDAO;

public class RemoverFoodTruck {
    public static void main(String[] args) {

        FoodTruckDAO dao = new FoodTruckDAO();

        dao.delete(3);
    }
}
