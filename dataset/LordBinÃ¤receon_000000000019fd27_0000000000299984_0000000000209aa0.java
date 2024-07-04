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
        if (k % n != 0 && n != 4) {
            return "IMPOSSIBLE";
        }
        if (n == 4) {
            if (k == 6) {
                String out = "POSSIBLE" + System.lineSeparator();
                out += "1 3 4 2" + System.lineSeparator() + "4 2 1 3" + System.lineSeparator() + "3 1 2 4" + System.lineSeparator() + "2 4 3 1";
                return out;
            }
            if (k == 10) {
                String out = "POSSIBLE" + System.lineSeparator();
                out += "1 2 3 4" + System.lineSeparator() + "3 4 1 2" + System.lineSeparator() + "2 1 4 3" + System.lineSeparator() + "4 3 2 1";
            }
            if (k == 14) {
                String out = "POSSIBLE" + System.lineSeparator();
                out += "3 1 2 4" + System.lineSeparator() + "2 4 3 1" + System.lineSeparator() + "1 3 4 2" + System.lineSeparator() + "4 2 1 3";
            }
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
                if (j != n-1) {
                    builder.append(" ");
                }
            }
            if (i != n-1) {
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
