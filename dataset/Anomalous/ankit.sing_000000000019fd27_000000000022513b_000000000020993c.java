import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading matrix and calculating trace
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Checking for duplicate elements in each row
            for (int row = 0; row < matrixSize; row++) {
                boolean[] seen = new boolean[matrixSize];
                for (int col = 0; col < matrixSize; col++) {
                    int value = matrix[row][col];
                    if (seen[value - 1]) {
                        duplicateRows++;
                        break;
                    }
                    seen[value - 1] = true;
                }
            }

            // Checking for duplicate elements in each column
            for (int col = 0; col < matrixSize; col++) {
                boolean[] seen = new boolean[matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    int value = matrix[row][col];
                    if (seen[value - 1]) {
                        duplicateColumns++;
                        break;
                    }
                    seen[value - 1] = true;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}