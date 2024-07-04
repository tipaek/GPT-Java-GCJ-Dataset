import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[1441];
            int[] originalStartTimes = new int[n];
            char[] schedule = new char[1441];

            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[startTimes[j]] = scanner.nextInt();
                originalStartTimes[j] = startTimes[j];
            }

            Arrays.sort(startTimes);

            int cEndTime = 0;
            int jEndTime = 0;
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < n; j++) {
                int currentStart = startTimes[j];
                int currentEnd = endTimes[currentStart];

                if (currentStart >= cEndTime) {
                    schedule[currentStart] = 'C';
                    cEndTime = currentEnd;
                } else if (currentStart >= jEndTime) {
                    schedule[currentStart] = 'J';
                    jEndTime = currentEnd;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                for (int j = 0; j < n; j++) {
                    result.append(schedule[originalStartTimes[j]]);
                }
                System.out.println("Case #" + i + ": " + result.toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}