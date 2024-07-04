import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] assignments = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            boolean impossible = false;

            for (int i = 1; i < n; i++) {
                boolean firstAssignment = false;
                for (int j = i - 1; j >= 0; j--) {
                    boolean overlap = (startTimes[i] <= startTimes[j] && endTimes[i] > startTimes[j]) ||
                                      (startTimes[i] < endTimes[j] && endTimes[i] >= endTimes[j]) ||
                                      (startTimes[i] >= startTimes[j] && endTimes[i] <= endTimes[j]);

                    if (overlap) {
                        if (!firstAssignment) {
                            assignments[i] = 1 - assignments[j];
                            firstAssignment = true;
                        } else if (assignments[i] == assignments[j]) {
                            impossible = true;
                        }
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    result.append(assignments[i] == 1 ? "J" : "C");
                }
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }
}