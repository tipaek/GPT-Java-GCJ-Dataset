import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        
        for (int test = 1; test <= testCount; test++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int repeatRow = 0;
            int repeatCol = 0;
            
            // Read matrix and calculate trace
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = in.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }
            
            // Check for repeated elements in rows
            for (int row = 0; row < N; row++) {
                Set<Integer> set = new HashSet<>();
                for (int col = 0; col < N; col++) {
                    if (!set.add(matrix[row][col])) {
                        repeatRow++;
                        break;
                    }
                }
            }
            
            // Check for repeated elements in columns
            for (int col = 0; col < N; col++) {
                Set<Integer> set = new HashSet<>();
                for (int row = 0; row < N; row++) {
                    if (!set.add(matrix[row][col])) {
                        repeatCol++;
                        break;
                    }
                }
            }
            
            // Print the result for the current test case
            System.out.println("Case #" + test + ": " + trace + " " + repeatRow + " " + repeatCol);
        }
        
        in.close();
    }
}