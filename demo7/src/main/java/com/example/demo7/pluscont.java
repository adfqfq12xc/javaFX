package com.example.demo7;

import com.example.demo7.pay.PayFactory;
import com.example.demo7.pay.paymant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class pluscont {
    @FXML
    ComboBox cb1;
    @FXML
    ComboBox cb2;
    @FXML
    RadioButton t1;
    @FXML
    RadioButton t2;
    @FXML
    Text username;
    @FXML
    Text id;
    @FXML
    Button b;
    private ToggleGroup meatGroup;
    User u;
    String Name;
    int Price;
    @FXML
    ImageView im1;


    public void confirmf(){
        String s= (String) cb1.getSelectionModel().getSelectedItem();
        System.out.println(s);
        PayFactory p=new PayFactory();
        paymant pay= p.payFactory((String)(cb2.getSelectionModel().getSelectedItem()));
        pay.pay(Price,Name,u);
        System.out.println(((RadioButton)(meatGroup.getSelectedToggle())).getText());
        Scene scene = t1.getScene();
        // Get the stage containing the scene
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }
    public void setAdminn(User u,String n ,int Price){
        username.setText(u.name);
        id.setText(String.valueOf(u.id));
        meatGroup = new ToggleGroup();
        t1.setToggleGroup(meatGroup);
        t2.setToggleGroup(meatGroup);
        meatGroup.selectToggle(t2);
        cb1.getSelectionModel().select(1);
        cb2.getSelectionModel().select(1);
        this.u=u;
         Name=n;
         this.Price=Price;
         im1.setImage(new Image("C:\\Users\\hp\\Desktop\\bag.JPEG"));
        im1.setPreserveRatio(true);
        im1.setOnMouseClicked(event -> {
            try {
                OnImageClick();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    void OnImageClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("About.fxml"));
        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
        About a=loader.getController();
        a.submit(Integer.parseInt(id.getText()));


    }



}
