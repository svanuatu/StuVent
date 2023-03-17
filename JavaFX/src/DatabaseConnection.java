/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vanua
 */
import com.sun.javafx.logging.PlatformLogger;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DatabaseConnection {
    Connection connect = null;
    
    public static Connection conDB() 
    {
   
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/stuvent?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            return con;
        }
     catch (Exception ex) {
         return null;
        }
    

       // return databaseLink;
    }
}
