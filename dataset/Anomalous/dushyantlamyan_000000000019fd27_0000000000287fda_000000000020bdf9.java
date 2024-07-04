import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            int cEnd = 0, jEnd = 0;

            for (int j = 0; j < n; j++) {
                int start = intervals[j][0];
                int end = intervals[j][1];

                if (start >= cEnd) {
                    result.append('C');
                    cEnd = end;
                } else if (start >= jEnd) {
                    result.append('J');
                    jEnd = end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + i + ": " + result.toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}