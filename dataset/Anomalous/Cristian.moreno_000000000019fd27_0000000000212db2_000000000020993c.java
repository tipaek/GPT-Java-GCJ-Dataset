import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(line[j]);
                    matrix[i][j] = value;

                    if (i == j) {
                        trace += value;
                    }

                    if (rowCheck[value]) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[value] = true;
                    }
                }

                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean colHasDuplicate = false;

                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];

                    if (colCheck[value]) {
                        colHasDuplicate = true;
                    } else {
                        colCheck[value] = true;
                    }
                }

                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}