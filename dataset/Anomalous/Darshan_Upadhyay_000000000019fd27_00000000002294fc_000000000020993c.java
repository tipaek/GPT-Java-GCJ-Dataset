import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            // Read matrix and calculate trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }
            
            // Check for row and column repeats
            for (int row = 0; row < n; row++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];
                boolean rowFlag = false, colFlag = false;
                
                for (int col = 0; col < n; col++) {
                    // Check row
                    if (rowCheck[matrix[row][col]]) {
                        rowFlag = true;
                    } else {
                        rowCheck[matrix[row][col]] = true;
                    }
                    
                    // Check column
                    if (colCheck[matrix[col][row]]) {
                        colFlag = true;
                    } else {
                        colCheck[matrix[col][row]] = true;
                    }
                }
                
                if (rowFlag) rowRepeats++;
                if (colFlag) colRepeats++;
            }
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        sc.close();
    }
}