import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int n = scanner.nextInt();
            int[][] square = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    square[j][k] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(square, n);
            int repeatR = calculateMaxRepetitions(square, n, true);
            int repeatC = calculateMaxRepetitions(square, n, false);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatR + " " + repeatC);
        }
    }

    private static int calculateTrace(int[][] square, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += square[i][i];
        }
        return trace;
    }

    private static int calculateMaxRepetitions(int[][] square, int n, boolean isRow) {
        int maxRepetitions = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[n + 1]; // Assuming values are between 1 and n
            for (int j = 0; j < n; j++) {
                int value = isRow ? square[i][j] : square[j][i];
                count[value]++;
                if (count[value] > maxRepetitions) {
                    maxRepetitions = count[value];
                }
            }
        }
        return maxRepetitions;
    }
}