import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numberOfCases];

        for (int i = 0; i < numberOfCases; i++) {
            results[i] = "Case #" + (i + 1) + ": " + scheduleActivities(scanner);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    public static String scheduleActivities(Scanner scanner) {
        int numActivities = Integer.parseInt(scanner.nextLine());
        String[] activities = new String[numActivities];
        List<int[]> cameronJobs = new ArrayList<>();
        List<int[]> jamieJobs = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < numActivities; i++) {
            activities[i] = scanner.nextLine();
        }

        for (String activity : activities) {
            String[] times = activity.split(" ");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);

            boolean cameronBusy = isBusy(cameronJobs, startTime, endTime);
            boolean jamieBusy = isBusy(jamieJobs, startTime, endTime);

            if (cameronBusy && jamieBusy) {
                return "IMPOSSIBLE";
            } else if (!cameronBusy) {
                cameronJobs.add(new int[]{startTime, endTime});
                schedule.append("C");
            } else {
                jamieJobs.add(new int[]{startTime, endTime});
                schedule.append("J");
            }
        }

        return schedule.toString();
    }

    private static boolean isBusy(List<int[]> jobs, int startTime, int endTime) {
        for (int[] job : jobs) {
            if ((startTime >= job[0] && startTime < job[1]) || (endTime > job[0] && endTime <= job[1])) {
                return true;
            }
        }
        return false;
    }
}