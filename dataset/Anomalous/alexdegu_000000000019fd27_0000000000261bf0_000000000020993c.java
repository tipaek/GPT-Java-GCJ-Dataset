import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] rows = new int[n][n];
            int[][] cols = new int[n][n];
            boolean[] rowsRepeat = new boolean[n];
            boolean[] colsRepeat = new boolean[n];

            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();

                    if (!rowsRepeat[i]) {
                        if (rows[i][value - 1] == 1) {
                            rowsRepeat[i] = true;
                            repeatedRows++;
                        } else {
                            rows[i][value - 1] = 1;
                        }
                    }

                    if (!colsRepeat[j]) {
                        if (cols[j][value - 1] == 1) {
                            colsRepeat[j] = true;
                            repeatedCols++;
                        } else {
                            cols[j][value - 1] = 1;
                        }
                    }

                    if (i == j) {
                        trace += value;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, repeatedRows, repeatedCols);
        }
    }
}