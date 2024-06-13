package com.example.tictacv1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Objects;


public class GameApplication extends Application {

      private static final Logger logger = LogManager.getLogger(GameApplication.class);

      GameController controller = new GameController();
      @Override
      public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("setup.fxml"));  //game2-view.fxml alt game1-view.fxml alt setup.fxml
            Scene scene = new Scene(fxmlLoader.load(), 700, 720);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
            stage.setTitle("TicTacToe");
            stage.setScene(scene);
            stage.show();


      }

      public static void main(String[] args) {
            launch();
      }
}