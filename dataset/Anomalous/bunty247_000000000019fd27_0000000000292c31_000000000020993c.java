package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class LatinSquare {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
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
            Set<Integer> duplicateRows = new HashSet<>();
            Set<Integer> duplicateCols = new HashSet<>();

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j]) && !rowHasDuplicate) {
                        rowCount++;
                        rowHasDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i]) && !colHasDuplicate) {
                        colCount++;
                        colHasDuplicate = true;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}