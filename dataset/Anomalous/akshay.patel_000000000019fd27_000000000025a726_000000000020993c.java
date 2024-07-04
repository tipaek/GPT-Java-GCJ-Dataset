import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, repeatedRows = 0, repeatedCols = 0;

            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                boolean[] rowCheck = new boolean[n];
                boolean rowHasRepetition = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]) - 1;

                    if (!rowHasRepetition && rowCheck[matrix[i][j]]) {
                        rowHasRepetition = true;
                        repeatedRows++;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
                trace += matrix[i][i] + 1;
            }

            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[n];
                boolean colHasRepetition = false;

                for (int j = 0; j < n; j++) {
                    if (!colHasRepetition && colCheck[matrix[j][i]]) {
                        colHasRepetition = true;
                        repeatedCols++;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            writer.println("Case #" + t + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }

        writer.close();
        reader.close();
    }
}