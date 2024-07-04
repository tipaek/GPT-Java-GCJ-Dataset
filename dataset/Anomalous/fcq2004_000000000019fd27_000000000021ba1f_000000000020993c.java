import java.util.*;

public class Solution {
    private static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            String result = solve(matrix);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String solve(int[][] matrix) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < N; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (!rowSet.add(matrix[i][j])) {
                    rowHasDuplicate = true;
                }

                if (!colSet.add(matrix[j][i])) {
                    colHasDuplicate = true;
                }
            }

            if (rowHasDuplicate) {
                rowDuplicates++;
            }

            if (colHasDuplicate) {
                colDuplicates++;
            }
        }

        return trace + " " + rowDuplicates + " " + colDuplicates;
    }
}