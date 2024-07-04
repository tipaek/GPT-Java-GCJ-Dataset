// package com.yasser.twenty20;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        scanner.nextInt();
        int i = 0;
        while (scanner.hasNextInt()) {
            solve(++i, scanner.nextInt(), scanner.nextInt());
        }
    }

    public static void solve(int caseNumber, int n, int trace) {
        if (trace % n == 0 && trace <= n * n) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            int left = trace / n;
            nums[0] = left;
            nums[left - 1] = 1;
            out.println(String.format("Case #%s: POSSIBLE", caseNumber));
            printWithRightShift(nums);
        } else if (trace == (n * (n + 1)) / 2) {
            int[][] grid = fill2DGrid(n - 1);
            out.println(String.format("Case #%s: POSSIBLE", caseNumber));
            printGrid(grid);
        } else {
            out.println(String.format("Case #%s: IMPOSSIBLE", caseNumber));
        }

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
