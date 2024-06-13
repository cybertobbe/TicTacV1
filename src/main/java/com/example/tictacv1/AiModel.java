package com.example.tictacv1;

import java.util.List;

public class AiModel {
    private final GameModel gameModel;

    public AiModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public int minimax(List<String> buttonsUsed, int depth, boolean isMaximizing) {
        String result = gameModel.getWinningLine();
        if (result.equals("XXX")) {
            return -10;
        } else if (result.equals("OOO")) {
            return 10;
        } else if (result.equals("Draw")) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                // Check if spot is available
                if (!buttonsUsed.get(i).equals("X") && !buttonsUsed.get(i).equals("O")) {
                    buttonsUsed.set(i, "O");
                    int score = minimax(buttonsUsed, depth + 1, false);
                    buttonsUsed.set(i, "");
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                // Check if spot is available
                if (!buttonsUsed.get(i).equals("X") && !buttonsUsed.get(i).equals("O")) {
                    buttonsUsed.set(i, "X");
                    int score = minimax(buttonsUsed, depth + 1, true);
                    buttonsUsed.set(i, "");
                    bestScore = Math.min(score, bestScore);

                }
            }
            return bestScore;
        }
    }

    public int findBestMove(List<String> buttonsUsed) {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;
        for (int i = 0; i < 9; i++) {
            // Check if spot is available
            if (!buttonsUsed.get(i).equals("X") && !buttonsUsed.get(i).equals("O")) {
                buttonsUsed.set(i, "O");
                int score = minimax(buttonsUsed, 0, false);
                buttonsUsed.set(i, "");
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }
}
