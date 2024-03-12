package com.example.tictacv1;


import java.util.List;
import java.util.Random;

public class GameModel {


      Random random = new Random();
      private int totalMoveCounter;
      private String winningLine = "";
      private int playerPoints;
      private int computerPoints;

      public GameModel() {

            totalMoveCounter = 0;

      }

      //Constructor for testing
      public GameModel(Random random) {
            this.random = random;

      }




      public void playerClick(int buttonClicked, List<String> buttonsUsed) {
            //This method is called from GameController when a button is clicked
            buttonsUsed.set(buttonClicked-1, "X");
            setTotalMoveCounter(getTotalMoveCounter() + 1);

      }


      public int computerPlay(List<String> buttonsUsed, int buttonClicked) {

            buttonClicked = validMove(buttonsUsed, random);
            //Computer sets in String arrayList to indicate that the button is used
            buttonsUsed.set(buttonClicked, "O");

            setTotalMoveCounter(getTotalMoveCounter() + 1);


            return buttonClicked;

      }
      //Extracted method from computerPlay to check if the button is used
      public int validMove(List<String> buttonsUsed, Random random) {

            int buttonClicked = random.nextInt(0, 8);

            while (buttonsUsed.get(buttonClicked).equals("X") || buttonsUsed.get(buttonClicked).equals("O")) {
                  buttonClicked = random.nextInt(0, 8);
            }
            return buttonClicked;
      }


      public boolean isGameOver(List<String> buttonsUsed) {
            String row1 = buttonsUsed.get(0) + buttonsUsed.get(1) + buttonsUsed.get(2);
            String row2 = buttonsUsed.get(3) + buttonsUsed.get(4) + buttonsUsed.get(5);
            String row3 = buttonsUsed.get(6) + buttonsUsed.get(7) + buttonsUsed.get(8);
            String col1 = buttonsUsed.get(0) + buttonsUsed.get(3) + buttonsUsed.get(6);
            String col2 = buttonsUsed.get(1) + buttonsUsed.get(4) + buttonsUsed.get(7);
            String col3 = buttonsUsed.get(2) + buttonsUsed.get(5) + buttonsUsed.get(8);
            String diag1 = buttonsUsed.get(0) + buttonsUsed.get(4) + buttonsUsed.get(8);
            String diag2 = buttonsUsed.get(2) + buttonsUsed.get(4) + buttonsUsed.get(6);

            if(row1.contentEquals("XXX") || row2.contentEquals("XXX") || row3.contentEquals("XXX") || col1.contentEquals("XXX") || col2.contentEquals("XXX") || col3.contentEquals("XXX") || diag1.contentEquals("XXX") || diag2.contentEquals("XXX")) {
                  winningLine = "XXX";
                  setPlayerPoints(getPlayerPoints() + 1);
                  return true;
            }

            else if(row1.contentEquals("OOO") || row2.contentEquals("OOO") || row3.contentEquals("OOO") || col1.contentEquals("OOO") || col2.contentEquals("OOO") || col3.contentEquals("OOO") || diag1.contentEquals("OOO") || diag2.contentEquals("OOO")) {
                  winningLine = "OOO";
                  setComputerPoints(getComputerPoints() + 1);
                  return true;
            }

            else if(getTotalMoveCounter() == 9){
                  winningLine = "Draw";
                  return true;
            }
            else{
                  return false;
            }
      }


      public int getTotalMoveCounter() {
            return totalMoveCounter;
      }

      public void setTotalMoveCounter(int totalMoveCounter) {
            this.totalMoveCounter = totalMoveCounter;
      }



      public int getPlayerPoints() {
            return playerPoints;
      }

      public void setPlayerPoints(int playerPoints) {
            this.playerPoints = playerPoints;
      }

      public int getComputerPoints() {
            return computerPoints;
      }

      public void setComputerPoints(int computerPoints) {
            this.computerPoints = computerPoints;
      }

      public String getWinningLine() {
            return winningLine;
      }
}
