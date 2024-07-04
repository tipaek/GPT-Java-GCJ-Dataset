package codejam;

import java.util.*;
import java.io.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        
        for (int x = 1; x <= t; x++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            
            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Checking for row and column repeats
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
                
                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][i];
                }
                
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", x, trace, rowRepeats, colRepeats);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}