import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int cStart = scanner.nextInt(), cEnd = scanner.nextInt();
            int jStart = scanner.nextInt(), jEnd = scanner.nextInt();
            StringBuilder result = new StringBuilder("CJ");

            boolean isPossible = true;
            for (int i = 2; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if ((end > cStart && end < cEnd && end > jStart && end < jEnd) ||
                    (start > cStart && start < cEnd && start > jStart && start < jEnd)) {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
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

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}