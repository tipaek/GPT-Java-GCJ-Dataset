import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            if (fillMatrix(matrix, n, k)) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                printMatrix(matrix, n);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
    
    private static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private static boolean fillMatrix(int[][] matrix, int size, int k) {
        int diagonalSum = 0;
        boolean isDiagonalIncomplete = false;
        
        for (int i = 0; i < size; i++) {
            if (matrix[i][i] == 0) {
                isDiagonalIncomplete = true;
                break;
            } else {
                diagonalSum += matrix[i][i];
            }
        }
        
        if (!isDiagonalIncomplete && diagonalSum != k) {
            return false;
        }
        
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        
        if (isEmpty) {
            return true;
        }
        
        for (int num = 1; num <= size; num++) {
            if (isSafe(matrix, row, col, num)) {
                matrix[row][col] = num;
                if (fillMatrix(matrix, size, k)) {
                    return true;
                } else {
                    matrix[row][col] = 0;
                }
            }
        }
        
        return false;
    }
    
    private static boolean isSafe(int[][] matrix, int row, int col, int num) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] == num || matrix[i][col] == num) {
                return false;
            }
        }
        return true;
    }
}