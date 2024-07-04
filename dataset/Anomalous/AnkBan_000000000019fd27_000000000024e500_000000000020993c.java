import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0, rowCount = 0, colCount = 0;

            // Calculate trace
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Calculate row and column duplicates
            for (int i = 0; i < N; i++) {
                boolean[] rowCheck = new boolean[N + 1];
                boolean[] colCheck = new boolean[N + 1];

                for (int j = 0; j < N; j++) {
                    // Check row duplicates
                    if (rowCheck[matrix[i][j]]) {
                        rowCount++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;

                    // Check column duplicates
                    if (colCheck[matrix[j][i]]) {
                        colCount++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }

        sc.close();
    }
}