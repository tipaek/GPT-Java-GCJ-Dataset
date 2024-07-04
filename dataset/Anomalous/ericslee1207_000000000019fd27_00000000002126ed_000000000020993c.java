import java.util.HashSet;
import java.util.Scanner;

class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int dimension = scanner.nextInt();
            int[][] grid = new int[dimension][dimension];
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Reading the grid and calculating diagonal sum and row duplicates
            for (int i = 0; i < dimension; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasRowDuplicate = false;
                for (int j = 0; j < dimension; j++) {
                    int num = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += num;
                    }
                    if (!rowSet.add(num)) {
                        hasRowDuplicate = true;
                    }
                    grid[i][j] = num;
                }
                if (hasRowDuplicate) {
                    rowDuplicates++;
                }
            }

            // Calculating column duplicates
            for (int j = 0; j < dimension; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean hasColDuplicate = false;
                for (int i = 0; i < dimension; i++) {
                    if (!colSet.add(grid[i][j])) {
                        hasColDuplicate = true;
                    }
                }
                if (hasColDuplicate) {
                    colDuplicates++;
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}