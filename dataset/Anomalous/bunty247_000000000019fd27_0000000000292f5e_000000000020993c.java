package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= numCases; testCase++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = bufferedReader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowDuplicate = false;
                boolean colDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colDuplicate = true;
                    }
                }

                if (rowDuplicate) {
                    duplicateRows++;
                }
                if (colDuplicate) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}