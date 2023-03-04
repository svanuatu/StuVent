/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author vanua
 */
public class UpcomingEventsController implements Initializable {

    @FXML
    private AnchorPane screen;
    @FXML
    private Button eventLabel1;
    @FXML
    private Button eventButton1;
    @FXML
    private Button eventLabel11;
    @FXML
    private Button eventButton2;
    @FXML
    private Button eventLabel111;
    @FXML
    private Button eventButton3;

  //  Event event1 = new Event("Schloarship Night", "College", 3, "CPC");
    @FXML
    private AnchorPane register1;
    private TranslateTransition hideTransition;
    private TranslateTransition showTransition;
    private double paneHeight;
    @FXML
    private AnchorPane register2;
    @FXML
    private AnchorPane register3;
    
  //  private String name = "";
    @FXML
    private Button register;
    @FXML
    private Label nameLabel;
    @FXML
    private Button register4;
    @FXML
    private Button register41;
    @FXML
    private Button eventLabel12;
    @FXML
    private Button eventButton11;
    @FXML
    private AnchorPane register11;
    @FXML
    private AnchorPane register31;
    @FXML
    private Button register411;
    @FXML
    private Button eventLabel1111;
    @FXML
    private Button eventButton31;
    @FXML
    private Button eventLabel121;
    @FXML
    private Button eventButton111;
    @FXML
    private AnchorPane register111;
    @FXML
    private AnchorPane register112;
    @FXML
    private Button eventLabel122;
    @FXML
    private Button eventButton112;
    @FXML
    private AnchorPane register1121;
    @FXML
    private Button eventLabel1221;
    @FXML
    private Button eventButton1121;
    @FXML
    private Button register6;
    @FXML
    private Button register7;
    @FXML
    private Button register99;
    @FXML
    private Button register19;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        register1.setVisible(false);
        register2.setVisible(false);
        register3.setVisible(false);
       //ameLabel.setText(name);
    }
         
            
            
    public void loadEvent(AnchorPane reg) {
    if (reg.isVisible()) {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), reg);
        fadeOut.setToValue(0.0);
        fadeOut.play();
        fadeOut.setOnFinished(event -> reg.setVisible(false));
    } else {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), reg);
        fadeIn.setToValue(1.0);
        reg.setVisible(true);
        fadeIn.play();
    }
}
    //public void getName(String n)
  //  {
       // this.name = n;
   // nameLabel.setText(n);
        
   // }
public void getCode(String name)
{
    System.out.println(name);
String nameReal = "hallo";
    Connection conn = null;
    PreparedStatement prepare = null;
    ResultSet rs = null;
    
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/stuvent?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        prepare = conn.prepareStatement("SELECT email FROM students WHERE name = ?");
        prepare.setString(1, name); // use name parameter to set the PreparedStatement parameter
        rs = prepare.executeQuery();
       // String dbPoints = rs.getString("points");
       // pointsLabel.setText("Points "+dbPoints);
        
        if (rs.next()) {
            nameReal = rs.getString("email");
            //System.out.println()
            nameLabel.setText("Code " + nameReal);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
} /*
    public void register(String name)
    {
         // int event = 4;
    Connection conn = null;
    PreparedStatement prepare = null;
    ResultSet rs = null;
    
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/stuvent?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        prepare = conn.prepareStatement("SELECT points FROM students WHERE name = "+name);
        prepare.setString(1, name); // use name parameter to set the PreparedStatement parameter
        rs = prepare.executeQuery();
       // String dbPoints = rs.getString("points");
       // pointsLabel.setText("Points "+dbPoints);
        
        if (rs.next()) {
            pointsValue = rs.getInt("points");
            pointsLabel.setText("Points " + pointsValue);
        }
    } catch (SQLException e) {
        e.printStackTrace();

    }  */
    
    
    
    
    
    @FXML
    public void loadevent1()
    {
        loadEvent(register1);
    }
    @FXML
    public void loadevent2()
    {
        loadEvent(register2);
    }
    @FXML
    public void loadevent3()
    {
        loadEvent(register3);
    }
    public void loadevent4()
    {
        //loadEvent(register2);
    }

}
