// package com.yasser.twenty20.indicium;

import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.in;
import static java.lang.System.out;

public class Indicium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(i + 1, scanner.nextInt(), scanner.nextInt());
        }
    }

    public static void solve(int caseNumber, int n, int trace) {
        if (n == 2 && trace == 3) {
            out.println(String.format("Case #%s: IMPOSSIBLE", caseNumber));
//            err.println(String.format("%s, %s, Case #%s: IMPOSSIBLE", n, trace, caseNumber));
            return;
        }
        if (trace % n == 0 && trace <= n * n) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            int left = trace / n;
            nums[0] = left;
            nums[left - 1] = 1;
            out.println(String.format("Case #%s: POSSIBLE", caseNumber));
//            err.println(String.format("%s, %s, Case #%s: POSSIBLE", n, trace, caseNumber));
            printWithRightShift(nums);
        } else if (trace == (n * (n + 1)) / 2) {
            int[][] grid = fill2DGrid(n - 1);
//            assertGrid(grid, n, trace);
            out.println(String.format("Case #%s: POSSIBLE", caseNumber));
//            err.println(String.format("%s, %s, Case #%s: POSSIBLE", n, trace, caseNumber));
            printGrid(grid);
        } else {
            out.println(String.format("Case #%s: IMPOSSIBLE", caseNumber));
//            err.println(String.format("%s, %s, Case #%s: IMPOSSIBLE", n, trace, caseNumber));
        }

    }

    private static void assertGrid(int[][] grid, int n, int trace) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            sum += grid[i][i];

        }
        if (sum != trace) {
            throw new AssertionError(String.format("wrong for %s %s!!", n, trace));
        }
    }

    private static int getTrace(int n) {
        return (n * (n + 1)) / 2;
    }

    private static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                out.print(grid[i][j]);
                out.print(" ");
            }
            out.println();
        }
    }

    private static int[][] fill2DGrid(int n) {
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            grid[0][i] = i + 1;
        }
        int v = (n + 1) / 2;
        grid[0][v - 1] = grid[0][n - 1];
        grid[0][n - 1] = v;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = (grid[i - 1][(j + 1) % n]);
            }
        }

        int c = n - 1;
        for (int i = 0; i < n; i++) {
            grid[i][n] = grid[i][c];
            grid[i][c] = n + 1;
            c = (c + 1) % n;
        }

        for (int j = 0; j <= n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += grid[i][j];
            }
            int r = ((n + 1) * (n + 2) / 2) - sum;
            grid[n][j] = r;
        }
        return grid;
    }

    private static void printWithRightShift(int[] nums) {
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                out.print(nums[(startIndex + j) % nums.length]);
                out.print(" ");
            }
            startIndex--;
            if (startIndex < 0) startIndex += nums.length;
            out.println();
        }
    }
}
