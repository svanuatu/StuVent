/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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
    @FXML
    private Label errorLabel;
    @FXML
    private Button confirmButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       } 
    
     public void setPoints(int points) {
    this.points = points;
}

    @FXML
     public void btnConfirmClicked(ActionEvent event)
     {
          String confirmResult = confirm();
    if (confirmResult.equals("Success")) {
          errorLabel.setText("Sucess!!!!!!!!");
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
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/stuvent?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        prepare = conn.prepareStatement("SELECT points FROM students WHERE name = ?");
        prepare.setString(1, name); // use name parameter to set the PreparedStatement parameter
        rs = prepare.executeQuery();
        
        if (rs.next()) {
            pointsValue = rs.getInt("points");
            //confirmValue = rs.getInt("confirmation");
          //  System.out.println(confirmValue);
            pointsLabel.setText("Points ::: " + pointsValue);
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

public String confirm()
{
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
     String confirmInput = confirmTextBox.getText();
    //String password = passwordPasswordField.getText();
    //errorLabel.setText("");
   // String sql = "SELECT email, password, name FROM students WHERE email = ? AND password = ?";

    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/stuvent?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        preparedStatement = conn.prepareStatement("SELECT points, confirmation FROM students WHERE name = ?");
        preparedStatement.setString(1, name); // use name parameter to set the PreparedStatement parameter
        resultSet = preparedStatement.executeQuery();
       // resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            errorLabel.setTextFill(Color.TOMATO);
            errorLabel.setText("Enter Correct Username/Password");
            return "Error";
        } else {
            
            int dbConfirm = resultSet.getInt("confirmation");

            if (confirmInput.equals(dbConfirm)) {
                errorLabel.setTextFill(Color.GREEN);
                confirmValue = dbConfirm;
                System.out.print("Success");
                return "Success";
                    
               
                
                
            } else {
                errorLabel.setTextFill(Color.TOMATO);
                System.out.println("error");
                errorLabel.setText("Enter Correct Username/Password");
                return "Error";
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        return "Exception";
    }
}
}



    



    


    

