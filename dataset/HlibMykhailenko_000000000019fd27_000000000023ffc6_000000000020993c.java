package com.gleb;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        int[][][] ALL = new int[cases][][];
        for (int cs = 0; cs < cases; ++cs) {
            int N = in.nextInt();
            ALL[cs] = new int[N][N];
            for (int row = 0; row < N; ++row) {
                ALL[cs][row] = new int [N];
                for (int col = 0; col < N; ++col) {
                    ALL[cs][row][col] = in.nextInt();
                }
            }
        }
        int[][] ans = new int[cases][];
        for (int cs = 0; cs < ALL.length; ++cs) {
            int trace = 0;
            for (int i = 0; i < ALL[cs].length; ++i) {
                trace += ALL[cs][i][i];
            }
            ans[cs][0] = trace;

            int r = 0;
            for (int row = 0; row < ALL[cs].length; ++row) {
                Set<Integer> rowValues = new HashSet<>();
                for (int col = 0; col < ALL[cs].length; ++col) {
                    int value = ALL[cs][row][col];
                    if (!rowValues.contains(value)) {
                        rowValues.add(value);
                    } else {
                        break;
                    }
                }
                if (rowValues.size() < ALL[cs].length) {
                    r += 1;
                }
            }
            ans[cs][1] = r;

            int c = 0;
            for (int col = 0; col < ALL[cs].length; ++col) {
                Set<Integer> colValues = new HashSet<>();
                for (int row = 0; row < ALL[cs].length; ++row) {
                    int value = ALL[cs][row][col];
                    if (!colValues.contains(value)) {
                        colValues.add(value);
                    } else {
                        break;
                    }
                }
                if (colValues.size() < ALL[cs].length) {
                    c += 1;
                }
            }
            ans[cs][2] = c;

        }

        for (int i = 0; i < ans.length; ++i) {
            System.out.println("Case #" + (i + 1) + ": " + ans[i][0] + " " + ans[i][1] + " " + ans[i][2]);
        }
    }
}