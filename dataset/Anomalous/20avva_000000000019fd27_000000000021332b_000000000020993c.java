import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    private static int t; // number of test cases
    private static int n; // matrix size
    private static int[][] matrix; // the matrix

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            t = scanner.nextInt();

            // Process each test case
            for (int i = 1; i <= t; i++) {
                n = scanner.nextInt(); // get the matrix size
                matrix = new int[n][n]; // allocate memory space

                // Populate the matrix
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = scanner.nextInt();
                    }
                }

                int k = calculateTrace(matrix);
                int r = countRepeatedRows(matrix);
                int c = countRepeatedColumns(matrix);

                System.out.printf("Case #%d: %d %d %d%n", i, k, r, c);
            }
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix) {
        int repeats = 0;
        for (int[] row : matrix) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                uniqueElements.add(element);
            }
            if (uniqueElements.size() < matrix.length) {
                repeats++;
            }
        }
        return repeats;
    }

    private static int countRepeatedColumns(int[][] matrix) {
        int repeats = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int[] row : matrix) {
                uniqueElements.add(row[col]);
            }
            if (uniqueElements.size() < matrix.length) {
                repeats++;
            }
        }
        return repeats;
    }
}