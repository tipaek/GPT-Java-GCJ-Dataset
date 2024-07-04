import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static String checkTrace(int[][] matrix, int caseNumber) {
        int rowCount = 0;
        int colCount = 0;
        int trace = 0;

        for (int row = 0; row < matrix.length; row++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int col = 0; col < matrix[row].length; col++) {
                rowSet.add(matrix[row][col]);
            }
            if (rowSet.size() != matrix.length) {
                rowCount++;
            }
        }

        for (int col = 0; col < matrix.length; col++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                colSet.add(matrix[row][col]);
            }
            if (colSet.size() != matrix.length) {
                colCount++;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        return "Case #" + (caseNumber + 1) + ": " + trace + " " + rowCount + " " + colCount;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        StringBuilder result = new StringBuilder();

        for (int testCaseCounter = 0; testCaseCounter < numTestCases; testCaseCounter++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                String[] rowItems = scanner.nextLine().split(" ");
                for (int j = 0; j < rowItems.length; j++) {
                    matrix[i][j] = Integer.parseInt(rowItems[j]);
                }
            }

            result.append(checkTrace(matrix, testCaseCounter)).append("\n");
        }

        System.out.print(result.toString());
    }
}