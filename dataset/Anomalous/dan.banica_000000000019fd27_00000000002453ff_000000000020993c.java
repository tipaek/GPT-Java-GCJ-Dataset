import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private void run() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int nTests = sc.nextInt();

        for (int test = 1; test <= nTests; test++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int nInvalidRows = countInvalidRows(matrix, n);
            int nInvalidCols = countInvalidCols(matrix, n);

            System.out.println(String.format("Case #%d: %d %d %d", test, trace, nInvalidRows, nInvalidCols));
        }
    }

    private int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countInvalidRows(int[][] matrix, int n) {
        int nInvalidRows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    nInvalidRows++;
                    break;
                }
            }
        }
        return nInvalidRows;
    }

    private int countInvalidCols(int[][] matrix, int n) {
        int nInvalidCols = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(matrix[i][j])) {
                    nInvalidCols++;
                    break;
                }
            }
        }
        return nInvalidCols;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.run();
    }
}