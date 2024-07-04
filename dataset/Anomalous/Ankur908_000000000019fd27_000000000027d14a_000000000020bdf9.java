import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] intervals = new int[2 * n];

            for (int i = 0; i < 2 * n; i++) {
                intervals[i] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            result.append('C');

            int cEnd = intervals[1];
            int jEnd = 0;

            boolean isImpossible = false;

            for (int i = 2; i < 2 * n; i += 2) {
                int start = intervals[i];
                int end = intervals[i + 1];

                if (start >= cEnd) {
                    result.append('C');
                    cEnd = end;
                } else if (start >= jEnd) {
                    result.append('J');
                    jEnd = end;
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}