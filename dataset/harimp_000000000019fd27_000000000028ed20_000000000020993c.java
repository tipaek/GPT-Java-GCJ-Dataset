import java.util.*;
import java.io.*;

public class Solution {
    public static int trace(int n, int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    
    public static int repeatedRows(int n, int[][] matrix) {
        int rows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(matrix[i][j]);
            }
            if (set.size() < n) {
                rows++;
            }
        }
        return rows;
    }
    
    public static int repeatedCols(int n, int[][] matrix) {
        int cols = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(matrix[j][i]);
            }
            if (set.size() < n) {
                cols++;
            }
        }
        return cols;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = in.nextInt();
            in.nextLine();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line = in.nextLine();
                String[] numStrs = line.split(" ");
                for (int j = 0; j < numStrs.length; j++) {
                    matrix[i][j] = Integer.valueOf(numStrs[j]).intValue();
                }
            }
            
            // Find trace
            int matrixTrace = trace(n, matrix);
            
            // Find repeated rows
            int rows = repeatedRows(n, matrix);
            
            // Find repeated cols
            int cols = repeatedCols(n, matrix);
            
            System.out.println(
                String.format("Case #%d: %d %d %d", x, matrixTrace, rows, cols)
                );
        }
    }
}
