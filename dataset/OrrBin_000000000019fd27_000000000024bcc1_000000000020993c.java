import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            int badRows = 0;
            int badCols = 0;

            int trace = 0;
            //Fill up the matrix, and calc the trace
            for(int row = 0; row < n; row++) {
                boolean[] rowNumbers = new boolean[n];
                for(int col = 0; col < n; col++) {
                    int val = in.nextInt();
                    matrix[row][col] = val;

                    rowNumbers[val-1] = true;

                    if(row == col)
                        trace += val;
                }

                for(int cell = 0; cell < n; cell++) {
                    if(!rowNumbers[cell]) {
                        badRows++;
                        break;
                    }
                }

            }

            for(int col = 0; col < n; col++) {
                boolean[] colNumbers = new boolean[n];
                for(int row = 0; row < n; row++) {
                    int val = matrix[row][col] ;

                    colNumbers[val-1] = true;
                }

                for(int cell = 0; cell < n; cell++) {
                    if(!colNumbers[cell]) {
                        badCols++;
                        break;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", i, trace, badRows, badCols));
        }
    }
}
