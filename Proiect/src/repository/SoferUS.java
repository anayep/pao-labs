package repository;

import config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SoferUS {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS soferi" +
                "(soferId int PRIMARY KEY AUTO_INCREMENT, nume varchar(30), email varchar(30), nrtel varchar(30), salariu double)";


        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void addSofer() {
        String insertSofer= "INSERT INTO soferi(nume,email,nrtel,salariu) VALUES ('SoferDataBase','sofer@gmail.com','01234',100)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement stmt = connection.createStatement();
            stmt.execute(insertSofer);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void displaySofer(){
        String selectSql = "SELECT * FROM soferi";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while(resultSet.next()){
                System.out.println("Id: " + resultSet.getString(1));
                System.out.println("Nume: " + resultSet.getString(2));
                System.out.println("email: " + resultSet.getString(3));
                System.out.println("Telefon: " + resultSet.getString(4));
                System.out.println("Salariu: " + resultSet.getString(5));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteTable() {
        String deleteSql = "DROP TABLE soferi";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(deleteSql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}