import java.util.HashSet;
import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            // Check for duplicate values in rows and columns
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();

                for (int j = 0; j < N; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }

                if (rowSet.size() != N) {
                    duplicateRows++;
                }

                if (colSet.size() != N) {
                    duplicateCols++;
                }
            }

            int trace = calculateTrace(N, matrix);
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows, duplicateCols);
        }
    }

    public static int calculateTrace(int N, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
}