import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(inputReader.readLine());

            for (int t = 1; t <= testCases; t++) {
                int N = Integer.parseInt(inputReader.readLine());
                int trace = 0, repeatedRows = 0, repeatedCols = 0;

                int[][] matrix = new int[N][N];
                for (int i = 0; i < N; i++) {
                    String[] rowInput = inputReader.readLine().split(" ");
                    int[] row = new int[N];
                    boolean[] rowCheck = new boolean[N + 1];
                    boolean rowRepeated = false;

                    for (int j = 0; j < N; j++) {
                        row[j] = Integer.parseInt(rowInput[j]);
                        if (i == j) {
                            trace += row[j];
                        }
                        if (rowCheck[row[j]]) {
                            rowRepeated = true;
                        } else {
                            rowCheck[row[j]] = true;
                        }
                        matrix[i][j] = row[j];
                    }

                    if (rowRepeated) {
                        repeatedRows++;
                    }
                }

                for (int j = 0; j < N; j++) {
                    boolean[] colCheck = new boolean[N + 1];
                    boolean colRepeated = false;

                    for (int i = 0; i < N; i++) {
                        if (colCheck[matrix[i][j]]) {
                            colRepeated = true;
                        } else {
                            colCheck[matrix[i][j]] = true;
                        }
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