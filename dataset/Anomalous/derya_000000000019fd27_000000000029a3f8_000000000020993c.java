import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Solution {
    private static final PrintStream out = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];

                boolean[] rowCheck = new boolean[n];
                boolean[] colCheck = new boolean[n];

                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j] - 1]) {
                        duplicateRows++;
                        break;
                    }
                    rowCheck[matrix[i][j] - 1] = true;
                }

                for (int j = 0; j < n; j++) {
                    if (colCheck[matrix[j][i] - 1]) {
                        duplicateCols++;
                        break;
                    }
                    colCheck[matrix[j][i] - 1] = true;
                }
            }

            out.printf("Case #%d: %d %d %d%n", t + 1, trace, duplicateRows, duplicateCols);
        }
    }
}