package qualification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Vestigium {

    public static void main(String[] args) {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(inputReader.readLine());

            for (int t = 1; t <= testCases; t++) {
                int N = Integer.parseInt(inputReader.readLine());
                int trace = 0, repeatedRows = 0, repeatedCols = 0;

                int[][] columns = new int[N][N];
                for (int i = 0; i < N; i++) {
                    int[] row = Arrays.stream(inputReader.readLine().split(" "))
                                      .mapToInt(Integer::parseInt)
                                      .toArray();
                    trace += row[i];

                    int[] sortedRow = Arrays.copyOf(row, N);
                    Arrays.sort(sortedRow);
                    boolean repeated = false;
                    for (int j = 0; j < N; j++) {
                        if (j < N - 1 && sortedRow[j] == sortedRow[j + 1]) {
                            repeated = true;
                        }
                        columns[j][i] = row[j];
                    }

                    if (repeated) {
                        repeatedRows++;
                    }
                }
                for (int j = 0; j < N; j++) {
                    Arrays.sort(columns[j]);
                    for (int i = 0; i < N; i++) {
                        if (i < N - 1 && columns[j][i] == columns[j][i + 1]) {
                            repeatedCols++;
                            break;
                        }
                    }
                }

                System.out.printf("Case #%d: %d %d %d%n", t, trace, repeatedRows, repeatedCols);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}