import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int trace = 0;
            int [][] matrix = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++){
                    matrix[r][c] = in.nextInt();
                    if (r == c) {
                        trace += matrix[r][c];
                    }
                }
            }
            
            int dupR = 0;
            for (int r = 0; r < n; r++) {
                boolean [] flag = new boolean[n + 1];
                for (int c = 0; c < n; c++){
                    int value = matrix[r][c];
                    if (flag[value]) {
                        dupR++;
                        break;
                    } else {
                        flag[value] = true;
                    }
                }
            }
            
            int dupC = 0;
            for (int c = 0; c < n; c++) {
                boolean [] flag = new boolean[n + 1];
                for (int r = 0; r < n; r++){
                    int value = matrix[r][c];
                    if (flag[value]) {
                        dupC++;
                        break;
                    } else {
                        flag[value] = true;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + (trace) + " " + (dupR) + " " + (dupC));
        }
    }
}