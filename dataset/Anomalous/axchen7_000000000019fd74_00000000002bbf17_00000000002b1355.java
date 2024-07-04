import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            Cell[][] grid = new Cell[rows][cols];
            long totalInterest = 0;
            long currentInterest = 0;
            
            // Initialize the grid and calculate initial interest
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = new Cell(scanner.nextInt());
                    currentInterest += grid[i][j].skill;
                }
            }
            
            // Set up neighboring cells
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i > 0) grid[i][j].prevRow = grid[i - 1][j];
                    if (i < rows - 1) grid[i][j].nextRow = grid[i + 1][j];
                    if (j > 0) grid[i][j].prevCol = grid[i][j - 1];
                    if (j < cols - 1) grid[i][j].nextCol = grid[i][j + 1];
                }
            }

            HashSet<Cell> toRemove = new HashSet<>();
            HashSet<Cell> toCheck = new HashSet<>();
            
            // Add all cells to the check set initially
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    toCheck.add(grid[i][j]);
                }
            }

            while (true) {
                totalInterest += currentInterest;

                // Identify cells to be removed
                for (Cell cell : toCheck) {
                    if (cell.shouldBeRemoved()) {
                        toRemove.add(cell);
                    }
                }

                if (toRemove.isEmpty()) {
                    break;
                }

                toCheck.clear();
                
                // Remove cells and update neighbors
                for (Cell cell : toRemove) {
                    currentInterest -= cell.skill;
                    if (cell.prevRow != null) cell.prevRow.nextRow = cell.nextRow;
                    if (cell.nextRow != null) cell.nextRow.prevRow = cell.prevRow;
                    if (cell.prevCol != null) cell.prevCol.nextCol = cell.nextCol;
                    if (cell.nextCol != null) cell.nextCol.prevCol = cell.prevCol;

                    // Add neighboring cells to check set if not already marked for removal
                    if (cell.prevRow != null && !toRemove.contains(cell.prevRow)) toCheck.add(cell.prevRow);
                    if (cell.nextRow != null && !toRemove.contains(cell.nextRow)) toCheck.add(cell.nextRow);
                    if (cell.prevCol != null && !toRemove.contains(cell.prevCol)) toCheck.add(cell.prevCol);
                    if (cell.nextCol != null && !toRemove.contains(cell.nextCol)) toCheck.add(cell.nextCol);
                }
                toRemove.clear();
            }

            System.out.println("Case #" + testCase + ": " + totalInterest);
        }
        scanner.close();
    }

    static class Cell {
        int skill;
        Cell prevRow;
        Cell nextRow;
        Cell prevCol;
        Cell nextCol;

        Cell(int skill) {
            this.skill = skill;
        }

        boolean shouldBeRemoved() {
            int totalSkill = 0;
            int neighborCount = 0;
            if (prevRow != null) {
                totalSkill += prevRow.skill;
                neighborCount++;
            }
            if (nextRow != null) {
                totalSkill += nextRow.skill;
                neighborCount++;
            }
            if (prevCol != null) {
                totalSkill += prevCol.skill;
                neighborCount++;
            }
            if (nextCol != null) {
                totalSkill += nextCol.skill;
                neighborCount++;
            }
            return neighborCount > 0 && skill * neighborCount < totalSkill;
        }
    }
}