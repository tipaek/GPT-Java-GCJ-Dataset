import java.util.Scanner;

public class CodeJam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] traceSums = new int[N];
        int[] rowRepeats = new int[N];
        int[] colRepeats = new int[N];

        for (int l = 0; l < N; l++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < n; i++) {
                traceSums[l] += matrix[i][i];
            }

            // Check for row repeats
            rowRepeats[l] = countRowRepeats(matrix, n);

            // Check for column repeats
            colRepeats[l] = countColumnRepeats(matrix, n);
        }

        // Print results
        for (int a = 0; a < N; a++) {
            System.out.println("Case #" + (a + 1) + ": " + traceSums[a] + " " + rowRepeats[a] + " " + colRepeats[a]);
        }
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int repeatCount = 0;
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    repeatCount++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return repeatCount;
    }

    private static int countColumnRepeats(int[][] matrix, int size) {
        int repeatCount = 0;
        for (int j = 0; j < size; j++) {
            boolean[] seen = new boolean[size + 1];
            for (int i = 0; i < size; i++) {
                if (seen[matrix[i][j]]) {
                    repeatCount++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return repeatCount;
    }
}