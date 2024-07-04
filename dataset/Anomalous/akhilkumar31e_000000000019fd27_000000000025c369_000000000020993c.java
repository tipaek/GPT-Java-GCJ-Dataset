import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int rowCount = 0, trace = 0;

            for (int i = 0; i < n; i++) {
                String[] rowValues = reader.readLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                    rowSet.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }

                if (rowSet.size() < n) {
                    rowCount++;
                }
            }

            int colCount = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowCount, colCount);
        }
    }
}