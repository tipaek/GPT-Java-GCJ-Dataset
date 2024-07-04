import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            char currentChar = 'C';
            HashMap<Integer, Integer> timeMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                timeMap.put(startTimes[i], endTimes[i]);
            }

            Arrays.sort(startTimes);
            int maxEndTime = timeMap.get(startTimes[0]);
            StringBuilder output = new StringBuilder("C");
            int concurrentTasks = 1;

            for (int i = 1; i < n; i++) {
                if (startTimes[i] >= timeMap.get(startTimes[i - 1])) {
                    concurrentTasks--;
                    if (concurrentTasks < 2) {
                        output.append(currentChar);
                        concurrentTasks++;
                    } else {
                        output = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                } else if (startTimes[i] >= maxEndTime) {
                    output.append(currentChar);
                } else {
                    if (concurrentTasks < 2) {
                        currentChar = swapChar(currentChar);
                        output.append(currentChar);
                        concurrentTasks++;
                    } else {
                        output = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                if (maxEndTime < timeMap.get(startTimes[i])) {
                    maxEndTime = timeMap.get(startTimes[i]);
                    concurrentTasks--;
                }
            }
            System.out.println("Case #" + t + ": " + output);
        }
    }

    private static char swapChar(char ch) {
        return ch == 'J' ? 'C' : 'J';
    }

    static int findPlatformsNeeded(int[] arrivals, int[] departures, int n) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int platformsNeeded = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arrivals[i] <= departures[j]) {
                platformsNeeded++;
                i++;
                if (platformsNeeded > result) {
                    result = platformsNeeded;
                }
            } else {
                platformsNeeded--;
                j++;
            }
        }

        return result;
    }
}