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
                schedule = createSchedule(startTimes, endTimes, n);
            }
            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    public static String createSchedule(int[] starts, int[] ends, int n) {
        StringBuilder schedule = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (findConflict(starts, ends, schedule.toString(), 'C', starts[i], ends[i]) == -1) {
                schedule.append('C');
            } else if (findConflict(starts, ends, schedule.toString(), 'J', starts[i], ends[i]) == -1) {
                schedule.append('J');
            } else {
                schedule = new StringBuilder(swap(starts, ends, schedule.toString(), findConflict(starts, ends, schedule.toString(), 'J', starts[i], ends[i])));
                schedule.append('J');
            }
        }
        return schedule.toString();
    }

    public static boolean isImpossible(int n, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (timeConflict(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j && timeConflict(startTimes[k], endTimes[k], startTimes[i], endTimes[i]) && timeConflict(startTimes[k], endTimes[k], startTimes[j], endTimes[j])) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int findConflict(int[] starts, int[] ends, String schedule, char person, int start, int end) {
        for (int i = 0; i < schedule.length(); i++) {
            if (schedule.charAt(i) == person) {
                if ((start > starts[i] && start < ends[i]) || (end > starts[i] && end < ends[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean timeConflict(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2) || (start2 < end1 && end2 > start1);
    }

    public static String swap(int[] starts, int[] ends, String schedule, int index) {
        StringBuilder updatedSchedule = new StringBuilder(schedule);
        updatedSchedule.setCharAt(index, schedule.charAt(index) == 'C' ? 'J' : 'C');
        int conflictIndex = findConflict(starts, ends, updatedSchedule.toString());
        if (conflictIndex != -1) {
            return swap(starts, ends, updatedSchedule.toString(), conflictIndex);
        }
        return updatedSchedule.toString();
    }
}