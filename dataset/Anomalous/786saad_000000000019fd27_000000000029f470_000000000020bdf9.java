import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numberOfCases];

        for (int i = 0; i < numberOfCases; i++) {
            results[i] = "Case #" + (i + 1) + ": " + processCase(scanner);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String processCase(Scanner scanner) {
        int numActivities = Integer.parseInt(scanner.nextLine());
        String[] activities = new String[numActivities];

        for (int i = 0; i < numActivities; i++) {
            activities[i] = scanner.nextLine();
        }

        return scheduleActivities(activities);
    }

    private static String scheduleActivities(String[] activities) {
        List<int[]> cameronJobs = new ArrayList<>();
        List<int[]> jamieJobs = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (String activity : activities) {
            String[] times = activity.split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            if (isAvailable(cameronJobs, start, end)) {
                cameronJobs.add(new int[]{start, end});
                schedule.append("C");
            } else if (isAvailable(jamieJobs, start, end)) {
                jamieJobs.add(new int[]{start, end});
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean isAvailable(List<int[]> jobs, int start, int end) {
        for (int[] job : jobs) {
            if (start < job[1] && end > job[0]) {
                return false;
            }
        }
        return true;
    }
}