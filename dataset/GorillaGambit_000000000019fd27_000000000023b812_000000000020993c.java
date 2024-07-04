import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
          
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt();
        
        for (int i=1; i <= t; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int row_repeats = 0;
            int col_repeats = 0;
            Map<Integer, Boolean> repeatedCol = new HashMap<>();
    
            for (int j=0; j < n; j++) {
                boolean repeated_row = false;
                for (int k=0; k < n; k++) {
                    repeatedCol.putIfAbsent(k, false);
                    int next_val = in.nextInt();
                    if (!repeated_row && alr_in_row(next_val, matrix[j])) {
                        row_repeats += 1;
                        repeated_row = true;
                    }
                    if (!repeatedCol.get(k) && alr_in_column(next_val, matrix, k)) {
                        col_repeats += 1;
                        repeatedCol.replace(k, true);
                    }
                    matrix[j][k] = next_val;
                }
                trace += matrix[j][j];
            }
        
            System.out.println("Case #" + i + ": " + trace + " "
                + row_repeats + " " + col_repeats);
        }
    }
    
    public static boolean alr_in_column(int elem, int[][] matrix, int col) {
        for (int[] row : matrix) {
            if (elem == row[col])
                return true;
        }
        return false;
    }
    
    public static boolean alr_in_row(int elem, int[] row) {
        for (int i : row) {
            if (elem == i) {
                return true;
            }
        }
        return false;
    }
}
        