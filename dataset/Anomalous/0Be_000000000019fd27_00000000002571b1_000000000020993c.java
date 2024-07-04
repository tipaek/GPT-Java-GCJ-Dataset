import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().split("\\s+");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (colCheck[matrix[j][i]]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            result.append(String.format("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats));
        }

        writer.print(result);
        reader.close();
        writer.close();
    }
}