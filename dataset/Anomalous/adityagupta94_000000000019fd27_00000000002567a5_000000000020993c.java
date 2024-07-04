import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;
            int[][] matrix = new int[size][size];

            // Read the matrix and calculate the trace
            for (int i = 0; i < size; i++) {
                boolean[] rowCheck = new boolean[size];
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j] - 1]) {
                        duplicateRows++;
                        break;
                    }
                    rowCheck[matrix[i][j] - 1] = true;
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < size; j++) {
                boolean[] columnCheck = new boolean[size];
                for (int i = 0; i < size; i++) {
                    if (columnCheck[matrix[i][j] - 1]) {
                        duplicateColumns++;
                        break;
                    }
                    columnCheck[matrix[i][j] - 1] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateColumns);
        }

        scanner.close();
    }
}