package main;
import java.sql.SQLException;
import javax.swing.JFrame;
import ui.forms.Login;

/**
 *
 * @author stackOverflow
 */

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JFrame login = new Login();
        login.setVisible(true);
    }
    
}
