import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int targetSum = scanner.nextInt();
            
            initializeMatrix(matrix, size);
            
            if (isPossible(matrix, targetSum, size)) {
                System.out.println("Case #" + caseNum + ": POSSIBLE");
                printMatrix(matrix, size);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
    
    private static void initializeMatrix(int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = (row + col) % size + 1;
            }
        }
    }
    
    private static boolean isPossible(int[][] matrix, int targetSum, int size) {
        matrix = scramble(matrix, 0, targetSum, size);
        int currentSum = calculateDiagonalSum(matrix, size);
        return currentSum == targetSum;
    }
    
    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    
    private static int[][] scramble(int[][] matrix, int start, int targetSum, int size) {
        if (calculateDiagonalSum(matrix, size) == targetSum) {
            return matrix;
        }
        
        for (int i = start + 1; i < size; i++) {
            swapRows(matrix, start, i);
            matrix = scramble(matrix, start + 1, targetSum, size);
            if (calculateDiagonalSum(matrix, size) == targetSum) {
                return matrix;
            }
        }
        
        return matrix;
    }
    
    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }
    
    private static void printMatrix(int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}