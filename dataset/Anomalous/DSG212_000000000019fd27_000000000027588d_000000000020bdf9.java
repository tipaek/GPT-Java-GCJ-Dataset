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
            String schedule = "IMPOSSIBLE";
            if (!hasImpossibleSchedule(n, startTimes, endTimes)) {
                schedule = createSchedule("", startTimes, endTimes, n);
            }
            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    public static String createSchedule(String schedule, int[] startTimes, int[] endTimes, int n) {
        StringBuilder sch = new StringBuilder(schedule);
        for (int i = sch.length(); i < n; i++) {
            if (findConflict(startTimes, endTimes, sch.toString(), 'C', startTimes[i], endTimes[i]) == -1) {
                sch.append('C');
            } else if (findConflict(startTimes, endTimes, sch.toString(), 'J', startTimes[i], endTimes[i]) == -1) {
                sch.append('J');
            } else {
                while (findConflict(startTimes, endTimes, sch.toString(), 'J', startTimes[i], endTimes[i]) != -1) {
                    sch = new StringBuilder(swapSchedules(startTimes, endTimes, sch.toString(), findConflict(startTimes, endTimes, sch.toString(), 'J', startTimes[i], endTimes[i])));
                }
                sch.append('J');
            }
        }
        return sch.toString();
    }

    public static boolean hasImpossibleSchedule(int n, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (timeConflict(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            if (timeConflict(startTimes[k], endTimes[k], startTimes[i], endTimes[i]) && timeConflict(startTimes[k], endTimes[k], startTimes[j], endTimes[j])) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int findConflict(int[] startTimes, int[] endTimes, String schedule, char person, int start, int end) {
        for (int i = 0; i < schedule.length(); i++) {
            if (schedule.charAt(i) == person) {
                if ((start > startTimes[i] && start < endTimes[i]) || (end > startTimes[i] && end < endTimes[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean timeConflict(int start1, int end1, int start2, int end2) {
        return ((start1 > start2 && start1 < end2) || (end1 > start2 && end1 < end2)) ||
               ((start2 > start1 && start2 < end1) || (end2 > start1 && end2 < end1));
    }

    public static int findOverallConflict(int[] startTimes, int[] endTimes, String schedule) {
        for (int i = 0; i < schedule.length(); i++) {
            int conflict = findConflict(startTimes, endTimes, schedule, schedule.charAt(i), startTimes[i], endTimes[i]);
            if (conflict != -1) {
                return conflict;
            }
        }
        return -1;
    }

    public static String swapSchedules(int[] startTimes, int[] endTimes, String schedule, int index) {
        StringBuilder newSchedule = new StringBuilder(schedule);
        newSchedule.setCharAt(index, newSchedule.charAt(index) == 'C' ? 'J' : 'C');
        if (findOverallConflict(startTimes, endTimes, newSchedule.toString()) != -1) {
            return swapSchedules(startTimes, endTimes, newSchedule.toString(), findOverallConflict(startTimes, endTimes, newSchedule.toString()));
        } else {
            return newSchedule.toString();
        }
    }
}