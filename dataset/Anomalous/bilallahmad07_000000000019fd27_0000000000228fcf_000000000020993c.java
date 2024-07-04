import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int rowRepeats = 0, colRepeats = 0, trace = 0;

            for (int i = 0; i < n; i++) {
                String[] rowValues = reader.readLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                }

                if (rowHasDuplicate) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;

                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicate = true;
                        break;
                    }
                }

                if (colHasDuplicate) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}