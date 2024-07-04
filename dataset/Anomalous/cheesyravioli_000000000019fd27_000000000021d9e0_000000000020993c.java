import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                boolean[] rowCheck = new boolean[n];
                boolean rowHasRepeat = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j] - 1]) {
                        rowHasRepeat = true;
                    }
                    rowCheck[matrix[i][j] - 1] = true;
                }
                if (rowHasRepeat) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n];
                boolean colHasRepeat = false;

                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j] - 1]) {
                        colHasRepeat = true;
                        break;
                    }
                    colCheck[matrix[i][j] - 1] = true;
                }
                if (colHasRepeat) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        // Uncomment the following line to print the execution time
        // System.out.println(totalTime / 1_000_000_000.0);
    }
}