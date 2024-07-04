import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowDuplicate = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j]]) {
                        rowDuplicate = true;
                    }
                    rowCheck[matrix[i][j]] = true;
                }

                if (rowDuplicate) {
                    rowCount++;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean colDuplicate = false;

                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        colDuplicate = true;
                    }
                    colCheck[matrix[i][j]] = true;
                }

                if (colDuplicate) {
                    colCount++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}