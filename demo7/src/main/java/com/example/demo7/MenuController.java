package com.example.demo7;

import com.example.demo7.pay.PayFactory;
import com.example.demo7.pay.paymant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuController {
    public MenuController() throws SQLException {

    }
    @FXML
    private  VBox Mezza;
    @FXML
    ImageView im1;
    @FXML
    private  VBox Appetizers;
    @FXML
    private  VBox MainCourses;
    @FXML
    private  VBox vbox4;
    public VBox v;
    public User u;

    public void Setuser(String s,int id){
        u=new User(s,id);
    }

    public  void getMenu(String desc) throws SQLException {
        im1.setImage(new Image("C:\\Users\\hp\\Desktop\\bag.JPEG"));
        im1.setPreserveRatio(true);
        if(desc=="Mezza")
            v=Mezza;
        if(desc=="Appetizers")
            v=Appetizers;
        if(desc=="Main Courses")
            v=MainCourses;


        var connection = DatabaseConnection.getConnection();

        // Prepare the SQL query
        String sql = "SELECT * FROM public.\"Menu\" WHERE \"dsc\" = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set the parameter in the prepared statement
            preparedStatement.setString(1, desc);

            // Execute the query and obtain the result set
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                HBox hbox1 = new HBox();

                Text t2 = new Text();
                t2.setText("Name");
                t2.setWrappingWidth(100);
                t2.setStrokeWidth(50);
                t2.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-min-width: 25;");
                hbox1.getChildren().add(t2);

                Text t3 = new Text();
                t3.setText("Desc");
                t3.setWrappingWidth(100);
                t3.setStrokeWidth(100);
                t3.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-min-width: 25;");
                hbox1.getChildren().add(t3);

                Text t4 = new Text();

                t4.setText("Price");
                t4.setWrappingWidth(100);
                t4.setStrokeWidth(100);

                t4.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-min-width: 25;");

                hbox1.getChildren().add(t4);
                Text t = new Text();

                t.setText("Rate");

                t.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-min-width: 25;");
                hbox1.setSpacing(20);

                hbox1.getChildren().add(t);
                v.getChildren().add(hbox1);
                im1.setOnMouseClicked(event -> {
                    try {
                    OnImageClick();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                };
            });
                t.setStrokeWidth(100);


                // Process the result set
                while (resultSet.next()) {
                    HBox hbox = new HBox();

                    for(int i =1;i<=4;i++) {
                        Text text1 = new Text();
                        text1.setText(resultSet.getString(i));
                        if(i!=4)
                            text1.setWrappingWidth(100); // Set the width to 50px

                        text1.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-min-width: 25;");
                        hbox.getChildren().add(text1);
                    }
                    hbox.setSpacing(20);
                    v.setStyle("-fx-border-width: 4px; -fx-border-color: black;"); // 4px border with black color
                    ImageView v1=new ImageView();
                    v1.setImage(new Image("C:\\Users\\hp\\IdeaProjects\\demo7\\src\\main\\java\\ress\\plus.png"));
                    v1.setFitWidth(20);
                    v1.setFitHeight(20);
                    hbox.getChildren().add(v1);
                    v.getChildren().add(hbox);

v1.setOnMouseClicked(event -> {
                    if(desc=="Main Courses"){
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("plus.fxml"));

                        Parent root = null;
                        try {
                            root = loader.load();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Parent finalRoot = root;



                        Stage newStage = new Stage();

                        newStage.setScene(new Scene(finalRoot));

                        newStage.show();

                        pluscont c=loader.getController();
                        if(c!=null)
                            c.setAdminn(u,((Text)(hbox.getChildren().get(0))).getText(),4);
                        else System.out.println("c is null");

                        // Close the current stage if needed
                      //  Stage currentStage = (Stage) v1.getScene().getWindow();
                       // currentStage.close();

                    }
                    else{
                        PayFactory p=new PayFactory();
                        paymant pp= p.payFactory("paypal");
                        pp.pay(4,((Text)(hbox.getChildren().get(0))).getText(),u);



                    }

                });
            }
        }
    }
}
    void OnImageClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("About.fxml"));
        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
        About a=loader.getController();
        a.submit(u.id);


    }
}

