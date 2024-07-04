package com.crazystudio.vestigium;

import java.util.Scanner;

public class Solution {
    private static String output1 = "Case #%d: %d %d %d";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int[][] m= new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                m[i][j] = scanner.nextInt();
            }
        }
        int k = getDiagonal(m, n);
        int r = 0;
        for (int i = 0; i < n; ++i) {
            boolean[] used = new boolean[n+1];
            for (int j = 0; j < n; ++j) {
                if (used[m[i][j]]) {
                    ++r;
                    break;
                }
                used[m[i][j]] =true;
            }
        }

        int c = 0;
        for (int i = 0; i < n; ++i) {
            boolean[] used = new boolean[n+1];
            for (int j = 0; j < n; ++j) {
                if (used[m[j][i]]) {
                    ++c;
                    break;
                }
                used[m[j][i]] =true;
            }
        }
        System.out.println(String.format(output1, caseNum, k, r, c));
    }

    public int getDiagonal(int[][] m, int n) {
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += m[i][i];
        }
        return ans;
    }

    public void print(int[][] m) {
        for (int[] line: m) {
            for (int e: line) {
                System.out.print(e + ", ");
            }
            System.out.println();
        }
    }
}
