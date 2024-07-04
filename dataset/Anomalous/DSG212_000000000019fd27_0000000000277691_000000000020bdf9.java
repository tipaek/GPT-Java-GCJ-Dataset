import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            for (int j = 0; j < n; j++) {
                startTimes[j] = in.nextInt();
                endTimes[j] = in.nextInt();
            }
            String schedule = findSchedule(startTimes, endTimes, n);
            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    private static String findSchedule(int[] startTimes, int[] endTimes, int n) {
        if (isImpossible(n, startTimes, endTimes)) {
            return "IMPOSSIBLE";
        }

        return generateSchedule("", startTimes, endTimes, n);
    }

    private static boolean isImpossible(int n, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (hasConflict(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            if (hasConflict(startTimes[k], endTimes[k], startTimes[i], endTimes[i]) &&
                                hasConflict(startTimes[k], endTimes[k], startTimes[j], endTimes[j])) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static String generateSchedule(String currentSchedule, int[] startTimes, int[] endTimes, int n) {
        for (int i = currentSchedule.length(); i < n; i++) {
            if (canSchedule(currentSchedule, startTimes, endTimes, 'C', startTimes[i], endTimes[i])) {
                currentSchedule += 'C';
            } else if (canSchedule(currentSchedule, startTimes, endTimes, 'J', startTimes[i], endTimes[i])) {
                currentSchedule += 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return currentSchedule;
    }

    private static boolean canSchedule(String currentSchedule, int[] startTimes, int[] endTimes, char person, int startTime, int endTime) {
        for (int i = 0; i < currentSchedule.length(); i++) {
            if (currentSchedule.charAt(i) == person) {
                if (hasConflict(startTimes[i], endTimes[i], startTime, endTime)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasConflict(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}