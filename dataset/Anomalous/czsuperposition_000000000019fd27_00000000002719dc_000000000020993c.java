import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[][] results = new int[T][3];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            for (int row = 0; row < N; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < N; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            for (int col = 0; col < N; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < N; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            results[i][0] = trace;
            results[i][1] = duplicateRows;
            results[i][2] = duplicateCols;
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i][0] + " " + results[i][1] + " " + results[i][2]);
        }
    }
}