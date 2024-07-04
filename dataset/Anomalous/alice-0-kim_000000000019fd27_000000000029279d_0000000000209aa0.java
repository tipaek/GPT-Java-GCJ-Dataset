import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int trace = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int[] diagonal = new int[size];
            
            if (canFormDiagonal(diagonal, size, trace)) {
                for (int i = 0; i < size; i++) {
                    matrix[i][i] = diagonal[i];
                }
                
                if (fillMatrix(matrix, size)) {
                    System.out.printf("Case #%d: %s\n%s\n", t, "POSSIBLE", formatMatrix(matrix, size));
                } else {
                    System.out.printf("Case #%d: %s\n", t, "IMPOSSIBLE");
                }
            } else {
                System.out.printf("Case #%d: %s\n", t, "IMPOSSIBLE");
            }
        }
    }
    
    private static boolean fillMatrix(int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 0) {
                    for (int num = 1; num <= size; num++) {
                        matrix[row][col] = num;
                        if (isValidPlacement(matrix, row, col, size) && fillMatrix(matrix, size)) {
                            return true;
                        }
                        matrix[row][col] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean canFormDiagonal(int[] diagonal, int size, int trace) {
        Arrays.fill(diagonal, size);
        int sum = size * size;
        
        for (int i = 0; i < size; i++) {
            if (sum == trace) {
                return true;
            }
            diagonal[i] -= Math.min(sum - trace, size - 1);
            sum -= Math.min(sum - trace, size - 1);
        }
        return false;
    }
    
    private static boolean isValidPlacement(int[][] matrix, int row, int col, int size) {
        Set<Integer> uniqueElements = new HashSet<>();
        
        for (int i = 0; i < size; i++) {
            if (uniqueElements.contains(matrix[row][i])) {
                return false;
            }
            if (matrix[row][i] != 0) {
                uniqueElements.add(matrix[row][i]);
            }
        }
        
        uniqueElements.clear();
        
        for (int i = 0; i < size; i++) {
            if (uniqueElements.contains(matrix[i][col])) {
                return false;
            }
            if (matrix[i][col] != 0) {
                uniqueElements.add(matrix[i][col]);
            }
        }
        return true;
    }
    
    private static String formatMatrix(int[][] matrix, int size) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.append(matrix[i][j]);
                if (j < size - 1) {
                    result.append(" ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}