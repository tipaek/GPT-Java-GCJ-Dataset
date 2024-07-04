import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }
            
            String schedule = "IMPOSSIBLE";
            if (!hasImpossibleSchedule(n, startTimes, endTimes)) {
                schedule = createSchedule("", startTimes, endTimes, n);
            }
            
            System.out.println("Case #" + caseNum + ": " + schedule);
        }
    }

    public static String createSchedule(String currentSchedule, int[] startTimes, int[] endTimes, int n) {
        String schedule = currentSchedule;
        
        for (int i = schedule.length(); i < n; i++) {
            if (findConflict(startTimes, endTimes, schedule, 'C', startTimes[i], endTimes[i]) == -1) {
                schedule += 'C';
            } else if (findConflict(startTimes, endTimes, schedule, 'J', startTimes[i], endTimes[i]) == -1) {
                schedule += 'J';
            } else {
                schedule = swapRoles(startTimes, endTimes, schedule, findConflict(startTimes, endTimes, schedule, 'J', startTimes[i], endTimes[i]));
                schedule += 'J';
            }
        }
        
        return schedule;
    }

    public static boolean hasImpossibleSchedule(int n, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (hasTimeConflict(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            if (hasTimeConflict(startTimes[k], endTimes[k], startTimes[i], endTimes[i]) && 
                                hasTimeConflict(startTimes[k], endTimes[k], startTimes[j], endTimes[j])) {
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

    public static boolean hasTimeConflict(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }

    public static String swapRoles(int[] startTimes, int[] endTimes, String schedule, int index) {
        StringBuilder newSchedule = new StringBuilder(schedule.substring(0, index));
        newSchedule.append(schedule.charAt(index) == 'C' ? 'J' : 'C');
        newSchedule.append(schedule.substring(index + 1));
        return newSchedule.toString();
    }
}