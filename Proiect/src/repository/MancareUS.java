package repository;

import config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MancareUS {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS feluriMancare" +
                "(mancareId int PRIMARY KEY AUTO_INCREMENT, nume varchar(30), pret double, picanta double)";


        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void addMancare() {
        String insertMancare= "INSERT INTO feluriMancare(nume,pret,picanta) VALUES ('FelMancare1DB',22,1)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement stmt = connection.createStatement();
            stmt.execute(insertMancare);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void displayMancare(){
        String selectSql = "SELECT * FROM feluriMancare";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while(resultSet.next()){
                System.out.println("Id: " + resultSet.getString(1));
                System.out.println("Nume: " + resultSet.getString(2));
                System.out.println("Pret: " + resultSet.getString(3));
                System.out.println("Picanta: " + resultSet.getString(4));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteTable() {
        String deleteSql = "DROP TABLE feluriMancare";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(deleteSql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}