import java.util.Scanner;

public class Prob1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            int trace = 0;
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.print("\nCase #" + x + ": " + trace);
            countRows(matrix, n);
            countCols(matrix, n);
        }
    }

    public static void countRows(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    count++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        System.out.print(" " + count);
    }

    public static void countCols(int[][] matrix, int n) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                if (seen[matrix[i][j]]) {
                    count++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        System.out.print(" " + count);
    }
}