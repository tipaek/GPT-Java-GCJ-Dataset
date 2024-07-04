import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int testCases = kb.nextInt();

        while (testCases > 0) {
            int n = kb.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Input matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = kb.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                Arrays.sort(matrix[i]);
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            // Check for row repeats
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

            // Check for column repeats
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

            System.out.println(trace);
            System.out.println(rowRepeats);
            System.out.println(colRepeats);

            testCases--;
        }

        kb.close();
    }
}