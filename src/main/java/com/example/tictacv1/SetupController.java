package com.example.tictacv1;



import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SetupController {


      public TextField nameField;
      public Button setName;
      public Label player;
      static String playerName = "Anonymous";
      public Button exit;
      public Button startGame;
      public RadioButton checkDefault;
      public RadioButton checkBlack;


            public void initialize() {
                  //Initialize radiobuttons in the setup view
                  checkDefault.setUserData("game-view.fxml");
                  checkBlack.setUserData("game2-view.fxml");

                  //Set togglegroups for default and black
                  //only one radiobutton can be selected at a time
                  ToggleGroup group = new ToggleGroup();
                  checkDefault.setToggleGroup(group);
                  checkBlack.setToggleGroup(group);
                  checkDefault.setSelected(true);

            }

      public void setupPLayerNameOnMousePressed(MouseEvent mouseEvent) {
            setPLayerName();
      }


      public void setupPLayerNameOnEnter(ActionEvent actionEvent) {
            setPLayerName();
      }

      public void setPLayerName(){
            playerName = nameField.getText();
            if(nameField.getText().isEmpty()){
                  playerName = "Anonymous";
            }
            else {
                  player.setText("Player: " + playerName);
            }
      }

      public void startGame(MouseEvent mouseEvent) {

            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Parent root = null;
            String fxmlFile = null;
            if (checkDefault.isSelected()){
                  fxmlFile = (String) checkDefault.getUserData();
            } else if (checkBlack.isSelected()) {
                  fxmlFile = (String) checkBlack.getUserData();
            }
            try {


                  root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
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
