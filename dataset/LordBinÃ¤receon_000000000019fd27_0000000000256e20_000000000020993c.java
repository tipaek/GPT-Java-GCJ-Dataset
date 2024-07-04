import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int trace = 0;
            int wrongRows = 0;
            int wrongCols = 0;
            boolean[][] colNumbers = new boolean[n][n];
            for (int j = 1; j <= n; j++) {
                boolean[] numbersIncluded = new boolean[n];
                for (int k = 1; k <= n; k++) {
                    int cell = scanner.nextInt();
                    if (j == k) {
                        trace += cell;
                    }
                    numbersIncluded[cell-1] = true;
                    colNumbers[k-1][cell-1] = true;
                }
                for (boolean numberIncluded : numbersIncluded) {
                    if (numberIncluded != true) {
                        wrongRows++;
                        break;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (colNumbers[j][k] != true) {
                        wrongCols++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + wrongRows + " " + wrongCols);
        }
    }
}
