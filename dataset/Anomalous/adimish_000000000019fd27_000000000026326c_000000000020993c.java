import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Check for row duplicates
            for (int row = 0; row < n; row++) {
                boolean[] seen = new boolean[n + 1];
                for (int col = 0; col < n; col++) {
                    if (seen[matrix[row][col]]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Check for column duplicates
            for (int col = 0; col < n; col++) {
                boolean[] seen = new boolean[n + 1];
                for (int row = 0; row < n; row++) {
                    if (seen[matrix[row][col]]) {
                        colDuplicates++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }

        sc.close();
    }
}