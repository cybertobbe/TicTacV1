package com.example.tictacv1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AiModel {
    private final GameModel gameModel;
    private static final Logger logger = LogManager.getLogger(AiModel.class);

    public AiModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    private int evaluate(List<String> board) {
        // Check rows, columns, diagonals
        int[][] lines = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // cols
                {0, 4, 8}, {2, 4, 6}             // diagonals
        };

        for (int[] line : lines) {
            String a = board.get(line[0]);
            String b = board.get(line[1]);
            String c = board.get(line[2]);
            if (a.equals(b) && b.equals(c)) {
                if (a.equals("O")) return 10;
                if (a.equals("X")) return -10;
            }
        }
        return 0;
    }

    private boolean hasMovesLeft(List<String> board) {
        for (String cell : board) {
            if (cell.isEmpty()) return true;
        }
        return false;
    }

    public int minimax(List<String> buttonsUsed, int depth, boolean isMaximizing) {
        int score = evaluate(buttonsUsed);

        if (score == 10 || score == -10) return score;
        if (!hasMovesLeft(buttonsUsed)) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (buttonsUsed.get(i).isEmpty()) {
                    buttonsUsed.set(i, "O");
                    bestScore = Math.max(bestScore, minimax(buttonsUsed, depth + 1, false));
                    buttonsUsed.set(i, "");
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (buttonsUsed.get(i).isEmpty()) {
                    buttonsUsed.set(i, "X");
                    bestScore = Math.min(bestScore, minimax(buttonsUsed, depth + 1, true));
                    buttonsUsed.set(i, "");
                }
            }
            return bestScore;
        }
    }

    public int findBestMove(List<String> buttonsUsed) {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;

        for (int i = 0; i < 9; i++) {
            if (buttonsUsed.get(i).isEmpty()) {
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
