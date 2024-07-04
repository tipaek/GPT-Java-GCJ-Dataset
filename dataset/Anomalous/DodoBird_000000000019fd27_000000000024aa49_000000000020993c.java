package CodeJam;

import javafx.util.Pair;
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

            int trace = calculateTrace(N, matrix);
            Pair<Integer, Integer> latinSquareCheck = checkLatinSquare(N, matrix);

            System.out.printf("Case #%d: %d %d %d%n", cases, trace, latinSquareCheck.getKey(), latinSquareCheck.getValue());
        }
    }

    public static int calculateTrace(int N, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static Pair<Integer, Integer> checkLatinSquare(int N, int[][] matrix) {
        int rowViolations = 0;
        int colViolations = 0;

        for (int i = 0; i < N; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();

            for (int j = 0; j < N; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }

            if (rowSet.size() != N) {
                rowViolations++;
            }
            if (colSet.size() != N) {
                colViolations++;
            }
        }

        return new Pair<>(rowViolations, colViolations);
    }
}