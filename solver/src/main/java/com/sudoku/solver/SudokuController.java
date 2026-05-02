package com.sudoku.solver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sudoku")
@CrossOrigin(origins = "*")
public class SudokuController {

    private final SudokuService sudokuService;

    public SudokuController(SudokuService sudokuService) {
        this.sudokuService = sudokuService;
    }

    @GetMapping("/generate")
    public int[][] generatePuzzle(@RequestParam(defaultValue = "40") int emptySpaces) {
        return sudokuService.generateBoard(emptySpaces);
    }

    @PostMapping("/solve")
    public ResponseEntity<?> solvePuzzle(@RequestBody int[][] board) {

        int[][] copy = new int[9][9];
        for (int i = 0; i < 9; i++) {
            copy[i] = board[i].clone();
        }

        if (!sudokuService.solve(copy)) {
            return ResponseEntity.badRequest().body("Unsolvable board");
        }

        return ResponseEntity.ok(copy);
    }
}
