import java.io.IOException;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class DashboardController implements Initializable {

    private static final double ANIMATION_DURATION = 0.4;
    private static final double SIDEBAR_WIDTH = 221;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button upcomingEventsButton;

    @FXML
    private Button profileButton;


    @FXML
    private Button newsButton;

    @FXML
    private Button menuButton;

    @FXML
    private AnchorPane slider;
    @FXML
    private AnchorPane center;
    @FXML
    private Button leaderboardButtton;
    @FXML
    private AnchorPane screen;
            
    private String name;

    public void setName(String username) {
      // ProfileController pf = new ProfileController 
     //  pf.myString = username;
        name = username;
        System.out.println("NAME:"+name);
        
        welcomeLabel.setText("Welcome, " + username + "!");
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }

    @FXML
    public void menuButtonClicked() {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(ANIMATION_DURATION), slider);

        if (slider.getTranslateX() != 0) {
            slide.setToX(0);
        } else {
            slide.setToX(-SIDEBAR_WIDTH);
        }
        slide.play();
    }
    
    @FXML
    public void profileClicked()
    {
     loadPage("Profile");
    }
    @FXML
    public void upcomingEventsClicked()
    {
     loadPage("UpcomingEvents");
    }
    @FXML
    public void leaderboardClicked()
    {
     loadPage("Leaderboard");
    }
    @FXML
    public void infoClicked()
    {
     loadPage("Info");
    }
    private void loadPage(String page) {
FXMLLoader loader;
Parent root = null;

try {
    if (page.equals("Profile"))
    {
        loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
        root = loader.load();
        ProfileController profileController = loader.getController();
        profileController.getPointsValue(name);
    }
     if (page.equals("UpcomingEvents"))
     {
        loader = new FXMLLoader(getClass().getResource("UpcomingEvents.fxml"));
        root = loader.load();
        UpcomingEventsController eventController = loader.getController();
        eventController.getStuff(name);
     }
     if (page.equals("Leaderboard"))
     {
        loader = new FXMLLoader(getClass().getResource("Leaderboard.fxml"));
        root = loader.load();
     }
     if (page.equals("Info"))
     {
        loader = new FXMLLoader(getClass().getResource("Info.fxml"));
        root = loader.load();
     }
    
    screen.getChildren().setAll(root);
} catch (IOException | SQLException ex) {
    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
}

}
    


}
