/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.impl;

import database.IDatabaseBroker;
import domain.IGeneralEntity;
import domain.User;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author stackOverflow
 */
public class DatabaseBroker implements IDatabaseBroker{
        Connection connection;
           public void loadDriver() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    
    public Connection openConnection() throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transportapp", "root", "");
        return connection;
    }
    
    public void closeConnection() throws SQLException{
        connection.close();
    }
    
        public void connectToDatabase() throws Exception {
            try {
                FileInputStream in=new FileInputStream("db.properties");
                Properties props=new Properties();
                props.load(in);
                //String driver=props.getProperty("driver");
                String address = props.getProperty("address");
                String port = props.getProperty("port");
                String database = props.getProperty("database");
                String user=props.getProperty("user");
                String password=props.getProperty("password");
                String url = "jdbc:mysql://"+address+":"+port+"/"+database;
                //Class.forName(driver);
                System.out.println(address + port + database + user + password + url);
                
                connection = DriverManager.getConnection(url, user, "");

                connection.setAutoCommit(false);
                System.out.println("Successfully connected to database!");
            } catch (IOException | SQLException ex) {
                throw new Exception("Unsuccessfully connected to database!\n" + ex.getMessage());
        }

    }
        
    public void disconnectFromDatabase() throws Exception {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new Exception("There is some error at disconnecting to database!\n" + ex.getMessage());
            }
        }
    }
    
    public void commit() throws Exception {
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException ex) {
                throw new Exception("There is some error in commit!\n" + ex.getMessage());
            }
        }
    }
    
    public void rollback() throws Exception {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new Exception("There is some error in rollback!\n" + ex.getMessage());
            }
        }
    }
    
    @Override
    public int sacuvaj(IGeneralEntity entity) throws Exception {
        
        String query = "insert into" + entity.getTableName() + "(" + 
                entity.getAttributes() + ")" + "(" + entity.getValues() + ")";
        
        System.out.println(query);
        
        //db.loadDriver();
        //connection = db.openConnection();
        //System.out.println("SUCCESS");
        //Statement s = connection.createStatement();
        //s.executeUpdate(query);
        //db.closeConnection();
        return 0;
    }

    @Override
    public void obrisi(IGeneralEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void izmeni(IGeneralEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IGeneralEntity> vratiPoUslovu(IGeneralEntity entity) throws Exception {
        ArrayList<IGeneralEntity> objekti;
        String query = "select * from " + entity.getTableName() + " where" + entity.getSelectContidion();
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        objekti = (ArrayList<IGeneralEntity>) entity.getList(rs);
        return objekti;
    }

    @Override
    public IGeneralEntity vratiPoId(IGeneralEntity entity) throws Exception {
        ArrayList<IGeneralEntity> objekti;
        String query = "select * from " + entity.getTableName() + " where " + entity.getSelectContidion();
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        objekti = (ArrayList<IGeneralEntity>) entity.getList(rs);
        IGeneralEntity objekat = objekti.get(0);
        return objekat;
    }

    @Override
    public List<IGeneralEntity> vratiSve(IGeneralEntity entity) throws Exception {
        ArrayList<IGeneralEntity> objekti;
        String query = "select * from " + entity.getTableName();
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        objekti = (ArrayList<IGeneralEntity>) entity.getList(rs);
        return objekti;
    }

    public User login(User user) throws SQLException {
        List<User> users = new ArrayList<>();
        User glavni = new User(-1);
        String query = "select * from user";
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        
        while(rs.next()){
            User u = new User(rs.getInt("userID"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("surname"), rs.getString("email"));
            users.add(u);
        }
        
        for(User u : users){
            if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
                user.setUserID(u.getUserID());
                break;
            }
        }
        return user;
    }


    
    
}
