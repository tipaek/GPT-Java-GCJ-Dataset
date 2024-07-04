import java.util.Scanner;

public class Jam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] traceResults = new int[testCases];
        int[] rowRepeats = new int[testCases];
        int[] colRepeats = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            traceResults[t] = trace;
            rowRepeats[t] = 0; // Placeholder for future logic
            colRepeats[t] = 0; // Placeholder for future logic
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + traceResults[t] + " " + rowRepeats[t] + " " + colRepeats[t]);
        }

        scanner.close();
    }
}