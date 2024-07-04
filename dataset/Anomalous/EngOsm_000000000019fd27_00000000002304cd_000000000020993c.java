import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            int N = input.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowCount = 0, colCount = 0;

            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            // Calculate the trace
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Count rows with repeated elements
            for (int i = 0; i < N; i++) {
                boolean[] seen = new boolean[N + 1];
                for (int j = 0; j < N; j++) {
                    if (seen[matrix[i][j]]) {
                        rowCount++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Count columns with repeated elements
            for (int j = 0; j < N; j++) {
                boolean[] seen = new boolean[N + 1];
                for (int i = 0; i < N; i++) {
                    if (seen[matrix[i][j]]) {
                        colCount++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Print the result for this case
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowCount, colCount);
        }
    }
}