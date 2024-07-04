import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());

        for (int tt = 0; tt < testCases; tt++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int rowCount = 0;
            int colCount = 0;

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n];
                boolean[] colCheck = new boolean[n];
                boolean rowDuplicate = false;
                boolean colDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j] - 1]) {
                        rowDuplicate = true;
                    } else {
                        rowCheck[matrix[i][j] - 1] = true;
                    }

                    if (colCheck[matrix[j][i] - 1]) {
                        colDuplicate = true;
                    } else {
                        colCheck[matrix[j][i] - 1] = true;
                    }
                }

                if (rowDuplicate) {
                    rowCount++;
                }

                if (colDuplicate) {
                    colCount++;
                }
            }

            writer.printf("Case #%d: %d %d %d\n", tt + 1, trace, rowCount, colCount);
        }

        reader.close();
        writer.close();
    }
}