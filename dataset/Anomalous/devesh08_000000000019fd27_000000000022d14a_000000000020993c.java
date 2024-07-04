import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    rowSet.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (rowSet.size() < n) {
                    rowRepeats++;
                }
            }
            
            // Check for column repeats
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < n) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + tt + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        in.close();
    }
}