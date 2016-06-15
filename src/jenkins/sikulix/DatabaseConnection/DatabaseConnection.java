/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenkins.sikulix.DatabaseConnection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author fachrulpbm
 */
public class DatabaseConnection {
    private static Connection connection;
    public static Connection getConnection(){
        if(connection == null){
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/medrec","root","");
            }catch(Throwable t){
                JOptionPane.showMessageDialog(null, t.getMessage(),"Error - Database Connections",JOptionPane.ERROR_MESSAGE);
            }
        }
        return connection;
    }
}
