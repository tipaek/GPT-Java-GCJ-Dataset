import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            assignActivities(activities, caseNum);
        }
    }

    private static boolean canAssign(Set<int[]> schedule, int start, int end) {
        if (schedule.isEmpty()) {
            return true;
        } else if (schedule.size() == 1) {
            int[] existing = schedule.iterator().next();
            return start >= existing[1] || end <= existing[0];
        }

        int left = -1, right = 3601, minStart = Integer.MAX_VALUE, maxEnd = Integer.MIN_VALUE;
        for (int[] slot : schedule) {
            minStart = Math.min(minStart, slot[0]);
            maxEnd = Math.max(maxEnd, slot[1]);
            if (start >= slot[1]) {
                left = Math.max(left, slot[1]);
            }
            if (end <= slot[0]) {
                right = Math.min(right, slot[0]);
            }
        }

        if (left >= 0 && right == 3601 && end <= maxEnd) {
            return true;
        } else if (right <= 3600 && left < 0 && start >= minStart) {
            return true;
        }
        return left >= 0 && right <= 3600;
    }

    private static void assignActivities(int[][] activities, int caseNum) {
        Set<int[]> scheduleJ = new HashSet<>();
        Set<int[]> scheduleC = new HashSet<>();
        StringBuilder result = new StringBuilder();
        
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            if (canAssign(scheduleJ, start, end)) {
                scheduleJ.add(activity);
                result.append("J");
            } else if (canAssign(scheduleC, start, end)) {
                scheduleC.add(activity);
                result.append("C");
            } else {
                result.setLength(0);
                result.append("IMPOSSIBLE");
                break;
            }
        }
        
        System.out.println("Case #" + caseNum + ": " + result.toString());
    }
}