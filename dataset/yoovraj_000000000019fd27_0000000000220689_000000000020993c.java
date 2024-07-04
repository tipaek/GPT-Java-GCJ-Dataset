/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author yoovraj.shinde
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            // matrix size
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            solve(matrix, N, i);
        }        
    }
    public static void solve(final int[][] matrix, final int N, int testCaseNumber) {
//        int N = 4;
//        int[][] matrix = new int[N][N];
//        matrix[0] = new int[] {1, 2, 3, 4};
//        matrix[1] = new int[] {2, 1, 3, 4};
//        matrix[2] = new int[] {3, 4, 1, 2};
//        matrix[3] = new int[] {4, 3, 2, 1};
        int trace = calculateTrace(matrix, N);
        int rowCount = 0, colCount = 0;
        
        for (int i = 0; i < N; i++) {
            if (isDuplicate(matrix[i], N)) {
                rowCount++;
            }
            int[] col = new int[N];
            for (int j = 0; j < N; j++ ) {
                col[j] = matrix[j][i];
            }
            if (isDuplicate(col, N)) {
                colCount++;
            }
        }
        System.out.println("Case #" + testCaseNumber + ": " + (trace) + " " + (rowCount) + " " + (colCount));        
    }
    public static int calculateTrace(final int[][] matrix, final int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    public static boolean isDuplicate(final int[] array1D, final int N)  {
        boolean[] bitArray = new boolean[N+1];
        Arrays.fill(bitArray, false);
        for (int n:array1D) {
            if (!bitArray[n]) {
                bitArray[n] = true;
            } else {
                return true;
            }
        }
        return false;
    }
}
