import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }
            
            String schedule = "IMPOSSIBLE";
            if (!isImpossible(n, startTimes, endTimes)) {
                schedule = generateSchedule("", startTimes, endTimes, n);
            }
            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    public static String generateSchedule(String schedule, int[] startTimes, int[] endTimes, int n) {
        StringBuilder sb = new StringBuilder(schedule);
        
        for (int i = sb.length(); i < n; i++) {
            if (conflictWithExistingTasks(startTimes, endTimes, sb.toString(), 'C', startTimes[i], endTimes[i]) == -1) {
                sb.append('C');
            } else if (conflictWithExistingTasks(startTimes, endTimes, sb.toString(), 'J', startTimes[i], endTimes[i]) == -1) {
                sb.append('J');
            } else {
                sb = new StringBuilder(swapTasks(startTimes, endTimes, sb.toString(), conflictWithExistingTasks(startTimes, endTimes, sb.toString(), 'J', startTimes[i], endTimes[i])));
                sb.append('J');
            }
        }
        return sb.toString();
    }

    public static boolean isImpossible(int n, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (timeConflict(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            if (timeConflict(startTimes[k], endTimes[k], startTimes[i], endTimes[i]) &&
                                timeConflict(startTimes[k], endTimes[k], startTimes[j], endTimes[j])) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int conflictWithExistingTasks(int[] startTimes, int[] endTimes, String schedule, char person, int start, int end) {
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

    public static String swapTasks(int[] startTimes, int[] endTimes, String schedule, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append(schedule, 0, index);
        sb.append(schedule.charAt(index) == 'C' ? 'J' : 'C');
        sb.append(schedule.substring(index + 1));
        return sb.toString();
    }
}