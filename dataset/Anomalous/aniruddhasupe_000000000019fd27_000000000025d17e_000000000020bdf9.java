import java.io.*;
import java.util.*;

public class Solution {

    public static boolean checkAvailability(List<int[]> schedule, int start, int end, int index) {
        for (int i = index; i < schedule.size(); i++) {
            int[] current = schedule.get(i);
            if ((current[0] <= start && current[1] <= start) || (current[0] >= end && current[1] >= end)) {
                if (i != schedule.size() - 1) {
                    return checkAvailability(schedule, start, end, i + 1);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activities = scanner.nextInt();
            List<int[]> jamieSchedule = new ArrayList<>();
            List<int[]> cameronSchedule = new ArrayList<>();

            jamieSchedule.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            StringBuilder schedule = new StringBuilder("J");

            for (int i = 1; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (checkAvailability(jamieSchedule, start, end, 0)) {
                    jamieSchedule.add(new int[]{start, end});
                    schedule.append("J");
                } else if (cameronSchedule.isEmpty()) {
                    cameronSchedule.add(new int[]{start, end});
                    schedule.append("C");
                } else if (checkAvailability(cameronSchedule, start, end, 0)) {
                    cameronSchedule.add(new int[]{start, end});
                    schedule.append("C");
                }
            }

            if (schedule.length() == activities) {
                System.out.println("Case #" + caseNumber + ": " + schedule);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}