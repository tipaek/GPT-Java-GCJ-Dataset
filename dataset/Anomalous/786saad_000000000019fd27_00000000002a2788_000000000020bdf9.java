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

        return assignActivities(activities);
    }

    private static String assignActivities(String[] activities) {
        List<int[]> cameronJobs = new ArrayList<>();
        List<int[]> jamieJobs = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (String activity : activities) {
            int spaceIndex = activity.indexOf(" ");
            int startTime = Integer.parseInt(activity.substring(0, spaceIndex));
            int endTime = Integer.parseInt(activity.substring(spaceIndex + 1));

            if (isAvailable(cameronJobs, startTime, endTime)) {
                cameronJobs.add(new int[]{startTime, endTime});
                schedule.append("C");
            } else if (isAvailable(jamieJobs, startTime, endTime)) {
                jamieJobs.add(new int[]{startTime, endTime});
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean isAvailable(List<int[]> jobs, int startTime, int endTime) {
        for (int[] job : jobs) {
            if (startTime < job[1] && endTime > job[0]) {
                return false;
            }
        }
        return true;
    }
}