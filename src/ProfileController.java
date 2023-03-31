/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

//import com.mysql.cj.Session;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * FXML Controller class
 *
 * @author vanua
 */
public class ProfileController implements Initializable {

    @FXML
    private AnchorPane screen;
    @FXML
    private Text pointsLabel;
    
    private int points;
    @FXML
    private Text pointsLabel1;
    @FXML
    private Text pointsLabel11;
    @FXML
    private Text pointsLabel111;
    @FXML
    private Text pointsLabel2;
    @FXML
    private TextField confirmTextBox;
     int confirmValue = 0;
     private String name = "";
     private String emailValue = "";
     private String eventValue = "";
    @FXML
    private Label errorLabel;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField enterPoint;
    @FXML
    private TextField eventTextBox;
    private Label currentEventLabel;
    @FXML
    private Text currentEventText;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       } 
    
    
    
     public void setPoints(int p) {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/stuvent?zeroDateTimeBehavior=CONVERT_TO_NULL","root","1234");
        String sql = "UPDATE `stuvent`.`users` SET `points` = ? WHERE `email` = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        points += p;
        //System.out.println("Added"+p);
        ps.setInt(1, points);
        ps.setString(2, emailValue);
        int rowsUpdated = ps.executeUpdate();
        
        System.out.println(rowsUpdated);
        JOptionPane.showMessageDialog(null, "Updated!");
        System.out.println(p);
        pointsLabel.setText("Points ::: " + points);
        System.out.println(eventValue);
    } catch (SQLException ex) {
        Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
    }


}
     
     
    @FXML
     public void btnConfirmClicked(ActionEvent event) throws Exception
     {
          String eventInput = eventTextBox.getText();
          String confirmInput = confirmTextBox.getText();
          int numPoints = Integer.valueOf(enterPoint.getText());
          int confirmResult = Integer.parseInt(confirmInput);
          System.out.println("You typed "+confirmResult);
          System.out.println(eventValue);
          System.out.println(eventInput);
          if (confirmResult == confirmValue && eventValue.equals(eventInput)) {
          errorLabel.setText("Sucess!!!!!!!!");
          setPoints(numPoints);
          finishEvent();
     }
    else {
        errorLabel.setTextFill(Color.TOMATO);
        System.out.println("Error??");
        errorLabel.setText("Enter Correct Username/Password");
    }
    

     }
public void getPointsValue(String name) throws SQLException {
    System.out.println(name);
    int pointsValue = 3;
   
    Connection conn = null;
    PreparedStatement prepare = null;
    ResultSet rs = null;
    
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/stuvent?zeroDateTimeBehavior=CONVERT_TO_NULL","root","1234");
        prepare = conn.prepareStatement("SELECT points, confirm, email, event FROM users WHERE name = ?");
        prepare.setString(1, name); // use name parameter to set the PreparedStatement parameter
        rs = prepare.executeQuery();
        
        if (rs.next()) {
            pointsValue = rs.getInt("points");
            confirmValue = rs.getInt("confirm");
            emailValue = rs.getString("email");
            eventValue = rs.getString("event");
            points = pointsValue;
            System.out.println(eventValue);
          //  System.out.println(confirmValue);
            pointsLabel.setText("Points ::: " + points);
                    currentEventText.setText("Events ::: "+eventValue);

            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // close resources
        if (rs != null) {
            rs.close();
        }
        if (prepare != null) {
            prepare.close();
        }
        if (conn != null) {
            conn.close();
        }
    
        
        
}
}
        
public void finishEvent() throws Exception
{
     Connection conn = null;
    PreparedStatement prepare = null;
   //esultSet rs = null;
    
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/stuvent?zeroDateTimeBehavior=CONVERT_TO_NULL","root","1234");
        prepare = conn.prepareStatement("UPDATE `stuvent`.`users` SET `event` = 'null' WHERE (`email` = '66')");
       //repare.setString(1, email); // use name parameter to set the PreparedStatement parameter
      //rs = prepare.executeQuery();
      prepare.executeUpdate();
    //  sendEmail("786660@lcps.org");
       //f (rs.next()) {
            JOptionPane.showMessageDialog(null, "Removed Event!");
           // nameLabel.setText("Code " + email);
           //ystem.out.println
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



}



    



    


    

