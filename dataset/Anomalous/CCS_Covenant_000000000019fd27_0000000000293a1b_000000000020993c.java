import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int[] results = processCase(scanner);
            System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, results[0], results[1], results[2]);
        }
    }

    private static int[] processCase(Scanner scanner) {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        int expectedSum = (size + 1) / 2 * size;
        int rowErrors = countRowErrors(matrix, expectedSum);
        int columnErrors = countColumnErrors(matrix, expectedSum);
        int diagonalSum = calculateDiagonalSum(matrix);
        
        return new int[] {rowErrors, columnErrors, diagonalSum};
    }

    private static int countRowErrors(int[][] matrix, int expectedSum) {
        int errors = 0;
        
        for (int[] row : matrix) {
            int rowSum = 0;
            for (int value : row) {
                rowSum += value;
            }
            if (rowSum != expectedSum) {
                errors++;
            }
        }
        
        return errors;
    }

    private static int countColumnErrors(int[][] matrix, int expectedSum) {
        int errors = 0;
        
        for (int col = 0; col < matrix.length; col++) {
            int colSum = 0;
            for (int[] row : matrix) {
                colSum += row[col];
            }
            if (colSum != expectedSum) {
                errors++;
            }
        }
        
        return errors;
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int diagonalSum = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];
        }
        
        return diagonalSum;
    }
}