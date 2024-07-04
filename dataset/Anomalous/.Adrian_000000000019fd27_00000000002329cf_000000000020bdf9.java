import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCaseCount; i++) {
            int activityCount = scanner.nextInt();
            scanner.nextLine();

            List<List<Integer>> activities = new ArrayList<>();
            for (int j = 0; j < activityCount; j++) {
                activities.add(parseActivity(scanner.nextLine()));
            }

            String result = scheduleActivities(activities);
            if (result == null) result = "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String scheduleActivities(List<List<Integer>> activities) {
        // Sort activities based on their start times
        activities.sort(Comparator.comparingInt(activity -> activity.get(0)));

        StringBuilder schedule = new StringBuilder();
        long cameronEnd = 0;
        long jamieEnd = 0;

        for (List<Integer> activity : activities) {
            int start = activity.get(0);
            int end = activity.get(1);

            if (start >= cameronEnd) {
                cameronEnd = end;
                schedule.append("C");
            } else if (start >= jamieEnd) {
                jamieEnd = end;
                schedule.append("J");
            } else {
                return null;
            }
        }

        return schedule.toString();
    }

    private static List<Integer> parseActivity(String activity) {
        return Arrays.stream(activity.split(" "))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }
}