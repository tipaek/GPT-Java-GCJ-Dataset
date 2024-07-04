import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix);
            int rowsWithRepeats = countRowsWithRepeats(matrix);
            int colsWithRepeats = countColsWithRepeats(matrix);
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowsWithRepeats + " " + colsWithRepeats);
        }
        
        scanner.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowsWithRepeats(int[][] matrix) {
        int rowsWithRepeats = 0;
        
        for (int[] row : matrix) {
            if (hasRepeats(row)) {
                rowsWithRepeats++;
            }
        }
        
        return rowsWithRepeats;
    }

    private static int countColsWithRepeats(int[][] matrix) {
        int colsWithRepeats = 0;
        
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasRepeats(column)) {
                colsWithRepeats++;
            }
        }
        
        return colsWithRepeats;
    }

    private static boolean hasRepeats(int[] array) {
        boolean[] seen = new boolean[array.length + 1]; // assuming elements are 1-based and within the range
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}