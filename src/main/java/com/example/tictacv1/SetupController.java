package com.example.tictacv1;



import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SetupController {


      public TextField nameField;
      public Button setName;
      public Label player;



      public void setupPLayerNameOnMousePressed(MouseEvent mouseEvent) {

            setPLayerName();
//            String name = nameField.getText();
//            player.setText("Player: " + name);

      }


      public void setupPLayerNameOnEnter(ActionEvent actionEvent) {
            setPLayerName();
      }

      public void setPLayerName(){
            String name = nameField.getText();
            player.setText("Player: " + name);
      }
}
