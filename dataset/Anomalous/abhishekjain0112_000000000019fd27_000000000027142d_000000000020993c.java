package CODEJAM;

import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int c = 0; c < t; c++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            int sum = 0, rowcount = 0, columcount = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                    if (i == j) {
                        sum += mat[i][j];
                    }
                }
            }

            // Checking for duplicate values in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[mat[i][j]]) {
                        rowcount++;
                        break;
                    }
                    seen[mat[i][j]] = true;
                }
            }

            // Checking for duplicate values in columns
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[mat[j][i]]) {
                        columcount++;
                        break;
                    }
                    seen[mat[j][i]] = true;
                }
            }

            System.out.println("Case #" + (c + 1) + ": " + sum + " " + rowcount + " " + columcount);
        }
    }
}