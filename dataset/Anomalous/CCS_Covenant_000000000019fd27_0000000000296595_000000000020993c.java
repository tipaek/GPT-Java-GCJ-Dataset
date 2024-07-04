import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        
        for (int i = 0; i < numCases; i++) {
            int[] results = calculateResults(scanner);
            System.out.printf("Case #%d: %d %d %d%n", i + 1, results[2], results[1], results[0]);
        }
    }

    public static int[] calculateResults(Scanner scanner) {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        int[] results = {countDuplicateRows(matrix), countDuplicateColumns(matrix), calculateDiagonalSum(matrix)};
        return results;
    }

    public static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRowCount++;
            }
        }
        
        return duplicateRowCount;
    }

    public static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            
            if (hasDuplicates(column)) {
                duplicateColumnCount++;
            }
        }
        
        return duplicateColumnCount;
    }

    public static int calculateDiagonalSum(int[][] matrix) {
        int diagonalSum = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];
        }
        
        return diagonalSum;
    }

    public static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}