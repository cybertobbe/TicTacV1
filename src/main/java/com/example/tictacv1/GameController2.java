package com.example.tictacv1;


// Controller for game2-view.fxml

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameController2 extends Application {


      public Button one;
      public Button two;
      public Button three;
      public Button four;
      public Button five;
      public Button six;
      public Button seven;
      public Button eight;
      public Button nine;
      public Button resetGame;
      public Button newGame;
      public Label playerPoints;
      public Label computerPoints;
      public Label moveCounter;
      public Label winner;


      @Override
      public void start(Stage stage) throws IOException {

      }

      public void clicked(MouseEvent mouseEvent) {
      }


      public void resetGameOnClick(MouseEvent mouseEvent) {

      }


      public void newGameOnClick(MouseEvent mouseEvent) {

      }

//      public void changeView(MouseEvent mouseEvent) throws IOException {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("game-view.fxml"));
//            Parent root = loader.load();
//            GameController2 secondController = loader.getController();
//      }


      public void changeView(MouseEvent mouseEvent) {
            try {
                  Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-view.fxml")));
                  Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                  Scene scene = new Scene(root);
                  stage.setScene(scene);
                  stage.show();
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }
}
