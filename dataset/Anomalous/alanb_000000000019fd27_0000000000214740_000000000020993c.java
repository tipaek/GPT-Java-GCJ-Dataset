import java.util.HashSet;
import java.util.Scanner;

public class Vest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int trace = 0;
            int rows = 0;
            int cols = 0;
            int[][] matrix = new int[n][n];
            HashSet<Integer> set = new HashSet<>();

            // Reading the matrix and calculating the trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            // Checking for duplicate values in rows
            for (int j = 0; j < n; j++) {
                set.clear();
                for (int k = 0; k < n; k++) {
                    set.add(matrix[j][k]);
                }
                if (set.size() < n) {
                    rows++;
                }
            }

            // Checking for duplicate values in columns
            for (int j = 0; j < n; j++) {
                set.clear();
                for (int k = 0; k < n; k++) {
                    set.add(matrix[k][j]);
                }
                if (set.size() < n) {
                    cols++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rows + " " + cols);
        }
    }
}