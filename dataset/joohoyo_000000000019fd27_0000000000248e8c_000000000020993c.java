package joohoyo.y2020.codejam;

// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c?show=progress
// 18:48 ~ (min)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Vestigium v = new Vestigium();
        v.start();
    }

    private void start() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            int[] answer = solution(n, matrix);
            String output = "Case #" + i + ": " + answer[0] + " " + answer[1] + " " + answer[2];
            System.out.println(output);
        }
    }

    int[] solution(int n, int[][] matrix) {
        int k = 0, r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            int[] columns = new int[n + 1];
            int[] rows = new int[n + 1];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    k += matrix[i][j];
                }
                columns[matrix[i][j]]++;
                rows[matrix[j][i]]++;
            }

            for (int j = 1; j < n + 1; j++) {
                if (columns[j] > 1) {
                    c++;
                    break;
                }
            }
            for (int j = 1; j < n + 1; j++) {
                if (rows[j] > 1) {
                    r++;
                    break;
                }
            }
        }

        int[] answer = new int[]{k, c, r};
        return answer;
    }
}
