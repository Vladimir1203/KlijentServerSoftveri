package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author stackOverflow
 */

public class DBBroker {
    
    Connection connection;
    
    public void loadDriver() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    
    public void openConnection() throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transportapp", "root", "root");
    }
    
    public void closeConnection() throws SQLException{
        connection.close();
    }
    
}
