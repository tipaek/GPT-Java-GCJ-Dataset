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
            if (!isImpossible(n, startTimes, endTimes)) {
                schedule = findSchedule("", startTimes, endTimes, n);
            }
            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    public static String findSchedule(String currentSchedule, int[] startTimes, int[] endTimes, int n) {
        String schedule = currentSchedule;
        for (int i = currentSchedule.length(); i < n; i++) {
            if (hasConflict(startTimes, endTimes, schedule, 'C', startTimes[i], endTimes[i]) == -1) {
                schedule += 'C';
            } else if (hasConflict(startTimes, endTimes, schedule, 'J', startTimes[i], endTimes[i]) == -1) {
                schedule += 'J';
            } else {
                schedule = "IMPOSSIBLE";
                break;
            }
        }
        return schedule;
    }

    public static boolean isImpossible(int n, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && hasConflict(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j && hasConflict(startTimes[k], endTimes[k], startTimes[i], endTimes[i]) &&
                            hasConflict(startTimes[k], endTimes[k], startTimes[j], endTimes[j])) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int hasConflict(int[] startTimes, int[] endTimes, String schedule, char person, int start, int end) {
        for (int i = 0; i < schedule.length(); i++) {
            if (schedule.charAt(i) == person) {
                if (hasConflict(startTimes[i], endTimes[i], start, end)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean hasConflict(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }

    public static int hasConflict(int[] startTimes, int[] endTimes, String schedule) {
        for (int i = 0; i < schedule.length(); i++) {
            int conflictIndex = hasConflict(startTimes, endTimes, schedule, schedule.charAt(i), startTimes[i], endTimes[i]);
            if (conflictIndex != -1) {
                return conflictIndex;
            }
        }
        return -1;
    }

    public static String swapSchedule(int[] startTimes, int[] endTimes, String schedule, int index) {
        StringBuilder newSchedule = new StringBuilder();
        newSchedule.append(schedule, 0, index);
        newSchedule.append(schedule.charAt(index) == 'C' ? 'J' : 'C');
        newSchedule.append(schedule.substring(index + 1));
        if (hasConflict(startTimes, endTimes, newSchedule.toString()) != -1) {
            return swapSchedule(startTimes, endTimes, newSchedule.toString(), hasConflict(startTimes, endTimes, newSchedule.toString()));
        } else {
            return newSchedule.toString();
        }
    }
}