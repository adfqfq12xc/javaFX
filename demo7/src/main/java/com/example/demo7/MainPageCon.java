package com.example.demo7;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainPageCon {
    public Integer id;
    @FXML
    private Text idtext;
    @FXML
    private Text idusername;
    @FXML
    private VBox vbox;
    private static Stage stage;
    public  void  setStage(Stage stage) {
        this.stage = stage;
        System.out.println(stage);
    }

    public MainPageCon() {

    }


    public void setIValue(int i, String u) throws SQLException {
        id = i;
        idusername.setText(u);
        idtext.setText(id.toString());
        String[] a = {"Dashboard", "MENU", "STAF","ABOUT US"};
        for (var ii : a) {
            Text f = new Text();

            f.setText(ii);
            f.setOnMouseClicked(event -> {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(f.getText()+".fxml"));

                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Stage newStage = new Stage();


                newStage.setScene(new Scene(root));

                newStage.show();

                // Close the current stage if needed
                Stage currentStage = (Stage) idtext.getScene().getWindow();
                currentStage.close();
                try {
                    MenuController m=loader.getController();
                    m.getMenu("Mezza");
                    m.getMenu("Appetizers");
                    m.getMenu("Main Courses");

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });


            //Some styling
            f.setStyle("-fx-font-weight: bold; -fx-fill: black; "
                    + "-fx-border-color: black; -fx-border-width: 1px;");
            VBox.setMargin(f, new Insets(0, 0, 30, 0));
            BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY);
            Background background = new Background(backgroundFill);
            vbox.setBackground(background);

            f.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            /////////////////////////////


            vbox.getChildren().add(f);

        }
    }


    // ... existing code ...
}

