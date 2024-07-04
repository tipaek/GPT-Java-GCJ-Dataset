package Main;

import java.util.*;
import java.io.*;

public class Solution {

    public static int add_trace(int[][] mtx, int n) {

        int sum = 0;
        for (int i  = 0; i < n; i++) {
            sum += mtx[i][i];
        }
        return sum;
    }

    public static int unique_cols(int[][] mtx, int n) {
        int repCol = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> col = new HashSet<>();
            for (int j = 0; j < n; j++) {
                col.add(mtx[j][i]);
            }
            int size = col.size();
            if (size < n) {
                repCol++;
            }
        }

        return repCol;
    }

    public static int unique_rows(int[][] mtx, int n) {
        int repRow = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> row = new HashSet<>();
            for (int j = 0; j < n; j++) {
                row.add(mtx[i][j]);
            }
            int size = row.size();
            if (size < n) {
                repRow++;
            }
        }
        return repRow;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); //nxn matrix
            int[][] mtx = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mtx[j][k] = in.nextInt();
                }
            }
            int row = unique_rows(mtx,n);
            int col = unique_cols(mtx,n);

            int trace = add_trace(mtx, n);
            System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
        }
    }
}