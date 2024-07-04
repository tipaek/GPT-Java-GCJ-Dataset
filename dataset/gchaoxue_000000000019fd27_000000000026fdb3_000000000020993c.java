package org.gchaoxue.gcj;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class QualificationRoundCodeJam2020_A {

    public static void main(String[] args) {


        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int t, n;
        t = in.nextInt();
        for (int ti=1; ti<=t; ti++) {
            n = in.nextInt();
            int[][] matrix = new int[n][n];
            int[][] rowValue = new int[n][n+1];
            int[][] colValue = new int[n][n+1];
            int[] repRow = new int[n];
            int[] repCol = new int[n];

            int x = 0, r = 0, c = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    int val = in.nextInt();
                    matrix[i][j] = val;
                    rowValue[i][val]++;
                    colValue[j][val]++;
                    if (i == j) x += val;
                    if (rowValue[i][val] == 2)
                        repRow[i] = 1;
                    if (colValue[j][val] == 2)
                        repCol[j] = 1;
                }
            }

            for (int i=0; i<n; i++) {
                r += repRow[i];
                c += repCol[i];
            }

            System.out.println("Case #" + ti + ": " + x + " " + r + " " + c);
        }
    }
}
