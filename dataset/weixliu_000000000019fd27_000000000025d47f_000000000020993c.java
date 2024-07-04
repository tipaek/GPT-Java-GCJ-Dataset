package com.codejam;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String ... args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        int num = cin.nextInt();
        for(int i = 0;i < num;i++) {
            int n = cin.nextInt();
            int trace = 0;
            int[][] row = new int[n][n];
            int[][] column = new int[n][n];
            for(int r = 0;r < n;r++) {
                for(int c = 0;c < n;c++) {
                    int rc = cin.nextInt();
                    if(r == c) {
                        trace += rc;
                    }
                    row[r][rc - 1]++;
                    column[c][rc - 1]++;
                }
            }
            int dupRow = 0;
            int dupColumn = 0;
            for(int k = 0;k < n;k++) {
                for(int m = 0;m < n;m++) {
                    if(row[k][m] > 1) {
                        dupRow++;
                        break;
                    }
                }
                for(int m = 0;m < n;m++) {
                    if(column[k][m] > 1) {
                        dupColumn++;
                        break;
                    }
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", i + 1, trace, dupRow, dupColumn));
        }
    }
}
