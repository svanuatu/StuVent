/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
//Others
import java.io.IOException;
import javafx.scene.paint.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.util.ResourceBundle;
//Javafx
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


//sql import statementsser
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javafx.fxml.FXMLLoader;


//import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author vanua
 */
public class FXMLController implements Initializable {

    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Label errorLabel;
    public String name = "";
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public FXMLController() {
        con = DatabaseConnection.conDB();

    }

@FXML
public void btnLoginClicked(ActionEvent event) {   
    String loginResult = login();
    if (loginResult.equals("Success")) {
        try {
            // set welcome label to display username
            welcomeLabel.setText("Welcome " + usernameTextField.getText() + "!");

            // load dashboard scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = loader.load();
            DashboardController dashboardController = loader.getController();
            dashboardController.setName(name);

            // create new scene
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        errorLabel.setTextFill(Color.TOMATO);
        errorLabel.setText("Enter Correct Username/Password");
    }
}

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
private String login() {
    String email = usernameTextField.getText();
    String password = passwordPasswordField.getText();
    errorLabel.setText("");
    String sql = "SELECT email, password, name FROM students WHERE email = ? AND password = ?";

    try {
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            errorLabel.setTextFill(Color.TOMATO);
            errorLabel.setText("Enter Correct Username/Password");
            return "Error";
        } else {
            String dbEmail = resultSet.getString("email");
            String dbPassword = resultSet.getString("password");
            String dbName = resultSet.getString("name");

            if (email.equals(dbEmail) && password.equals(dbPassword)) {
                errorLabel.setTextFill(Color.GREEN);
                name = dbName;
                System.out.print("Success");
                return "Success";
                    
               
                
                
            } else {
                errorLabel.setTextFill(Color.TOMATO);
                errorLabel.setText("Enter Correct Username/Password");
                return "Error";
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        return "Exception";
    }
}


    /* private void showDialog(String info, String header, String title)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(info);
        alert.setHeaderText(header);
        alert.showAndWait();
              //alert.setContentText("Login Successful");
        
        
    }
     */
    @FXML
    private void btnCancelClicked(ActionEvent event) {
        usernameTextField.setText("");
        passwordPasswordField.setText("");
        welcomeLabel.setText("");
        //errorLabel.setText("Invalid username."); 
    }

    /*public void validateLogin() 
       {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            
            String verifyLogin = "SELECT count(1) FROM UserAccounts WHERE username = '"+usernameTextField.getText()+"' AND password = '"+passwordPasswordField.getText()+"'";
            
       try {
                
              Statement statement = connectDB.createStatement(); 
              ResultSet queryResult = statement.executeQuery(verifyLogin);
              
              while(queryResult.next()) 
              {
                  if(queryResult.getInt(1) == 1)
                  {welcomeLabel.setText("Welcome!"); }
                  else
                  { welcomeLabel.setText("Invalid WLogin. Please try again.");
              }
            } 
          }
              catch (Exception e) 
            {
                e.printStackTrace();
            }
        
        
       } */
}
