/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author vanua
 */
public class LeaderboardController implements Initializable {

    @FXML
    private AnchorPane screen;
    @FXML
    private Label top1;
    @FXML
    private Label top2;
    @FXML
    private Label top3;

    //private int[] top;
    private Label top4;
    @FXML
    private Label top5;
    @FXML
    private Label top6;
    @FXML
    private Label top7;
    @FXML
    private Label top8;
    @FXML
    private Label top9;
    @FXML
    private Label top10;
    @FXML
    private Label top21;
    @FXML
    private Label top31;
    @FXML
    private Label top32;
    @FXML
    private Label top23;
    @FXML
    private Label top22;
    @FXML
    private Label top221;
    @FXML
    private Label top311;
    @FXML
    private Label top2211;
    @FXML
    private Label top3111;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getLeaderboard();
        } catch (SQLException ex) {
            Logger.getLogger(LeaderboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setTopLabel(int position, Label label) throws SQLException {
        Connection conn = null;
        PreparedStatement prepare = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/stuvent?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            prepare = conn.prepareStatement("SELECT name, points FROM students ORDER BY points DESC LIMIT 1 OFFSET ?");
            prepare.setInt(1, position - 1);
            rs = prepare.executeQuery();

            if (rs.next()) {
                int points = rs.getInt("points");
                String name = rs.getString("name");
                label.setText("Top " + position + "---==--- " + name + " - " + points);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getLeaderboard() throws SQLException {

        try {
            setTopLabel(1, top1);
            setTopLabel(2, top2);
            setTopLabel(3, top3);
            setTopLabel(4, top4);
            setTopLabel(5, top5);
            setTopLabel(6, top6);
            setTopLabel(7, top7);
            setTopLabel(8, top8);
            setTopLabel(9, top9);
            setTopLabel(10, top10);
            
        } catch (SQLException ex) {
            Logger.getLogger(LeaderboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
