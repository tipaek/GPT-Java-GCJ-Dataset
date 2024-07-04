import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt(); // Size of the matrix (n x n)
            int[][] mat = new int[n][n];
            
            // Reading the matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[j][k] = in.nextInt();
                }
            }
            
            // Calculate trace and counts
            trace(mat, i);
        }
    }
    
    public static void trace(int[][] mat, int caseNumber) {
        int n = mat.length;
        int trace = 0;
        int r = mat[0][0];
        int c = mat[0][0];
        int sr = 0, sc = 0;

        // Calculate trace and counts of r and c
        for (int i = 0; i < n; i++) {
            trace += mat[i][i]; // Diagonal elements sum
            
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == r) sr++;
                if (mat[j][i] == c) sc++;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + trace + " " + sr + " " + sc);
    }
}