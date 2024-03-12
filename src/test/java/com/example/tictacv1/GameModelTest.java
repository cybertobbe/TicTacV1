package com.example.tictacv1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameModelTest {

      private GameModel model;


      @Test
      @DisplayName("Test if game over when player wins")
      public void testIfGameOverWhenPlayerWins() {
            // Arrange

            model = new GameModel();
            List<String> buttonsUsed = Arrays.asList("X", "X", "X", "O", "O", "", "", "", "");

            boolean gameOver = model.isGameOver(buttonsUsed);

            assertThat(gameOver).isTrue();
            assertEquals("XXX", model.getWinningLine());
            assertEquals(1, model.getPlayerPoints());
            assertEquals(0, model.getComputerPoints());
      }

      @Test
      @DisplayName("Test if game over when computer wins")
      public void testIfGameOverWhenComputerWins() {
            // Arrange

            model = new GameModel();
            List<String> buttonsUsed = Arrays.asList("O", "O", "O", "X", "X", "", "", "", "");

            // Act
            boolean gameOver = model.isGameOver(buttonsUsed);

            // Assert
            assertThat(gameOver).isTrue();
            assertEquals("OOO", model.getWinningLine());
            assertEquals(0, model.getPlayerPoints());
            assertEquals(1, model.getComputerPoints());
      }

      @Test
      @DisplayName("Test row win")
      public void testRowWin() {
            // Arrange
            model = new GameModel();
            //Test middle row  O win
            List<String> buttonsUsed = Arrays.asList("", "", "", "O", "O", "O", "", "", "");


            assertThat(model.isGameOver(buttonsUsed)).isTrue();


      }

      @Test
      @DisplayName("Test column win")
      public void testColumnWin() {

            model = new GameModel();
            // Test left side column X win
            List<String> buttonsUsed = Arrays.asList("X", "", "", "X", "", "", "X", "", "");

            assertThat(model.isGameOver(buttonsUsed)).isTrue();

      }

      @Test
      @DisplayName("Test diagonal win")
      public void testDiagonalWin() {

            model = new GameModel();
            // Test X diagonal win
            List<String> buttonsUsed = Arrays.asList("X", "", "", "", "X", "", "", "", "X");

            assertThat(model.isGameOver(buttonsUsed)).isTrue();

      }

      @Test
      @DisplayName("Test If Computer Finds A Valid Button To Play")
      void TestIfComputerFindsAValidButtonToPlay(){


            model = new GameModel();
            List<String> buttonsUsed = Arrays.asList("X", "", "", "", "X", "O", "X", "O", "X");
            int buttonClicked = 0;

            buttonClicked = model.validMove(buttonsUsed, new fixedRandom());
            assertThat(buttonClicked).isBetween(1, 3);


      }

}
