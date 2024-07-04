import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            // Reading the matrix elements
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the trace
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Checking for duplicate elements in rows
            for (int i = 0; i < size; i++) {
                boolean[] seen = new boolean[size];
                for (int j = 0; j < size; j++) {
                    if (seen[matrix[i][j] - 1]) {
                        duplicateRows++;
                        break;
                    } else {
                        seen[matrix[i][j] - 1] = true;
                    }
                }
            }

            // Checking for duplicate elements in columns
            for (int j = 0; j < size; j++) {
                boolean[] seen = new boolean[size];
                for (int i = 0; i < size; i++) {
                    if (seen[matrix[i][j] - 1]) {
                        duplicateCols++;
                        break;
                    } else {
                        seen[matrix[i][j] - 1] = true;
                    }
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
            caseNumber++;
        }

        scanner.close();
    }
}