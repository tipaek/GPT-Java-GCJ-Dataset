import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        int[] results = new int[testCases * 3];

        for (int i = 0; i < testCases * 3; i += 3) {
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            int matrixSize = scanner.nextInt();

            boolean[][] rowOccurrences = new boolean[matrixSize][matrixSize];
            boolean[][] colOccurrences = new boolean[matrixSize][matrixSize];

            boolean[] rowFlags = new boolean[matrixSize];
            boolean[] colFlags = new boolean[matrixSize];

            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                rowFlags[row] = false;
                colFlags[row] = false;
                for (int col = 0; col < matrixSize; col++) {
                    rowOccurrences[row][col] = false;
                    colOccurrences[row][col] = false;
                }
            }

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();

                    if (!rowFlags[row] && rowOccurrences[row][matrix[row][col] - 1]) {
                        rowCount++;
                        rowFlags[row] = true;
                    } else {
                        rowOccurrences[row][matrix[row][col] - 1] = true;
                    }

                    if (!colFlags[col] && colOccurrences[matrix[row][col] - 1][col]) {
                        colCount++;
                        colFlags[col] = true;
                    } else {
                        colOccurrences[matrix[row][col] - 1][col] = true;
                    }

                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            results[i] = trace;
            results[i + 1] = rowCount;
            results[i + 2] = colCount;
        }
        scanner.close();

        for (int i = 0, caseNumber = 1; i < testCases * 3; i += 3, caseNumber++) {
            System.out.println("Case #" + caseNumber + ": " + results[i] + " " + results[i + 1] + " " + results[i + 2]);
        }
    }
}