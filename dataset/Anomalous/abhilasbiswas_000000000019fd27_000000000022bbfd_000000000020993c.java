import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; ++i) {
            String result = processTestCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processTestCase(Scanner input) {
        int n = input.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int trace = 0, rowRepeats = 0, colRepeats = 0;

        for (int i = 0; i < n; ++i) {
            trace += matrix[i][i];
            boolean[] rowCheck = new boolean[n];
            boolean[] colCheck = new boolean[n];

            for (int j = 0; j < n; ++j) {
                int rowValue = matrix[i][j] - 1;
                if (!rowCheck[rowValue]) {
                    rowCheck[rowValue] = true;
                } else {
                    rowRepeats++;
                    break;
                }
            }

            for (int j = 0; j < n; ++j) {
                int colValue = matrix[j][i] - 1;
                if (!colCheck[colValue]) {
                    colCheck[colValue] = true;
                } else {
                    colRepeats++;
                    break;
                }
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }
}