import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt(); // Number of activities
            int cStart = scanner.nextInt();
            int cEnd = scanner.nextInt();
            int jStart = scanner.nextInt();
            int jEnd = scanner.nextInt();

            StringBuilder result = new StringBuilder("CJ");

            for (int j = 2; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if ((end > cStart && end < cEnd && end > jStart && end < jEnd) ||
                    (start > cStart && start < cEnd && start > jStart && start < jEnd)) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                if (end <= cStart) {
                    result.append("C");
                    cStart = start;
                } else if (end <= jStart) {
                    result.append("J");
                    jStart = start;
                } else if (start >= cEnd) {
                    result.append("C");
                    cEnd = end;
                } else if (start >= jEnd) {
                    result.append("J");
                    jEnd = end;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}