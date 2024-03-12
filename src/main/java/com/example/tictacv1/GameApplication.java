package com.example.tictacv1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//New Branch
public class GameApplication extends Application {

      GameController controller = new GameController();
      @Override
      public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 720);
            stage.setTitle("TicTacToe");
            stage.setScene(scene);
            stage.show();


      }

      public static void main(String[] args) {
            launch();
      }
}