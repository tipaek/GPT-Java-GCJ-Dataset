import java.util.*;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] inp = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    inp[j][k] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowEq = 0;
            int colEq = 0;
            for (int j = 0; j < n; j++) {
                trace += inp[j][j];
            }
            for (int j = 0; j < n; j++) {
                int[] freqRow = new int[n];
                for (int k = 0; k < n; k++) {
                    freqRow[inp[j][k] - 1]++;
                    if (freqRow[inp[j][k] - 1] > 1) {
                        rowEq++;
                        break;
                    }
                }
                int[] freqCol = new int[n];
                for (int k = 0; k < n; k++) {
                    freqCol[inp[k][j] - 1]++;
                    if (freqCol[inp[k][j] - 1] > 1) {
                        colEq++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowEq + " " + colEq);
        }
    }
}