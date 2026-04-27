# Full-Stack Sudoku Solver & Generator 🧩

A complete full-stack web application that generates random, valid Sudoku puzzles of varying difficulties and solves them instantly using a custom-built backtracking algorithm. 


## 💡 About the Project
This project was built to demonstrate full-stack architecture, connecting a sleek, vanilla web frontend to a robust Java Spring Boot backend. 

Instead of relying on hardcoded puzzles, the backend mathematically generates a unique, valid 9x9 Sudoku board on every request. It also features a solver endpoint that utilizes a highly optimized recursive backtracking algorithm to compute the solution to any valid board instantly.

### Key Features
* **Dynamic Puzzle Generation:** Generates unique puzzles on the fly with adjustable difficulty levels (Easy, Medium, Hard, Expert).
* **Algorithmic Solver:** Implements a recursive backtracking algorithm in Java to guarantee accurate solutions.
* **REST API Architecture:** Clean separation of concerns between the Java backend and the HTML/JS frontend.
* **Interactive UI:** Responsive, CSS-grid-based board with input validation, visual state indicators, and real-time user feedback.

## 🛠️ Tech Stack
* **Backend:** Java (17/21), Spring Boot, Spring Web (REST API)
* **Frontend:** HTML5, CSS3, Vanilla JavaScript (ES6+), Fetch API
* **Architecture:** Client-Server, MVC Pattern

## 🧠 How the Algorithm Works
1. **Generation:** The Java service first fills the three diagonal 3x3 subgrids (which are completely independent of each other). It then uses the solver algorithm to fill the rest of the board. Finally, it randomly removes a specific number of digits based on the selected difficulty to create the puzzle.
2. **Solving:** The solver uses a **Recursive Backtracking Algorithm**. It scans the 9x9 matrix for an empty space (0), attempts to place a digit (1-9), checks if the placement follows Sudoku rules (row, column, and 3x3 grid validation), and recursively attempts to fill the next cell. If it hits a dead end, it backtracks, resets the cell, and tries the next number.

## ⚙️ Local Setup and Installation

### Prerequisites
* Java Development Kit (JDK) 17 or higher
* Maven
* A web browser

### Running the Backend (Spring Boot)
1. Clone the repository:
   ```bash
   git clone [https://github.com/YourUsername/sudoku-solver.git](https://github.com/YourUsername/sudoku-solver.git)
