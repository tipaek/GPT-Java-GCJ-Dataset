// package joohoyo.y2020.codejam;

// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27
// 2:00 ~  (min)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.start();
    }
// public class Indicium {
    int[][] answer;
    boolean complete;

    // public static void main(String[] args) {
    //     Indicium s = new Indicium();
    //     s.start();
    // }

    private void start() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            solution(n, k);
            if (this.answer != null) {
                System.out.println("Case #" + i + ": POSSIBLE");
                for (int m1 = 0; m1 < n; m1++) {
                    for (int m2 = 0; m2 < n; m2++) {
                        System.out.print(this.answer[m1][m2] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    void solution(int n, int k) {
        this.answer = null;
        this.complete = false;

        int[][] matrix = new int[n][n];
        backtracking(matrix, n, k, 0);
    }

    private void backtracking(int[][] matrix, int n, int k, int count) {
        if (this.complete) {
            return;
        }

        if (count == n * n && isComplete(matrix, n, k)) {
            this.complete = true;
            this.answer = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    this.answer[i][j] = matrix[i][j];
                }
            }
            return;
        }

        int[] xy = getXY(matrix, n);
        if (xy[0] == -1) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (this.complete) {
                return;
            }
            matrix[xy[0]][xy[1]] = i;
            if (check(matrix, n, xy)) {
                backtracking(matrix, n, k, count + 1);
            }
            matrix[xy[0]][xy[1]] = 0;

        }
    }

    private boolean check(int[][] matrix, int n, int[] xy) {
        int[] columns = new int[n + 1];
        int[] rows = new int[n + 1];
        for (int j = 0; j < n; j++) {
            columns[matrix[xy[0]][j]]++;
            rows[matrix[j][xy[1]]]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (columns[i] > 1) {
                return false;
            }
            if (rows[i] > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isComplete(int[][] matrix, int n, int k) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }
        return trace == k;
    }

    private int[] getXY(int[][] matrix, int n) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (matrix[x][y] == 0) {
                    return new int[]{x, y};
                }
            }
        }
        return new int[]{-1, -1};
    }

    int[][] getAnswer() {
        return this.answer;
    }
}
