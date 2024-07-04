import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + i + ": " + solve(n, scanner));
        }
    }

    public static String solve(int n, Scanner scanner) {
        int jStart = 0;
        int jEnd = 0;
        int cStart = 0;
        int cEnd = 0;
        StringBuilder out = new StringBuilder(n);
        for (int j = 1; j <= n; j++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (start >= jEnd || end <= jStart) {
                out.append("C");
                jStart = start;
                jEnd = end;
            } else if (start >= cEnd || end <= cStart) {
                out.append("J");
                cStart = start;
                cEnd = end;
            } else {
                out.replace(0, 0, "F");
            }
        }
        String outString = out.toString();
        if (outString.startsWith("F")) {
            return "IMPOSSIBLE";
        }
        return outString;
    }
}
