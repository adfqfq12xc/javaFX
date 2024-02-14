package com.example.demo7;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 640);
        stage.setTitle("Restau!");
        stage.setScene(scene);
        MainPageCon m=new MainPageCon();
        m.setStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}