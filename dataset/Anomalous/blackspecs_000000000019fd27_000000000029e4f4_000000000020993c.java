import java.util.Scanner;

public class ICPC1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0, rowRepeats = 0, colRepeats = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (j == k) {
                        sum += matrix[j][k];
                    }
                }
            }

            // Checking for row repetitions
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[101];
                for (int k = 0; k < n; k++) {
                    if (seen[matrix[j][k]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[j][k]] = true;
                }
            }

            // Checking for column repetitions
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[101];
                for (int k = 0; k < n; k++) {
                    if (seen[matrix[k][j]]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[k][j]] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i, sum, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}