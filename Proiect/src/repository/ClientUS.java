package repository;

import config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientUS {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS clients" +
                "(clientId int PRIMARY KEY AUTO_INCREMENT, nume varchar(30), email varchar(30), nrtel varchar(30), tipMembru varchar(30))";


        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateTable() {
        String updateTableSql = "ALTER TABLE clients" +
                " ADD nrtel varchar(30), ADD tipMembru varchar(30)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement stmt = connection.createStatement();
            stmt.execute(updateTableSql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void addClient() {
        String insertClient= "INSERT INTO clients(nume,email,nrtel,tipMembru) VALUES ('anaTEST','test@gmail.com','01','premium')";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement stmt = connection.createStatement();
            stmt.execute(insertClient);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void displayClient(){
        String selectSql = "SELECT * FROM clients";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while(resultSet.next()){
                System.out.println("Id: " + resultSet.getString(1));
                System.out.println("Nume: " + resultSet.getString(2));
                System.out.println("email: " + resultSet.getString(3));
                System.out.println("Telefon: " + resultSet.getString(4));
                System.out.println("Tip Client: " + resultSet.getString(5));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteTable() {
        String deleteSql = "DROP TABLE clients";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(deleteSql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}