import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read the matrix and calculate trace and row repeats
            for (int row = 0; row < n; row++) {
                String[] rowValues = scanner.nextLine().split("\\s+");
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowHasRepeats = false;

                for (int col = 0; col < n; col++) {
                    int value = Integer.parseInt(rowValues[col]);
                    matrix[row][col] = value;

                    if (col == row) {
                        trace += value;
                    }

                    if (rowCheck[value]) {
                        rowHasRepeats = true;
                    } else {
                        rowCheck[value] = true;
                    }
                }

                if (rowHasRepeats) {
                    rowRepeats++;
                }
            }

            // Calculate column repeats
            for (int col = 0; col < n; col++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean colHasRepeats = false;

                for (int row = 0; row < n; row++) {
                    int value = matrix[row][col];

                    if (colCheck[value]) {
                        colHasRepeats = true;
                    } else {
                        colCheck[value] = true;
                    }
                }

                if (colHasRepeats) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}