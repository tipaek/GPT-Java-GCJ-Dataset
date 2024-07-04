import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<Result> results = new ArrayList<>();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int repeatRows = 0;
            int repeatCols = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                    rowSet.add(value);
                }
                if (rowSet.size() < n) {
                    repeatRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < n) {
                    repeatCols++;
                }
            }

            results.add(new Result(trace, repeatRows, repeatCols));
        }

        for (int i = 0; i < results.size(); i++) {
            Result result = results.get(i);
            System.out.printf("Case #%d: %d %d %d%n", i + 1, result.trace, result.repeatRows, result.repeatCols);
        }
    }

    private static class Result {
        int trace;
        int repeatRows;
        int repeatCols;

        Result(int trace, int repeatRows, int repeatCols) {
            this.trace = trace;
            this.repeatRows = repeatRows;
            this.repeatCols = repeatCols;
        }
    }
}