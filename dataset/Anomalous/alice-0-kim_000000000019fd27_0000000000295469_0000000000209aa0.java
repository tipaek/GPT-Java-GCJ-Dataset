import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int targetSum = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int[] diagonal = new int[size];
            
            if (isValidDiagonal(diagonal, size, targetSum)) {
                for (int i = 0; i < size; i++) {
                    matrix[i][i] = diagonal[i];
                }
                if (fillMatrix(matrix, size)) {
                    System.out.printf("Case #%d: %s\n%s", t, "POSSIBLE", formatMatrix(matrix, size));
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
    
    private static boolean isValidDiagonal(int[] diagonal, int size, int targetSum) {
        Arrays.fill(diagonal, size);
        int currentSum = size * size;
        for (int i = 0; currentSum > targetSum; i = (i + 1) % size) {
            diagonal[i]--;
            currentSum--;
        }
        return currentSum == targetSum;
    }
    
    private static boolean isValidPlacement(int[][] matrix, int row, int col, int size) {
        Set<Integer> seenNumbers = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (seenNumbers.contains(matrix[row][i])) {
                return false;
            }
            if (matrix[row][i] != 0) {
                seenNumbers.add(matrix[row][i]);
            }
        }
        seenNumbers.clear();
        for (int i = 0; i < size; i++) {
            if (seenNumbers.contains(matrix[i][col])) {
                return false;
            }
            if (matrix[i][col] != 0) {
                seenNumbers.add(matrix[i][col]);
            }
        }
        return true;
    }
    
    private static String formatMatrix(int[][] matrix, int size) {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                result.append(matrix[row][col]);
                if (col < size - 1) {
                    result.append(" ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}