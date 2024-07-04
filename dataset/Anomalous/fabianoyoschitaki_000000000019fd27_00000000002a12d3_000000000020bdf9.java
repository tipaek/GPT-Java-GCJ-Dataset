import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numTests = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < numTests; i++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][2];

            for (int j = 0; j < numTasks; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
            }

            results.add("Case #" + (i + 1) + ": " + assignTasks(tasks));
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String assignTasks(int[][] tasks) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Integer> cSchedule = new HashMap<>();
        Map<Integer, Integer> jSchedule = new HashMap<>();

        for (int[] task : tasks) {
            int start = task[0];
            int end = task[1];
            int cFree = checkAvailability(cSchedule, start, end);
            int jFree = checkAvailability(jSchedule, start, end);

            if (cFree < 0 && jFree < 0) {
                return "IMPOSSIBLE";
            } else if (cFree >= 0 && (jFree < 0 || cFree <= jFree)) {
                result.append("C");
                cSchedule.put(start, end);
            } else {
                result.append("J");
                jSchedule.put(start, end);
            }
        }

        return result.toString();
    }

    private static int checkAvailability(Map<Integer, Integer> schedule, int start, int end) {
        int minDistance = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int scheduledStart = entry.getKey();
            int scheduledEnd = entry.getValue();

            if (end <= scheduledStart || start >= scheduledEnd) {
                if (end <= scheduledStart) {
                    minDistance = Math.min(scheduledStart - end, minDistance);
                } else {
                    minDistance = Math.min(start - scheduledEnd, minDistance);
                }
            } else {
                return -1;
            }
        }

        return minDistance;
    }
}