import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            Solution.run(scanner);
        }
    }

    public static void run(Scanner scanner) {
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            new Solution(scanner).processCase(caseNumber);
        }
    }

    public Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    private int rows, cols;
    private Adj[][] grid;

    private void processCase(int caseNumber) {
        rows = scanner.nextInt();
        cols = scanner.nextInt();
        grid = new Adj[rows][cols];
        HashSet<Adj> activeCells = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Adj cell = new Adj(i, j, scanner.nextInt());
                grid[i][j] = cell;
                activeCells.add(cell);
            }
        }

        List<Adj> cellsToRemove = new ArrayList<>();
        long totalInterest = 0;

        do {
            cellsToRemove.clear();
            for (Adj cell : activeCells) {
                totalInterest += cell.skill;
                if (cell.shouldBeEliminated()) {
                    cellsToRemove.add(cell);
                }
            }
            for (Adj cell : cellsToRemove) {
                activeCells.remove(cell);
                cell.active = false;
            }
        } while (!cellsToRemove.isEmpty());

        printResult(caseNumber, totalInterest);
    }

    private class Adj {
        final int row, col, skill;
        int up, down, left, right;
        boolean active = true;

        public Adj(int row, int col, int skill) {
            this.row = row;
            this.col = col;
            this.skill = skill;
            up = row - 1;
            down = row + 1;
            left = col - 1;
            right = col + 1;
        }

        boolean shouldBeEliminated() {
            double totalSkill = 0;
            int neighbors = 0;

            while (up >= 0 && !grid[up][col].active) {
                up--;
            }
            if (up >= 0) {
                totalSkill += grid[up][col].skill;
                neighbors++;
            }

            while (down < rows && !grid[down][col].active) {
                down++;
            }
            if (down < rows) {
                totalSkill += grid[down][col].skill;
                neighbors++;
            }

            while (left >= 0 && !grid[row][left].active) {
                left--;
            }
            if (left >= 0) {
                totalSkill += grid[row][left].skill;
                neighbors++;
            }

            while (right < cols && !grid[row][right].active) {
                right++;
            }
            if (right < cols) {
                totalSkill += grid[row][right].skill;
                neighbors++;
            }

            if (neighbors > 0) {
                double averageSkill = totalSkill / neighbors;
                return skill < averageSkill;
            }
            return false;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + col;
            result = prime * result + row;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Adj other = (Adj) obj;
            return col == other.col && row == other.row;
        }
    }

    private static void printResult(int caseNumber, long totalInterest) {
        System.out.printf("Case #%d: %d%n", caseNumber, totalInterest);
    }
}