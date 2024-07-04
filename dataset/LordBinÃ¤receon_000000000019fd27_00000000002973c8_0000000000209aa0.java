import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println("Case #" + i + ": " + solve(scanner, n, k));
        }
    }

    public static String solve(Scanner scanner, int n, int k) {
        if (k % n != 0) {
            return "IMPOSSIBLE";
        }
        int[][] matrix = new int[n][n];
        int traceVal = k / n;
        for (int i = 0; i < n; i++) {
            int nextVal = traceVal;
            for (int j = i; j < n + i; j++) {
                matrix[i % n][j % n] = nextVal;
                nextVal = nextVal % n + 1;
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("POSSIBLE");
        builder.append(System.lineSeparator());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                builder.append(matrix[i][j]);
                if (j != n) {
                    builder.append(" ");
                }
            }
            if (i != n) {
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
