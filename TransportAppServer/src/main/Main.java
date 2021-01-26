package main;
import java.sql.SQLException;
import javax.swing.JFrame;
import server.forms.FServer;

/**
 *
 * @author stackOverflow
 */

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JFrame jf = new FServer();
        jf.setVisible(true);
    }
    
}
