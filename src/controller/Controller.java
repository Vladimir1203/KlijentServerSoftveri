package controller;

import db.DBBroker;
import java.sql.SQLException;

/**
 *
 * @author stackOverflow
 */

public class Controller {
    private static Controller controller;


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
    
    
    
}
