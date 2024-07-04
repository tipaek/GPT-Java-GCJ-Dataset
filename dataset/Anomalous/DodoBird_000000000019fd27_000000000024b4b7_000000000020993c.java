import java.util.HashSet;
import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int cases = 1; cases <= T; cases++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int rowsWithDuplicates = 0;
            int colsWithDuplicates = 0;

            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();

                for (int j = 0; j < N; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }

                if (rowSet.size() != N) {
                    rowsWithDuplicates++;
                }
                if (colSet.size() != N) {
                    colsWithDuplicates++;
                }
            }

            int trace = calculateTrace(N, matrix);
            System.out.println("Case #" + cases + ": " + trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);
        }
    }

    private static int calculateTrace(int N, int[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < N; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }
}