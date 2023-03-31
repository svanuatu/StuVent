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
import java.util.Properties;
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

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author vanua
 */
public class UpcomingEventsController implements Initializable {
String email = "";
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

    public void sendEmail(String recepient) throws Exception
    {
                Properties props;
		//Session session;
		//MimeMessage message;

		props = new Properties();
              //  mail.smtp.auth;
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
               // props.put("mail.smtp.host","smtp.gmail.com");
		//props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		String myEmail = "786660@lcps.org";
                String password = "LCPS-121205";
                
                Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return  new PasswordAuthentication("786660@lcps.org","LCPS-121205");
                    }
                });
                Message message = prepareMessage(session, myEmail, recepient);
                
    try {
        Transport.send(message);
    } catch (MessagingException ex) {
        Logger.getLogger(UpcomingEventsController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public static Message prepareMessage(Session session, String myEmail, String recepient) 
    {
        
    try {
        Message message = new MimeMessage(session);
        message = new MimeMessage(session);
       // message.setFrom(new InternetAddress(myEmail
        message.setFrom(new InternetAddress("stuvent677@gmail.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
        message.setSubject("Event Sign Up");
        message.setText("You registered for a Foodball Game");
        System.out.println("Email sent");
        return message;
    } catch (AddressException ex) {
        ex.printStackTrace();
    } catch (MessagingException ex) {
        Logger.getLogger(UpcomingEventsController.class.getName()).log(Level.SEVERE, null, ex);
    }
            
               return null;
    }

    
        
        
    
public void addEvent(Button event) throws Exception
{
     Connection conn = null;
    PreparedStatement prepare = null;
   //esultSet rs = null;
    String[] array = {"Basketball","Hockey","Climate Project","Volunteer","Fundraising","Zero Day","FBLA","Debate"};
int random = (int)(Math.random() * 8);
    String eve = array[random];
            try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/stuvent?zeroDateTimeBehavior=CONVERT_TO_NULL","root","1234");
        prepare = conn.prepareStatement("UPDATE `stuvent`.`users` SET `event` = ? WHERE (`email` = '66')");
       prepare.setString(1, eve); // use name parameter to set the PreparedStatement parameter
      //rs = prepare.executeQuery();
      prepare.executeUpdate();
      
      //FXMLLoader loader = new FXMLLoader(getClass().getResource("UpcomingEvents.fxml"));
    //  AnchorPane anchorPane = (AnchorPane) loader.getNamespace().get("register1");
//Button myButton = (Button) anchorPane.lookup("#register");
    //  sendEmail("786660@lcps.org");
       //f (rs.next()) {
            JOptionPane.showMessageDialog(null, "Added Event!");
            nameLabel.setText("Code " + email);
           //ystem.out.println
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
        
        
        
public void getStuff(String name)
{
    System.out.println(name);
String nameReal = "hallo";
    Connection conn = null;
    PreparedStatement prepare = null;
    ResultSet rs = null;
    
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/stuvent?zeroDateTimeBehavior=CONVERT_TO_NULL","root","1234");
        prepare = conn.prepareStatement("SELECT email FROM users WHERE name = ?");
        prepare.setString(1, name); // use name parameter to set the PreparedStatement parameter
        rs = prepare.executeQuery();
       // String dbPoints = rs.getString("points");
       // pointsLabel.setText("Points "+dbPoints);
        
        if (rs.next()) {
           // nameReal = rs.getString("email");
            email = rs.getString("email");
            //System.out.println()
            
            nameLabel.setText("Email " + nameReal);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
} 
    
    
    
    
    
    @FXML
    public void loadevent1() throws Exception
    {
        loadEvent(register1);
        addEvent(register);
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
