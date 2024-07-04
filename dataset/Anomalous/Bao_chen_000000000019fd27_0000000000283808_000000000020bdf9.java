import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int activities = scanner.nextInt();
            int[][] intervals = new int[activities][2];
            for (int j = 0; j < activities; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            processTestCase(intervals, i);
        }
    }
  
    private static boolean canAssignToCameron(int[] interval, int start, int end) {
        if (cameronSchedule.isEmpty()) {
            cameronSchedule.add(interval);
            return true;
        }

        if (cameronSchedule.size() == 1) {
            int[] existingInterval = cameronSchedule.get(0);
            if (start >= existingInterval[1] || end <= existingInterval[0]) {
                cameronSchedule.add(start >= existingInterval[1] ? interval : 0, interval);
                return true;
            }
            return false;
        }

        if (cameronSchedule.get(0)[0] >= end) {
            cameronSchedule.add(0, interval);
            return true;
        }
        if (cameronSchedule.get(cameronSchedule.size() - 1)[1] <= start) {
            cameronSchedule.add(interval);
            return true;
        }

        for (int i = 0; i < cameronSchedule.size() - 1; i++) {
            if (start >= cameronSchedule.get(i)[1] && end <= cameronSchedule.get(i + 1)[0]) {
                cameronSchedule.add(i + 1, interval);
                return true;
            }
        }
        return false;
    }

    private static boolean canAssignToJamie(int[] interval, int start, int end) {
        if (jamieSchedule.isEmpty()) {
            jamieSchedule.add(interval);
            return true;
        }

        if (jamieSchedule.size() == 1) {
            int[] existingInterval = jamieSchedule.get(0);
            if (start >= existingInterval[1] || end <= existingInterval[0]) {
                jamieSchedule.add(start >= existingInterval[1] ? interval : 0, interval);
                return true;
            }
            return false;
        }

        if (jamieSchedule.get(0)[0] >= end) {
            jamieSchedule.add(0, interval);
            return true;
        }
        if (jamieSchedule.get(jamieSchedule.size() - 1)[1] <= start) {
            jamieSchedule.add(interval);
            return true;
        }

        for (int i = 0; i < jamieSchedule.size() - 1; i++) {
            if (start >= jamieSchedule.get(i)[1] && end <= jamieSchedule.get(i + 1)[0]) {
                jamieSchedule.add(i + 1, interval);
                return true;
            }
        }
        return false;
    }

    static List<int[]> cameronSchedule = new ArrayList<>();
    static List<int[]> jamieSchedule = new ArrayList<>();

    private static void processTestCase(int[][] intervals, int caseNumber) {
        cameronSchedule.clear();
        jamieSchedule.clear();
        StringBuilder result = new StringBuilder();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (canAssignToJamie(interval, start, end)) {
                result.append("J");
            } else if (canAssignToCameron(interval, start, end)) {
                result.append("C");
            } else {
                result.setLength(0);
                result.append("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}