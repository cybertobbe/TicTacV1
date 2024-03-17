package com.example.tictacv1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//New Branch

public class GameController {

      private final GameModel gameModel = new GameModel();
      //FXML connections
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
      public Label moveCounter;
      public Label playerPoints;
      public Label computerPoints;
      public Label winner;
      public List<Button> buttons = new ArrayList<>();
      public List<String> buttonsUsed = new ArrayList<>();

      private boolean isGameView = true;

      public GameController() {

      }

      public GameModel getGameModel() {
            return gameModel;
      }


      public void initialize(){
            //Runs after constructor, which doesn't see fxml files.
            //Initialize runs after FXML is loaded and have access to them.
            buttons = Arrays.asList(one, two, three, four, five, six, seven, eight, nine);
            buttons.forEach(button -> button.setFocusTraversable(false));
            //Set counter to 0
            playerPoints.setText("Player points " + gameModel.getPlayerPoints());
            moveCounter.setText("Moves: " + gameModel.getTotalMoveCounter());
            computerPoints.setText("Computer points " + gameModel.getComputerPoints());

            buttonsUsed = Arrays.asList("", "", "", "", "", "", "", "", "");

      }


      //PLayer plays
      public void clicked(MouseEvent mouseEvent) {

            int buttonClicked = 0;
            if (mouseEvent.getSource() == one) {
                  one.setText("X");
                  one.setDisable(true);
                  buttonClicked = 1;
                  gameModel.playerClick(buttonClicked, buttonsUsed);
            } else if (mouseEvent.getSource() == two) {
                  two.setText("X");
                  two.setDisable(true);
                  buttonClicked = 2;
                  gameModel.playerClick(buttonClicked, buttonsUsed);
            } else if (mouseEvent.getSource() == three) {
                  three.setText("X");
                  three.setDisable(true);
                  buttonClicked = 3;
                  gameModel.playerClick(buttonClicked, buttonsUsed);
            } else if (mouseEvent.getSource() == four) {
                  four.setText("X");
                  four.setDisable(true);
                  buttonClicked = 4;
                  gameModel.playerClick(buttonClicked, buttonsUsed);
            } else if (mouseEvent.getSource() == five) {
                  five.setText("X");
                  five.setDisable(true);
                  buttonClicked = 5;
                  gameModel.playerClick(buttonClicked, buttonsUsed);
            } else if (mouseEvent.getSource() == six) {
                  six.setText("X");
                  six.setDisable(true);
                  buttonClicked = 6;
                  gameModel.playerClick(buttonClicked, buttonsUsed);
            } else if (mouseEvent.getSource() == seven) {
                  seven.setText("X");
                  seven.setDisable(true);
                  buttonClicked = 7;
                  gameModel.playerClick(buttonClicked, buttonsUsed);
            } else if (mouseEvent.getSource() == eight) {
                  eight.setText("X");
                  eight.setDisable(true);
                  buttonClicked = 8;
                  gameModel.playerClick(buttonClicked, buttonsUsed);
            } else if (mouseEvent.getSource() == nine) {
                  nine.setText("X");
                  nine.setDisable(true);
                  buttonClicked = 9;
                  gameModel.playerClick(buttonClicked, buttonsUsed);
            }

            moveCounter.setText("Moves: " + gameModel.getTotalMoveCounter());

            //Check winner after player plays
            if(gameModel.isGameOver(buttonsUsed)) {
                  buttons.forEach(button -> button.setDisable(true));
                  updatePoints();
                  showWinner();
                  return;
            }

            //Computer plays
            buttonClicked = gameModel.computerPlay(buttonsUsed, buttonClicked);
            buttons.set(buttonClicked, buttons.get(buttonClicked));
            buttons.get(buttonClicked).setText("O");
            buttons.get(buttonClicked).setDisable(true);

            moveCounter.setText("Moves: " + gameModel.getTotalMoveCounter());

            //Check winner after computer plays
            if(gameModel.isGameOver(buttonsUsed)) {
                  buttons.forEach(button -> button.setDisable(true));
                  if(gameModel.getWinningLine().contentEquals("XXX")){
                        updatePoints();
                        showWinner();
                  }
                  else if(gameModel.getWinningLine().contentEquals("OOO")){
                        updatePoints();
                        showWinner();

                  }


            }

      }

      public void resetGameOnClick(MouseEvent mouseEvent) {
            //Reset game
            buttons.forEach(button -> button.setText(""));
            buttons.forEach(button -> button.setDisable(false));
            gameModel.setTotalMoveCounter(0);
            gameModel.setPlayerPoints(0);
            gameModel.setComputerPoints(0);
            moveCounter.setText("Moves: " + gameModel.getTotalMoveCounter());
            playerPoints.setText("Player points " + gameModel.getPlayerPoints());
            computerPoints.setText("Computer points " + gameModel.getComputerPoints());
            buttonsUsed = Arrays.asList("", "", "", "", "", "", "", "", "");
            winner.setText("");
      }

      public void newGameOnClick(MouseEvent mouseEvent) {
            buttons.forEach(button -> button.setText(""));
            buttons.forEach(button -> button.setDisable(false));
            gameModel.setTotalMoveCounter(0);
            moveCounter.setText("Moves: " + gameModel.getTotalMoveCounter());
            buttonsUsed = Arrays.asList("", "", "", "", "", "", "", "", "");
            winner.setText("");
      }

      public void updatePoints(){
            playerPoints.setText("Player points " + gameModel.getPlayerPoints());
            computerPoints.setText("Computer points " + gameModel.getComputerPoints());
      }

      public void showWinner(){
            switch (gameModel.getWinningLine()) {
                  case "XXX" -> winner.setText("Player wins in " + gameModel.getTotalMoveCounter() + " moves!");
                  case "OOO" -> winner.setText("Computer wins in " + gameModel.getTotalMoveCounter() + " moves!");
                  case "Draw" -> winner.setText("Draw!");
            }
      }


}