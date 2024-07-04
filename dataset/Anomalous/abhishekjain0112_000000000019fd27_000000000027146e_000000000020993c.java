package CODEJAM;

import java.util.Scanner;

public class Program1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int c = 0; c < t; c++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            int sum = 0, rowcount = 0, columcount = 0;

            // Read matrix and calculate diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                    if (i == j) {
                        sum += mat[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
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

            // Check for duplicate values in columns
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

        sc.close();
    }
}