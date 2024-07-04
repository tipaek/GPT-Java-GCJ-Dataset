import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(inputReader.readLine());

            for (int t = 1; t <= testCases; t++) {
                int N = Integer.parseInt(inputReader.readLine());
                int trace = 0, repeatedRows = 0, repeatedCols = 0;

                int[][] matrix = new int[N][N];
                for (int i = 0; i < N; i++) {
                    String[] rowStrings = inputReader.readLine().split(" ");
                    int[] row = new int[N];
                    boolean[] seenInRow = new boolean[N + 1];
                    boolean rowRepeated = false;

                    for (int j = 0; j < N; j++) {
                        row[j] = Integer.parseInt(rowStrings[j]);
                        matrix[i][j] = row[j];

                        if (i == j) {
                            trace += row[j];
                        }

                        if (!rowRepeated && seenInRow[row[j]]) {
                            rowRepeated = true;
                        }
                        seenInRow[row[j]] = true;
                    }

                    if (rowRepeated) {
                        repeatedRows++;
                    }
                }

                for (int j = 0; j < N; j++) {
                    boolean[] seenInCol = new boolean[N + 1];
                    boolean colRepeated = false;

                    for (int i = 0; i < N; i++) {
                        if (!colRepeated && seenInCol[matrix[i][j]]) {
                            colRepeated = true;
                        }
                        seenInCol[matrix[i][j]] = true;
                    }

                    if (colRepeated) {
                        repeatedCols++;
                    }
                }

                System.out.printf("Case #%d: %d %d %d%n", t, trace, repeatedRows, repeatedCols);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}