import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            // Read matrix and calculate diagonal sum
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }
            
            // Arrays to check for duplicate entries in rows and columns
            int[] rowCheck = new int[n + 1];
            int[] colCheck = new int[n + 1];
            
            for (int row = 0; row < n; row++) {
                Arrays.fill(rowCheck, 0);
                Arrays.fill(colCheck, 0);
                
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                for (int col = 0; col < n; col++) {
                    rowCheck[matrix[row][col]]++;
                    colCheck[matrix[col][row]]++;
                }
                
                for (int num = 1; num <= n; num++) {
                    if (rowCheck[num] > 1 && !rowHasDuplicate) {
                        duplicateRows++;
                        rowHasDuplicate = true;
                    }
                    if (colCheck[num] > 1 && !colHasDuplicate) {
                        duplicateCols++;
                        colHasDuplicate = true;
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
        
        sc.close();
    }
}