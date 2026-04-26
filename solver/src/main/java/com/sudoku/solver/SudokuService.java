package com.sudoku.solver;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SudokuService {
    private final Random random = new Random();

    // Generates a random board by filling diagonal boxes first, 
    // solving it, then removing numbers.
    public int[][] generateBoard() {
        int[][] board = new int[9][9];
        fillDiagonalBoxes(board);
        solve(board);
        removeDigits(board, 40); // 40 empty spaces
        return board;
    }

    public boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num ||
                    board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) return false;
        }
        return true;
    }

    private void fillDiagonalBoxes(int[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    int num;
                    do { num = random.nextInt(9) + 1; }
                    while (!isUsedInBox(board, i, i, num));
                    board[i + r][i + c] = num;
                }
            }
        }
    }

    private boolean isUsedInBox(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[row + i][col + j] == num) return false;
        return true;
    }

    private void removeDigits(int[][] board, int count) {
        while (count > 0) {
            int cellId = random.nextInt(81);
            int r = cellId / 9;
            int c = cellId % 9;
            if (board[r][c] != 0) {
                board[r][c] = 0;
                count--;
            }
        }
    }
}