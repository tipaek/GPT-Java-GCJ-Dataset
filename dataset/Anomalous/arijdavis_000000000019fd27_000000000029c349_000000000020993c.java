import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = stdin.nextInt();

        for (int t = 0; t < cases; t++) {
            int n = stdin.nextInt();
            int[][] rowFreq = new int[n + 1][n + 1];
            int[][] colFreq = new int[n + 1][n + 1];

            int trace = 0;
            int rowsWithReps = 0;
            int colsWithReps = 0;

            boolean[] rowHasReps = new boolean[n + 1];
            boolean[] colHasReps = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int m = stdin.nextInt();

                    if (i == j) {
                        trace += m;
                    }

                    rowFreq[i][m]++;
                    colFreq[j][m]++;

                    if (rowFreq[i][m] > 1 && !rowHasReps[i]) {
                        rowHasReps[i] = true;
                        rowsWithReps++;
                    }

                    if (colFreq[j][m] > 1 && !colHasReps[j]) {
                        colHasReps[j] = true;
                        colsWithReps++;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowsWithReps + " " + colsWithReps);
        }
    }
}