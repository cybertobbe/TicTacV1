package com.example.tictacv1;



import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SetupController {


      public TextField nameField;
      public Button setName;
      public Label player;
      static String playerName = "";


      public void setupPLayerNameOnMousePressed(MouseEvent mouseEvent) {

            setPLayerName();
//            String name = nameField.getText();
//            player.setText("Player: " + name);

      }


      public void setupPLayerNameOnEnter(ActionEvent actionEvent) {
            setPLayerName();
      }

      public void setPLayerName(){
            playerName = nameField.getText();
            player.setText("Player: " + playerName);
      }

      public void startGame(MouseEvent mouseEvent) {

            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Parent root = null;
            try {
                  root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-view.fxml")));
            } catch (IOException e) {
                  e.printStackTrace();
            }
            stage.setScene(new Scene(root, 642, 700));
            stage.show();

      }

      public void exitGame(MouseEvent mouseEvent) {

                  Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                  stage.close();
            }

}
