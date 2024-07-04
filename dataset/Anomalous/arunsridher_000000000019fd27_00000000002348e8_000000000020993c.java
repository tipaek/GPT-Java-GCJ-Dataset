package codejam2020;

import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of test cases
        int testCases = scanner.nextInt();

        // Process each test case
        for (int t = 1; t <= testCases; t++) {
            // Read matrix size
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Read matrix elements
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace (k)
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Calculate number of rows with repeated elements (r)
            int repeatedRows = 0;
            for (int i = 0; i < size; i++) {
                boolean[] seen = new boolean[size + 1];
                for (int j = 0; j < size; j++) {
                    if (seen[matrix[i][j]]) {
                        repeatedRows++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Calculate number of columns with repeated elements (c)
            int repeatedColumns = 0;
            for (int i = 0; i < size; i++) {
                boolean[] seen = new boolean[size + 1];
                for (int j = 0; j < size; j++) {
                    if (seen[matrix[j][i]]) {
                        repeatedColumns++;
                        break;
                    }
                    seen[matrix[j][i]] = true;
                }
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", t, trace, repeatedRows, repeatedColumns);
        }

        scanner.close();
    }
}