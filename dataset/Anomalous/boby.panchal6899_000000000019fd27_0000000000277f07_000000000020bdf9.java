import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new int[]{start, end});
            }

            int cEnd = 0;
            int jEnd = 0;
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];

                if (cEnd <= start) {
                    cEnd = end;
                    result.append('C');
                } else if (jEnd <= start) {
                    jEnd = end;
                    result.append('J');
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}