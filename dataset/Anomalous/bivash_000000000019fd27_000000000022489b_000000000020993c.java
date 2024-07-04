import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        String[] results = new String[t];
        
        for (int a = 0; a < t; a++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }
            
            results[a] = String.format("Case #%d: %d %d %d", a + 1, calculateDiagonalSum(matrix), countDuplicateRows(matrix), countDuplicateColumns(matrix));
        }
        
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static long calculateDiagonalSum(int[][] matrix) {
        long sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateRows++;
                    break;
                }
            }
        }
        
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        int n = matrix.length;
        
        for (int col = 0; col < n; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        
        return duplicateColumns;
    }
}