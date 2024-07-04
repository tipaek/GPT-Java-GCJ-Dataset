import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfTests = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int numberOfTasks = scanner.nextInt();
            Integer[][] tasks = new Integer[numberOfTasks][2];

            for (int taskIndex = 0; taskIndex < numberOfTasks; taskIndex++) {
                tasks[taskIndex][0] = scanner.nextInt();
                tasks[taskIndex][1] = scanner.nextInt();
            }

            results.add("Case #" + (testIndex + 1) + ": " + assignTasks(tasks));
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String assignTasks(Integer[][] tasks) {
        StringBuilder assignmentResult = new StringBuilder();
        Map<Integer, Integer> cameronSchedule = new HashMap<>();
        Map<Integer, Integer> jamieSchedule = new HashMap<>();

        for (Integer[] task : tasks) {
            int start = task[0];
            int end = task[1];
            int cameronAvailability = checkAvailability(cameronSchedule, start, end);
            int jamieAvailability = checkAvailability(jamieSchedule, start, end);

            if (cameronAvailability < 0 && jamieAvailability < 0) {
                return "IMPOSSIBLE";
            } else if (jamieAvailability != -1 && (cameronAvailability < 0 || jamieAvailability <= cameronAvailability)) {
                assignmentResult.append("J");
                jamieSchedule.put(start, end);
            } else {
                assignmentResult.append("C");
                cameronSchedule.put(start, end);
            }
        }

        return assignmentResult.toString();
    }

    private static int checkAvailability(Map<Integer, Integer> schedule, int start, int end) {
        int minimumDistance = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int scheduledStart = entry.getKey();
            int scheduledEnd = entry.getValue();

            if (!(end <= scheduledStart || start >= scheduledEnd)) {
                return -1;
            } else {
                if (end <= scheduledStart) {
                    minimumDistance = Math.min(scheduledStart - end, minimumDistance);
                } else {
                    minimumDistance = Math.min(start - scheduledEnd, minimumDistance);
                }
            }
        }

        return minimumDistance;
    }
}