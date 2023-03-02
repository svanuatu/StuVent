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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       } 
    
     public void setPoints(int points) {
    this.points = points;
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

    
}


    


    

