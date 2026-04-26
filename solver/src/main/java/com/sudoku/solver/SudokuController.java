package com.sudoku.solver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sudoku")
@CrossOrigin // Allows frontend connection
public class SudokuController {
    @Autowired
    private SudokuService service;

    @GetMapping("/generate")
    public int[][] getNewGame() {
        return service.generateBoard();
    }

    @PostMapping("/solve")
    public int[][] solveGame(@RequestBody int[][] board) {
        service.solve(board);
        return board;
    }
}