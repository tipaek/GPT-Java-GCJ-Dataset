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
            int rowDuplicates = countRowDuplicates(N, matrix);
            int colDuplicates = countColumnDuplicates(N, matrix);

            System.out.println("Case #" + cases + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int calculateTrace(int N, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int N, int[][] matrix) {
        int duplicateRows = 0;
        for (int i = 0; i < N; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != N) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countColumnDuplicates(int N, int[][] matrix) {
        int duplicateCols = 0;
        for (int i = 0; i < N; i++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() != N) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }
}