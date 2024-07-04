import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        String[] outputs = new String[numberOfCases];

        for (int i = 0; i < numberOfCases; i++) {
            outputs[i] = "Case #" + (i + 1) + ": " + processCase(scanner);
        }

        for (String output : outputs) {
            System.out.println(output);
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
        StringBuilder output = new StringBuilder();

        for (String activity : activities) {
            int[] times = parseTimes(activity);
            int startingTime = times[0];
            int endingTime = times[1];

            if (canTakeJob(cameronJobs, startingTime, endingTime)) {
                cameronJobs.add(times);
                output.append("C");
            } else if (canTakeJob(jamieJobs, startingTime, endingTime)) {
                jamieJobs.add(times);
                output.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return output.toString();
    }

    private static int[] parseTimes(String activity) {
        String[] parts = activity.split(" ");
        int startingTime = Integer.parseInt(parts[0]);
        int endingTime = Integer.parseInt(parts[1]);
        return new int[]{startingTime, endingTime};
    }

    private static boolean canTakeJob(List<int[]> jobs, int start, int end) {
        for (int[] job : jobs) {
            if (isOverlapping(job, start, end)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(int[] job, int start, int end) {
        return !(end <= job[0] || start >= job[1]);
    }
}