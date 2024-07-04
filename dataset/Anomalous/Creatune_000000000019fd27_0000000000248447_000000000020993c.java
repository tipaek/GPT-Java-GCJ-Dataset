import java.util.*;
import java.io.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        
        for (int x = 1; x <= T; x++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            // Check for row repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }
            
            // Check for column repeats
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + x + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}