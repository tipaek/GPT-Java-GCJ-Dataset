import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int diagonalSum = calculateDiagonalSum(matrix);
            int rowDuplicates = countDuplicateRows(matrix);
            int columnDuplicates = countDuplicateColumns(matrix);
            
            System.out.printf("Case #%d: %d %d %d%n", testCase, diagonalSum, rowDuplicates, columnDuplicates);
        }
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateCount = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasDuplicates = false;
            for (int value : row) {
                if (!uniqueElements.add(value)) {
                    hasDuplicates = true;
                }
            }
            if (hasDuplicates) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateCount = 0;
        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasDuplicates = false;
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    hasDuplicates = true;
                }
            }
            if (hasDuplicates) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
}