import java.util.*;
import java.io.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scan.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scan.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[n][n];
            
            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < n) {
                    rowRepeats++;
                }
            }
            
            // Check for column repeats
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < n) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}