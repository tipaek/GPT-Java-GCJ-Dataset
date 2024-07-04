import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            // Bubble sort to sort intervals by start times
            for (int x = 0; x < n - 1; x++) {
                boolean swapped = false;
                for (int y = 0; y < n - x - 1; y++) {
                    if (startTimes[y] > startTimes[y + 1]) {
                        swapped = true;
                        int tempStart = startTimes[y];
                        int tempEnd = endTimes[y];
                        startTimes[y] = startTimes[y + 1];
                        endTimes[y] = endTimes[y + 1];
                        startTimes[y + 1] = tempStart;
                        endTimes[y + 1] = tempEnd;
                    }
                }
                if (!swapped) break;
            }

            StringBuilder schedule = new StringBuilder("CJ");
            boolean isPossible = true;
            int cameronEnd = endTimes[0];
            int jamieEnd = endTimes[1];

            for (int k = 2; k < n; k++) {
                if (cameronEnd <= startTimes[k]) {
                    schedule.append('C');
                    cameronEnd = endTimes[k];
                } else if (jamieEnd <= startTimes[k]) {
                    schedule.append('J');
                    jamieEnd = endTimes[k];
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + i + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}