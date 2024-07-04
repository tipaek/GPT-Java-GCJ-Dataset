import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] rowFrequency = new int[n + 1][n + 1];
            int[][] colFrequency = new int[n + 1][n + 1];

            int trace = 0;
            int rowsWithReps = 0;
            int colsWithReps = 0;
            boolean[] rowHasReps = new boolean[n + 1];
            boolean[] colHasReps = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int value = scanner.nextInt();

                    if (i == j) {
                        trace += value;
                    }

                    rowFrequency[i][value]++;
                    colFrequency[j][value]++;

                    if (rowFrequency[i][value] > 1 && !rowHasReps[i]) {
                        rowHasReps[i] = true;
                        rowsWithReps++;
                    }

                    if (colFrequency[j][value] > 1 && !colHasReps[j]) {
                        colHasReps[j] = true;
                        colsWithReps++;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowsWithReps + " " + colsWithReps);
        }
    }
}