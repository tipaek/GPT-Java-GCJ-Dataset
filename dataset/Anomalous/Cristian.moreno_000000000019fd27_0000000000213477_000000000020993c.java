import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bf.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(bf.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                String[] line = bf.readLine().split(" ");
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowHasDuplicates = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j]]) {
                        rowHasDuplicates = true;
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }
                }

                if (rowHasDuplicates) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean colHasDuplicates = false;

                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        colHasDuplicates = true;
                    } else {
                        colCheck[matrix[i][j]] = true;
                    }
                }

                if (colHasDuplicates) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}