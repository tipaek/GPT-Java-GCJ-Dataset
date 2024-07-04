import java.util.Scanner;

public class Prob1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int t = sc.nextInt();

            for (int x = 1; x <= t; x++) {
                int n = sc.nextInt();
                int[][] matrix = new int[n][n];
                int trace = 0;

                // Read the matrix and calculate the trace
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = sc.nextInt();
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }

                System.out.print("\nCase #" + x + " : " + trace);
                countRows(matrix, n);
                countCols(matrix, n);
            }
        } catch (Exception e) {
            System.exit(0);
        } finally {
            sc.close();
        }
    }

    public static void countRows(int[][] matrix, int n) {
        int rowCount = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    rowCount++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        System.out.print(" " + rowCount);
    }

    public static void countCols(int[][] matrix, int n) {
        int colCount = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[j][i]]) {
                    colCount++;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }

        System.out.print(" " + colCount);
    }
}