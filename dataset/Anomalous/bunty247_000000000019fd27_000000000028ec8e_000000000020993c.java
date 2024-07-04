package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LatinSquare {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= numCases; testCase++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int trace = 0;
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                matrix[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();
            }

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int rowCount = 0, colCount = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowDuplicate = false, colDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colDuplicate = true;
                    }
                }

                if (rowDuplicate) {
                    rowCount++;
                }
                if (colDuplicate) {
                    colCount++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}