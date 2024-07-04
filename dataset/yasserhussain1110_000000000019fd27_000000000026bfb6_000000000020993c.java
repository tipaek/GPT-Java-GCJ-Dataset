// package com.yasser.twenty20;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int numberOfTestCases = scanner.nextInt();
        for (int k = 0; k < numberOfTestCases; k++) {
            int size = scanner.nextInt();
            int[][] grid = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
            solve(grid, k);
        }
    }

    private static void solve(int[][] grid, int index) {
        int size = grid.length;
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += grid[i][i];
        }

        int rowDupes = 0;
        for (int i = 0; i < size; i++) {
            int[] rec = new int[100];
            for (int j = 0; j < size; j++) {
                if (rec[grid[i][j]] == 1) {
                    rowDupes++;
                    break;
                } else {
                    rec[grid[i][j]] = 1;
                }
            }
        }

        int colDupes = 0;
        for (int i = 0; i < size; i++) {
            int[] rec = new int[100];
            for (int j = 0; j < size; j++) {
                if (rec[grid[j][i]] == 1) {
                    colDupes++;
                    break;
                } else {
                    rec[grid[j][i]] = 1;
                }
            }
        }

        out.println(String.format("Case #%s: %s %s %s", (index + 1), trace, rowDupes, colDupes));
    }
}
