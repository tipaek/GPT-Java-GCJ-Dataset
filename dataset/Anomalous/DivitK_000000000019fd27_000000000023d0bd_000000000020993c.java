import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Read the matrix
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Calculate the number of rows with duplicate elements
            int duplicateRows = 0;
            for (int r = 0; r < size; r++) {
                boolean[] seen = new boolean[size + 1];
                for (int c = 0; c < size; c++) {
                    if (seen[matrix[r][c]]) {
                        duplicateRows++;
                        break;
                    }
                    seen[matrix[r][c]] = true;
                }
            }

            // Calculate the number of columns with duplicate elements
            int duplicateCols = 0;
            for (int c = 0; c < size; c++) {
                boolean[] seen = new boolean[size + 1];
                for (int r = 0; r < size; r++) {
                    if (seen[matrix[r][c]]) {
                        duplicateCols++;
                        break;
                    }
                    seen[matrix[r][c]] = true;
                }
            }

            // Print the result for this test case
            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}