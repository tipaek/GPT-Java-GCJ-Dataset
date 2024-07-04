import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int casei = 1; casei <= t; ++casei) {
            int n = in.nextInt();
            int k_trace = 0;
            int r_numofdupRow = 0;
            int c_numofdupCol = 0;
            int matrix[][] = new int[n][n];
            // read matrix and count for k,r
            for (int i = 0; i < matrix.length; i++) {
                Set<Integer> rowParamSet = new HashSet<Integer>();//[1]
                boolean isThisRowDup = false;
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j)
                        k_trace += matrix[i][j];
                    if (rowParamSet.contains(matrix[i][j])) {
                        isThisRowDup = true;
                    } else {
                        rowParamSet.add(matrix[i][j]);
                    }
                }
                if (isThisRowDup)
                    r_numofdupRow++;
            }

            // read matrix and count for c
            for (int i = 0; i < matrix.length; i++) {
                Set<Integer> colParamSet = new HashSet<Integer>();//[1]
                boolean isThisColDup = false;
                for (int j = 0; j < matrix[i].length; j++) {
                    int v = matrix[j][i];
                    if (colParamSet.contains(v)) {
                        isThisColDup = true;
                    } else {
                        colParamSet.add(v);
                    }
                }
                if (isThisColDup)
                    c_numofdupCol++;
            }

//            for (int i2 = 0; i2 < n; i2++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(matrix[i2][j]);
//                }
//                System.out.println("");
//            }

            System.out.println("Case #" + casei + ": " + k_trace + " " + r_numofdupRow + " " + c_numofdupCol);
        }
    }
}