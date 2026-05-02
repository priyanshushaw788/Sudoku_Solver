package com.sudoku.solver;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SudokuService {

    private final Random random = new Random();

    public int[][] generateBoard(int emptySpaces) {
        int[][] board = new int[9][9];

        fillDiagonalBoxes(board);
        solve(board);
        removeDigits(board, emptySpaces);

        return board;
    }

    public boolean solve(int[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == 0) {

                    List<Integer> nums = new ArrayList<>();
                    for (int i = 1; i <= 9; i++) nums.add(i);
                    Collections.shuffle(nums);

                    for (int num : nums) {
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
                    board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    private void fillDiagonalBoxes(int[][] board) {

        for (int i = 0; i < 9; i += 3) {

            List<Integer> nums = new ArrayList<>();
            for (int n = 1; n <= 9; n++) nums.add(n);
            Collections.shuffle(nums);

            int index = 0;

            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    board[i + r][i + c] = nums.get(index++);
                }
            }
        }
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
