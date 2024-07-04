import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int[] results = processInput(scanner);
            int caseNumber = caseIndex + 1;
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, results[2], results[1], results[0]);
        }
        scanner.close();
    }

    private static int[] processInput(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        int[] results = { countRepeatedColumns(matrix), countRepeatedRows(matrix), calculateDiagonalSum(matrix) };
        return results;
    }

    private static int countRepeatedColumns(int[][] matrix) {
        int repeatedColumns = 0;
        
        for (int col = 0; col < matrix.length; col++) {
            boolean hasDuplicate = false;
            for (int row1 = 0; row1 < matrix.length; row1++) {
                for (int row2 = row1 + 1; row2 < matrix.length; row2++) {
                    if (matrix[row1][col] == matrix[row2][col]) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) break;
            }
            if (hasDuplicate) repeatedColumns++;
        }
        return repeatedColumns;
    }

    private static int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;
        
        for (int row = 0; row < matrix.length; row++) {
            boolean hasDuplicate = false;
            for (int col1 = 0; col1 < matrix.length; col1++) {
                for (int col2 = col1 + 1; col2 < matrix.length; col2++) {
                    if (matrix[row][col1] == matrix[row][col2]) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) break;
            }
            if (hasDuplicate) repeatedRows++;
        }
        return repeatedRows;
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int diagonalSum = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];
        }
        return diagonalSum;
    }
}