import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new int[]{start, end});
            }

            int cEnd = 0;
            int jEnd = 0;
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];

                if (cEnd <= start) {
                    cEnd = end;
                    schedule.append('C');
                } else if (jEnd <= start) {
                    jEnd = end;
                    schedule.append('J');
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + t + ": " + schedule);
        }

        scanner.close();
    }
}