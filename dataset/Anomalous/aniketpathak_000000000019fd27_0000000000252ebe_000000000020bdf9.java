import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            int count = findPlatformCount(startTimes, endTimes, n);
            if (count > 2) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                char currentChar = 'C';
                HashMap<Integer, Integer> timeMap = new HashMap<>();

                for (int i = 0; i < n; i++) {
                    timeMap.put(startTimes[i], endTimes[i]);
                }

                Arrays.sort(startTimes);
                int maxEndTime = timeMap.get(startTimes[0]);
                StringBuilder output = new StringBuilder("C");

                for (int i = 1; i < n; i++) {
                    if (startTimes[i] >= maxEndTime) {
                        output.append(currentChar);
                    } else {
                        currentChar = swapCharacter(currentChar);
                        output.append(currentChar);
                    }
                    if (maxEndTime < timeMap.get(startTimes[i])) {
                        maxEndTime = timeMap.get(startTimes[i]);
                    }
                }
                System.out.println("Case #" + t + ": " + output.toString());
            }
        }
    }

    private static char swapCharacter(char ch) {
        return ch == 'J' ? 'C' : 'J';
    }

    static int findPlatformCount(int[] arrival, int[] departure, int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platformsNeeded = 1, maxPlatforms = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platformsNeeded++;
                i++;
                if (platformsNeeded > maxPlatforms) {
                    maxPlatforms = platformsNeeded;
                }
            } else {
                platformsNeeded--;
                j++;
            }
        }

        return maxPlatforms;
    }
}