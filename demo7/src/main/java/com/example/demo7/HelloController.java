package com.example.demo7;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    @FXML private TextField username;@FXML private PasswordField pass;
    @FXML
    protected void onHelloButtonClick() throws SQLException {
        String user = username.getText();
        String pas = pass.getText();
        System.out.println(user + " " + pas);

        int i = DatabaseConnection.getclient(user, pas);
        if (i!=0) {
            goToNewScene(i,user);
        }
    }


    private void goToNewScene(int i,String usern) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MENU.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));

            newStage.show();

            // Close the current stage if needed
          //  Stage currentStage = (Stage) username.getScene().getWindow();
          //  currentStage.close();
            try {
                MenuController m=loader.getController();
                m.getMenu("Mezza");
                m.getMenu("Appetizers");
                m.getMenu("Main Courses");
                m.Setuser(username.getText(),1);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

