package com.example.demo7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class About  {
    @FXML
    VBox v1;

    public void submit(int x){

        Connection con = DatabaseConnection.getConnection();

        String sql = "SELECT * FROM public.paymant where \"user_id\" = "+x;
        try (PreparedStatement preparedStatement = con.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Process the result set
            while (resultSet.next()) {
                // Assuming you have a column named "columnName" in your table
                String c1 = String.valueOf(resultSet.getString(1));
                Text t1=new Text();t1.setText(c1);t1.setWrappingWidth(144);
                String c2 = String.valueOf(resultSet.getString(2));
                Text t2=new Text();t2.setText(c2);t2.setWrappingWidth(144);
                String c3 = String.valueOf(resultSet.getString(3));
                Text t3=new Text();t3.setText(c3);t3.setWrappingWidth(144);
                String c4 = String.valueOf(resultSet.getString(4));
                Text t4=new Text();t4.setText(c4);t4.setWrappingWidth(144);
                HBox h1=new HBox();
                h1.getChildren().addAll(t1,t2,t3,t4);
                h1.setPrefWidth(622);
                v1.getChildren().add(h1);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
