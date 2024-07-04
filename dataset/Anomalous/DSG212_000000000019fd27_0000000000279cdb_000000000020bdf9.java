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
            String schedule = findSchedule(n, startTimes, endTimes);
            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    private static String findSchedule(int n, int[] startTimes, int[] endTimes) {
        if (isImpossible(n, startTimes, endTimes)) {
            return "IMPOSSIBLE";
        }
        return createSchedule("", startTimes, endTimes, n);
    }

    private static String createSchedule(String schedule, int[] startTimes, int[] endTimes, int n) {
        for (int i = schedule.length(); i < n; i++) {
            if (findConflict(startTimes, endTimes, schedule, 'C', startTimes[i], endTimes[i]) == -1) {
                schedule += 'C';
            } else if (findConflict(startTimes, endTimes, schedule, 'J', startTimes[i], endTimes[i]) == -1) {
                schedule += 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule;
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

    private static int findConflict(int[] startTimes, int[] endTimes, String schedule, char person, int start, int end) {
        for (int i = 0; i < schedule.length(); i++) {
            if (schedule.charAt(i) == person) {
                if (hasConflict(startTimes[i], endTimes[i], start, end) || startTimes[i] == start || endTimes[i] == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean hasConflict(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}