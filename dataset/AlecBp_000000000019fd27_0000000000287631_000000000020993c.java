 import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int n;
        int[][] matrix;
        int repeatedCols, repeatedRows, trace;
        for (int i = 0; i < T; i++) {
            n = in.nextInt();

            matrix = new int[n][n];
            repeatedCols = 0;
            repeatedRows = 0;
            trace = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }
            boolean rCol, rRow;
            for (int j = 0; j < n; j++) {
                rCol = false;
                rRow = false;
                for (int k = 0; k < n; k++) {

                    for (int l = k + 1; l < n; l++) {
                        if (matrix[j][k] == matrix[j][l]) {
                            rRow = true;
                        }
                    }

                    for (int l = k + 1; l < n; l++) {
                        if (matrix[k][j] == matrix[l][j]) {
                            rCol = true;
                        }
                    }
                }
                if (rCol) {
                    repeatedCols++;
                }
                if (rRow) {
                    repeatedRows++;
                }

            }

            System.out.println("Case #" + i + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}
