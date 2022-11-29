package com.DAO;

import com.Model.FoodTruck;
import com.Infra.ConnectionFactory;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FoodTruckDAO implements IFoodTruckDAO{
    public static final int INDICE_ID = 1;
    public static final int INDICE_NOME = 2;
    public static final int INDICE_TELEFONE = 3;
    public static final int INDICE_RAMO_ATUACAO = 4;
    public static final int INDICE_LOCAL_FUNCIONAMENTO = 5;


    @Override
    public FoodTruck save(FoodTruck foodTruck) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO tbl_adicionarft ( nome, telefone,ramo_atuacao, local_funcionamento) VALUES(?, ?, ?, ?)";
           PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           preparedStatement.setString(1, foodTruck.getNome());
           preparedStatement.setInt(2, foodTruck.getTelefone());
           preparedStatement.setString(3,foodTruck.getRamoAtuacao());
           preparedStatement.setString(4, foodTruck.getLocalDeFuncionamento());

           preparedStatement.executeUpdate();

           ResultSet resultSet = preparedStatement.getGeneratedKeys();
           resultSet.next();

           int generatedId = resultSet.getInt(INDICE_ID);
           foodTruck.setId(generatedId);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foodTruck;
    }

    @Override
    public FoodTruck update(FoodTruck foodTruck) {

        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE tbl_adicionarft SET nome = ?, telefone = ? ,ramo_atuacao =?, local_funcionamento = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, foodTruck.getNome());
            preparedStatement.setInt(2, foodTruck.getTelefone());
            preparedStatement.setString(3,foodTruck.getRamoAtuacao());
            preparedStatement.setString(4, foodTruck.getLocalDeFuncionamento());
            preparedStatement.setInt(5, foodTruck.getId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foodTruck;
    }

    @Override
    public void delete(int id) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM  WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<FoodTruck> findAll() {
        String sql = "SELECT id,nome, telefone,ramo_atuacao, local_funcionamento FROM tbl_adicionarft ";

        List<FoodTruck> foodTruck = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           ResultSet rs =  preparedStatement.executeQuery();

            while(rs.next()){

                FoodTruck foodTruck1 =  new FoodTruck(rs.getInt(INDICE_ID),rs.getString(INDICE_NOME),
                 rs.getInt(INDICE_TELEFONE), rs.getString(INDICE_RAMO_ATUACAO),
                        rs.getString(INDICE_LOCAL_FUNCIONAMENTO));
                foodTruck.add(foodTruck1);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;
        return foodTruck;
    }

    @Override
    public Optional<FoodTruck> findById(int id) {
        String sql = "SELECT id,nome, telefone,ramo_atuacao, local_funcionamento FROM tbl_adicionarft WHERE id = ?";

        FoodTruck foodTruck = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                FoodTruck foodTruck1 = new FoodTruck(
                        rs.getInt(INDICE_ID),
                        rs.getString(INDICE_NOME),
                        rs.getInt(INDICE_TELEFONE),
                        rs.getString(INDICE_RAMO_ATUACAO),
                        rs.getString(INDICE_LOCAL_FUNCIONAMENTO));
                        foodTruck = foodTruck1;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(foodTruck);
    }
}
