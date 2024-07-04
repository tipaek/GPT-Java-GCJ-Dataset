import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Reading the matrix and calculating trace and row repeats
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j]]) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowRepeats++;
                }
            }

            // Calculating column repeats
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        colHasDuplicate = true;
                    } else {
                        colCheck[matrix[i][j]] = true;
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