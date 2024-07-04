import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int c = 1; c <= t; c++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += mat[i][j];
                    }
                }
            }

            // Checking rows for duplicates
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[mat[i][j]]) {
                        rowCount++;
                        break;
                    }
                    seen[mat[i][j]] = true;
                }
            }

            // Checking columns for duplicates
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[mat[j][i]]) {
                        colCount++;
                        break;
                    }
                    seen[mat[j][i]] = true;
                }
            }

            System.out.println("Case #" + c + ": " + trace + " " + rowCount + " " + colCount);
        }

        sc.close();
    }
}