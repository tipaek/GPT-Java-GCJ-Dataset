import java.util.Scanner;

public class Trace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
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

            int rowRepeats = 0;
            int colRepeats = 0;

            // Check for repeated elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Check for repeated elements in columns
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        sc.close();
    }
}