import java.util.Scanner;

public class Prob1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = Integer.parseInt(sc.nextLine().trim());

            for (int x = 1; x <= t; x++) {
                int n = Integer.parseInt(sc.nextLine().trim());
                int[][] matrix = new int[n][n];
                int trace = 0;

                for (int i = 0; i < n; i++) {
                    String[] temp = sc.nextLine().trim().split(" ");
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Integer.parseInt(temp[j]);
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }

                System.out.print("\nCase #" + x + ": " + trace);
                countRows(matrix, n);
                countCols(matrix, n);
            }
        } catch (Exception e) {
            System.exit(0);
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
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[j][i]]) {
                    count++;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }
        System.out.print(" " + count);
    }
}