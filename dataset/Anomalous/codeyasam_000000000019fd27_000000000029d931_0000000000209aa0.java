import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int nMatrix = scanner.nextInt();
            int kTrace = scanner.nextInt();
            int[][] latinMatrix = createLatinMatrix(nMatrix);
            boolean isPossible = checkMatrixPossibility(nMatrix, latinMatrix, kTrace);
            if (isPossible) {
                System.out.println("Case #" + i + ": POSSIBLE");
                printMatrix(latinMatrix);
            } else {
                rotateMatrix(latinMatrix);
                isPossible = verifyTrace(latinMatrix, kTrace);
                if (isPossible) {
                    System.out.println("Case #" + i + ": POSSIBLE");
                    printMatrix(latinMatrix);               
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");                    
                }
            }
        }
    }

    static int[][] createLatinMatrix(int n) { 
        int[][] matrix = new int[n][n];
        int k = n + 1; 
        for (int i = 0; i < n; i++) { 
            int col = 0;
            int temp = k; 
            while (temp <= n) { 
                matrix[i][col++] = temp++;
            } 
            for (int j = 1; j < k; j++) {
                matrix[i][col++] = j;
            }
            k--; 
        } 
        return matrix;
    }    

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }        
    }

    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        } 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static boolean verifyTrace(int[][] matrix, int trace) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum == trace;
    }

    public static boolean checkMatrixPossibility(int n, int[][] matrix, int kTrace) {     
        if (verifyTrace(matrix, kTrace)) return true;
        if (n == 1) return false;

        for (int i = 0; i < n - 1; i++) {
            if (checkMatrixPossibility(n - 1, matrix, kTrace)) return true;
            if (n % 2 == 0) {
                swapRows(matrix, i, n - 1);
            } else {
                swapRows(matrix, 0, n - 1);
            }
        }
        return checkMatrixPossibility(n - 1, matrix, kTrace);
    }

    private static void swapRows(int[][] matrix, int a, int b) {
        int[] temp = matrix[a];
        matrix[a] = matrix[b];
        matrix[b] = temp;
    }
}