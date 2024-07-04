import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            // Read matrix input
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate diagonal sum and check for repeated elements in rows and columns
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];

                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                boolean colHasDuplicates = false;

                for (int j = 0; j < size; j++) {
                    // Check for duplicate in the row
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicates = true;
                    }

                    // Check for duplicate in the column
                    if (!colSet.add(matrix[j][i])) {
                        colHasDuplicates = true;
                    }
                }

                if (rowHasDuplicates) repeatedRows++;
                if (colHasDuplicates) repeatedCols++;
            }

            System.out.printf("Case #%d: %d %d %d%n", t, diagonalSum, repeatedRows, repeatedCols);
        }
    }
}