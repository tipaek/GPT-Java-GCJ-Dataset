// package joohoyo.y2020.codejam;

// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27
// 2:00 ~  (min)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.start();
    }
// public class Indicium {
    Map<String, int[][]> answer;
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
            Map<String, int[][]> map = solution(n, k);
            if (map.containsKey("answer")) {
                System.out.println("Case #" + i + ": POSSIBLE");
                int[][] matrix = map.get("answer");
                for (int m1 = 0; m1 < n; m1++) {
                    for (int m2 = 0; m2 < n; m2++) {
                        System.out.print(matrix[m1][m2] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    Map<String, int[][]> solution(int n, int k) {
        this.answer = new HashMap<>();
        this.complete = false;

        if (k % n != 0 && (n * (n + 1)) / 2 != k) {
            return answer;
        }

        int[][] matrix = getMatrix(n, k);
        backtracking(matrix, n);

        return answer;
    }

    private void backtracking(int[][] matrix, int n) {
        if (this.complete) {
            return;
        }

        if (isComplete(matrix, n)) {
            this.complete = true;
            answer.put("answer", matrix);
            return;
        }

        int[] xy = getXY(matrix, n);
        for (int i = 1; i <= n; i++) {
            if (this.complete) {
                return;
            }

            matrix[xy[0]][xy[1]] = i;
            boolean c = check(matrix, n);
            if (c) {
                backtracking(matrix, n);
            } else {
                matrix[xy[0]][xy[1]] = 0;
            }
        }
    }

    private boolean isComplete(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] getMatrix(int n, int k) {
        int[][] matrix = new int[n][n];
        if (k % n == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][i] = k / n;
            }
        } else {
            for (int i = 0; i < n; i++) {
                matrix[i][i] = i + 1;
            }
        }
        return matrix;
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

    private boolean check(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            int[] columns = new int[n + 1];
            int[] rows = new int[n + 1];

            for (int j = 0; j < n; j++) {
                columns[matrix[i][j]]++;
                rows[matrix[j][i]]++;
            }

            for (int j = 1; j < n + 1; j++) {
                if (columns[j] > 1) {
                    return false;
                }
            }
            for (int j = 1; j < n + 1; j++) {
                if (rows[j] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
