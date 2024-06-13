package com.example.tictacv1;



import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Objects;

public class SetupController {


      private static final Logger logger = LogManager.getLogger(SetupController.class);

      public TextField nameField;
      public Button setName;
      public Label player;
      static String playerName = "Anonymous";
      public Button exit;
      public Button startGame;
      public CheckBox checkDefault;
      public CheckBox checkBlack;
      public RadioButton checkAi;


      private final GameModel gameModel = GameModel.getInstance();


            public void initialize() {
                  System.out.println("Setting AI: " + checkAi.isSelected());
                  //Initialize checkboxes in the setup view
                  checkDefault.setUserData("game-view.fxml");
                  checkBlack.setUserData("game2-view.fxml");
                  checkDefault.setSelected(true);
                  checkAi.setOnAction(e -> {
                        gameModel.setAiEnabled(checkAi.isSelected());
                        System.out.println("AI is enabled: " + checkAi.isSelected());
                  });
            }

      public void setupPLayerNameOnMousePressed(MouseEvent mouseEvent) {
            setPLayerName();
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
            String fxmlFile = null;
            if (checkDefault.isSelected()){
                  fxmlFile = (String) checkDefault.getUserData();
            } else if (checkBlack.isSelected()) {
                  fxmlFile = (String) checkBlack.getUserData();
            }
            try {

                assert fxmlFile != null;
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
            } catch (IOException e) {
                  logger.error("Error: ", e);
            }
            stage.setScene(new Scene(root, 642, 700));
            stage.show();

      }

      public void exitGame(MouseEvent mouseEvent) {

                  Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                  stage.close();
            }


}
