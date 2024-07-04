import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int numIntervals = scanner.nextInt();
            int cameronStart = scanner.nextInt();
            int cameronEnd = scanner.nextInt();
            int jamieStart = scanner.nextInt();
            int jamieEnd = scanner.nextInt();
            StringBuilder result = new StringBuilder("CJ");

            for (int j = 2; j < numIntervals; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if ((end > cameronStart && end < cameronEnd && end > jamieStart && end < jamieEnd) ||
                    (start > cameronStart && start < cameronEnd && start > jamieStart && start < jamieEnd)) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                if (end <= cameronStart) {
                    result.append("C");
                    cameronStart = start;
                } else if (end <= jamieStart) {
                    result.append("J");
                    jamieStart = start;
                } else if (start >= cameronEnd) {
                    result.append("C");
                    cameronEnd = end;
                } else if (end >= jamieEnd) {
                    result.append("J");
                    jamieEnd = end;
                }
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}