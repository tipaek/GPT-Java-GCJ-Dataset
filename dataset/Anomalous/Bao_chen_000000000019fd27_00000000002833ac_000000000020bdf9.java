import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            int[][] schedule = new int[activities][2];
            for (int j = 0; j < activities; j++) {
                schedule[j][0] = scanner.nextInt();
                schedule[j][1] = scanner.nextInt();
            }
            processSchedule(schedule, i);
        }
    }

    private static boolean canAssignToC(int[] activity, int start, int end) {
        if (cSchedule.isEmpty()) {
            cSchedule.add(activity);
            return true;
        } else if (cSchedule.size() == 1) {
            int[] existingActivity = cSchedule.get(0);
            if (start >= existingActivity[1] || end <= existingActivity[0]) {
                cSchedule.add(start >= existingActivity[1] ? activity : 0, activity);
                return true;
            } else {
                return false;
            }
        } else {
            if (cSchedule.get(0)[0] >= end) {
                cSchedule.add(0, activity);
                return true;
            }
            if (cSchedule.get(cSchedule.size() - 1)[1] <= start) {
                cSchedule.add(activity);
                return true;
            }
            for (int i = 0; i < cSchedule.size() - 1; i++) {
                if (start >= cSchedule.get(i)[1] && end <= cSchedule.get(i + 1)[0]) {
                    cSchedule.add(i + 1, activity);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean canAssignToJ(int[] activity, int start, int end) {
        if (jSchedule.isEmpty()) {
            jSchedule.add(activity);
            return true;
        } else if (jSchedule.size() == 1) {
            int[] existingActivity = jSchedule.get(0);
            if (start >= existingActivity[1] || end <= existingActivity[0]) {
                jSchedule.add(start >= existingActivity[1] ? activity : 0, activity);
                return true;
            } else {
                return false;
            }
        } else {
            if (jSchedule.get(0)[0] >= end) {
                jSchedule.add(0, activity);
                return true;
            }
            if (jSchedule.get(jSchedule.size() - 1)[1] <= start) {
                jSchedule.add(activity);
                return true;
            }
            for (int i = 0; i < jSchedule.size() - 1; i++) {
                if (start >= jSchedule.get(i)[1] && end <= jSchedule.get(i + 1)[0]) {
                    jSchedule.add(i + 1, activity);
                    return true;
                }
            }
        }
        return false;
    }

    static List<int[]> jSchedule = new ArrayList<>();
    static List<int[]> cSchedule = new ArrayList<>();

    private static void processSchedule(int[][] schedule, int caseNumber) {
        jSchedule.clear();
        cSchedule.clear();
        StringBuilder result = new StringBuilder();
        for (int[] activity : schedule) {
            int start = activity[0];
            int end = activity[1];
            if (canAssignToJ(activity, start, end)) {
                result.append("J");
            } else if (canAssignToC(activity, start, end)) {
                result.append("C");
            } else {
                result.setLength(0);
                result.append("IMPOSSIBLE");
                break;
            }
        }
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}