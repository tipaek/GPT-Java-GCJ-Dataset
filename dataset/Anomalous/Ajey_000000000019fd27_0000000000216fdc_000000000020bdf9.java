import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            Map<Integer, Integer> timeMap = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                timeMap.put(startTimes[i], endTimes[i]);
            }

            Arrays.sort(startTimes);
            for (int i = 0; i < n; i++) {
                endTimes[i] = timeMap.get(startTimes[i]);
            }

            boolean isPossible = true;
            int cameronEnd = endTimes[0];
            int jamieEnd = 0;
            StringBuilder schedule = new StringBuilder("C");

            for (int i = 1; i < n; i++) {
                if (startTimes[i] >= cameronEnd) {
                    cameronEnd = endTimes[i];
                    schedule.append("C");
                } else if (startTimes[i] >= jamieEnd) {
                    jamieEnd = endTimes[i];
                    schedule.append("J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + testCase + ": " + schedule);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}