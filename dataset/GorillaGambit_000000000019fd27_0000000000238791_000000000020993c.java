import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.io.*;

class Solution {
    public static void main(String[] args) {
          
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt();
        
        for (int i=1; i <= t; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int row_repeats = 0;
            int col_repeats = 0;
    
            for (int j=0; j < n; j++) {
                for (int k=0; k < n; k++) {
                    int next_val = in.nextInt();
                    if (Arrays.asList(Arrays.asList(matrix).get(j)).contains(next_val)) {
                        row_repeats += 1;
                    }
                    if (alr_in_column(next_val, matrix, k)) {
                        col_repeats += 1;
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
}
        