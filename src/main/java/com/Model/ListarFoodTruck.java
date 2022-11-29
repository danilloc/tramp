package com.Model;

import com.DAO.FoodTruckDAO;
import com.Model.FoodTruck;

import java.util.Optional;

public class ListarFoodTruck {

    public static void main(String[] args) {
        FoodTruckDAO dao = new FoodTruckDAO();

//       List<FoodTruck> foodTruck2 = dao.findAll();
//
//        for(FoodTruck foodTruck : foodTruck2){
//            System.out.println("id :" + foodTruck.getId());
//            System.out.println("nome :" + foodTruck.getNome());
//            System.out.println("telefone :" + foodTruck.getTelefone());
//            System.out.println("ramo de atuacao : " + foodTruck.getRamoAtuacao());
//            System.out.println(" Localizacao :" + foodTruck.getLocalDeFuncionamento());
//            System.out.println("==============================================");
//        }

       Optional<FoodTruck> foodTruckOptional = dao.findById(5);
       foodTruckOptional.ifPresent(foodTruck -> {
           System.out.println("id :" + foodTruck.getId());
            System.out.println("nome :" + foodTruck.getNome());
            System.out.println("telefone :" + foodTruck.getTelefone());
            System.out.println("ramo de atuacao : " + foodTruck.getRamoAtuacao());
            System.out.println(" Localizacao :" + foodTruck.getLocalDeFuncionamento());
            System.out.println("==============================================");
       });

    }
}

