import java.util.*;
import java.io.*;

public class Solution {
    private static List<String> results = new ArrayList<>();
    private static Map<Integer, Integer> cameronSchedule = new HashMap<>();
    private static Map<Integer, Integer> jamieSchedule = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int activityCount = Integer.parseInt(scanner.nextLine());
            int[][] activities = new int[activityCount][2];
            for (int i = 0; i < activityCount; i++) {
                String[] input = scanner.nextLine().split(" ");
                activities[i][0] = Integer.parseInt(input[0]);
                activities[i][1] = Integer.parseInt(input[1]);
            }

            results = new ArrayList<>();
            cameronSchedule = new HashMap<>();
            jamieSchedule = new HashMap<>();

            if (isSchedulingPossible(activities)) {
                findSchedules(activities, new StringBuilder(), 0);
                System.out.println("Case #" + caseNumber + ": " + results.get(0));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isSchedulingPossible(int[][] activities) {
        int[] timeSlots = new int[1441];
        for (int[] activity : activities) {
            for (int time = activity[0] + 1; time <= activity[1]; time++) {
                timeSlots[time]++;
                if (timeSlots[time] > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void findSchedules(int[][] activities, StringBuilder schedule, int index) {
        if (index == activities.length) {
            results.add(schedule.toString());
        } else {
            for (int i = index; i < activities.length; i++) {
                if (!isOverlapping(activities[i], cameronSchedule)) {
                    cameronSchedule.put(activities[i][0], activities[i][1]);
                    schedule.append("C");
                    findSchedules(activities, schedule, index + 1);
                    cameronSchedule.remove(activities[i][0]);
                    schedule.deleteCharAt(schedule.length() - 1);
                }
                if (!isOverlapping(activities[i], jamieSchedule)) {
                    jamieSchedule.put(activities[i][0], activities[i][1]);
                    schedule.append("J");
                    findSchedules(activities, schedule, index + 1);
                    jamieSchedule.remove(activities[i][0]);
                    schedule.deleteCharAt(schedule.length() - 1);
                }
            }
        }
    }

    private static boolean isOverlapping(int[] activity, Map<Integer, Integer> schedule) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            if (Math.max(entry.getKey(), activity[0]) < Math.min(entry.getValue(), activity[1])) {
                return true;
            }
        }
        return false;
    }
}