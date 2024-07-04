import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            
            int[][] matrix = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int f = in.nextInt();
                    matrix[r][c] = f;
                }
            }
            int incorrectRows = getIncorrectRows(matrix);
            int incorrectColms = getIncorrectColms(matrix);
            int trace = getTrace(matrix);
            System.out.printf("Case #%d: %d %d %d\n", i, trace, incorrectRows, incorrectColms);
        }
    }
    
    static int getIncorrectRows(int[][] matrix) {
        int incorrectRows = 0;
        for (int r = 0; r < matrix.length; r++) {
            boolean[] scene = new boolean[matrix.length];
            for (int c = 0; c < matrix.length; c++) {
                int num = matrix[r][c];
                if (num <= scene.length && !scene[num - 1]) {
                    scene[num - 1] = true;
                } else {
                    incorrectRows++;
                    break;
                }

            }
        }
        return incorrectRows;
    }
    
    static int getIncorrectColms(int[][] matrix) {
        int incorrectColms = 0;
        for (int c = 0; c < matrix.length; c++) {
            boolean[] scene = new boolean[matrix.length];
            for (int r = 0; r < matrix.length; r++) {
                int num = matrix[r][c];
                if (num <= scene.length && !scene[num - 1]) {
                    scene[num - 1] = true;
                } else {
                    incorrectColms++;
                    break;
                }

            }
        }
        return incorrectColms;
    }
    
    static int getTrace(int[][] matrix) {
        int trace = 0;
        for (int c = 0; c < matrix.length; c++) {
            trace += matrix[c][c]; 
        }
        return trace;
    } 
}