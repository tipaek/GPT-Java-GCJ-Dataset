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

            String result = getSchedule(startTimes, endTimes, n);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String getSchedule(int[] startTimes, int[] endTimes, int n) {
        char currentChar = 'C';
        StringBuilder schedule = new StringBuilder("C");
        int maxEndTime = endTimes[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (startTimes[i] >= maxEndTime) {
                schedule.append(currentChar);
            } else if (startTimes[i] >= endTimes[i - 1]) {
                count--;
                if (count < 2) {
                    schedule.append(currentChar);
                    count++;
                } else {
                    return "IMPOSSIBLE";
                }
            } else {
                if (count < 2) {
                    currentChar = swapChar(currentChar);
                    schedule.append(currentChar);
                    count++;
                } else {
                    return "IMPOSSIBLE";
                }
            }
            if (maxEndTime < endTimes[i]) {
                maxEndTime = endTimes[i];
                count--;
            }
        }
        return schedule.toString();
    }

    private static char swapChar(char ch) {
        return (ch == 'J') ? 'C' : 'J';
    }

    static int findPlatforms(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformsNeeded = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
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