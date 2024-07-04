import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[n][n];
            int diagonalSum = 0, repeatedRows = 0, repeatedCols = 0;

            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().trim().split("\\s+");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < n) repeatedRows++;
                diagonalSum += matrix[i][i];
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    colSet.add(matrix[j][i]);
                }
                if (colSet.size() < n) repeatedCols++;
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
    }
}