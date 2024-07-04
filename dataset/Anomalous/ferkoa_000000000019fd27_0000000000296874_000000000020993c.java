import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private static String solve(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;
        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            boolean rowHasDuplicates = false;
            boolean colHasDuplicates = false;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                int value = matrix[i][j] - 1;

                if (!rowHasDuplicates) {
                    if (!rows[i][value]) {
                        rows[i][value] = true;
                    } else {
                        rowHasDuplicates = true;
                        rowRepeats++;
                    }
                }

                if (!colHasDuplicates) {
                    if (!cols[j][value]) {
                        cols[j][value] = true;
                    } else {
                        colHasDuplicates = true;
                        colRepeats++;
                    }
                }
            }
        }
        return trace + " " + rowRepeats + " " + colRepeats;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            out.println("Case #" + t + ": " + solve(matrix));
        }
        scanner.close();
    }
}