package controller;

import db.DBBroker;
import domain.Driver;
import domain.Vehicle;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author stackOverflow
 */

public class Controller {
    private static Controller controller;
    Connection connection;

    private static DBBroker db;
    
    private Controller() {
        db = new DBBroker();
    }

    public static Controller getController() {
        if(controller == null)
            controller = new Controller();
        return controller;
    }
    
    public static void justConnectTest() throws ClassNotFoundException, SQLException {
        db.loadDriver();
        db.openConnection();
        System.out.println("SUCCESS");
        db.closeConnection();
    }

    public void saveDriver(Driver d) throws ClassNotFoundException, SQLException {
        String name = d.getName();
        String surname = d.getSurname();
        int IDCard = d.getIDCard();
        String query = "insert into driver values" + "(" + " ' " +IDCard + " ' " + ","+ " ' " + name + " ' " + "," + " ' " + surname + " ' " +  ");";
        System.out.println("insert into driver values" + "(" + " ' " +IDCard + " ' " + ","+ " ' " + name + " ' " + "," + " ' " + surname + " ' " +  ");");
        db.loadDriver();
        connection = db.openConnection();
        System.out.println("SUCCESS");
        Statement s = connection.createStatement();
        s.executeUpdate(query);
        db.closeConnection();
        
    
        
    }

    public void createDriverTable() throws ClassNotFoundException, SQLException{
         String query = "create table driver(idcard numeric(10), name varchar(25), surname varchar(25));";
        db.loadDriver();
        connection = db.openConnection();
        
        DatabaseMetaData dbm = connection.getMetaData();

        ResultSet tables = dbm.getTables(null, null, "driver", null);
        if (tables.next()) {
            db.closeConnection();
        }
        else {
            System.out.println("SUCCESS");
         Statement s = connection.createStatement();
        s.executeUpdate(query);
        db.closeConnection();
        }
    }
    
    public void createVehicleTable() throws ClassNotFoundException, SQLException{
         String query = "create table vehicle(vehicletype varchar(25), brand varchar(25));";
        db.loadDriver();
        connection = db.openConnection();
        
        DatabaseMetaData dbm = connection.getMetaData();

        ResultSet tables = dbm.getTables(null, null, "vehicle", null);
        if (tables.next()) {
            db.closeConnection();
        }
        else {
            System.out.println("SUCCESS");
         Statement s = connection.createStatement();
        s.executeUpdate(query);
        db.closeConnection();
        }
    }
    
    public void loginFullBase() throws ClassNotFoundException, SQLException{
       createDriverTable();
       createVehicleTable();
    }

    public void saveVehicle(Vehicle v) throws ClassNotFoundException, SQLException {
        String brand = v.getBrand();
        String vehicleType = v.getVehicleType();
        String query = "insert into vehicle values" + "(" + " ' " +vehicleType + " ' " + ","+ " ' " + brand + " ' " + ");";
        System.out.println("insert into vehicle values" + "(" + " ' " +vehicleType + " ' " + ","+ " ' " + brand + " ' " + ");");
        db.loadDriver();
        connection = db.openConnection();
        System.out.println("SUCCESS");
        Statement s = connection.createStatement();
        s.executeUpdate(query);
        db.closeConnection();
    }
    
    
    
}
