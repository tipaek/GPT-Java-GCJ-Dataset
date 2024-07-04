import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int numberOfTasks = scanner.nextInt();
            Integer[][] tasks = new Integer[numberOfTasks][2];

            for (int j = 0; j < numberOfTasks; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
            }

            results.add("Case #" + (i + 1) + ": " + assignTasks(tasks));
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String assignTasks(Integer[][] tasks) {
        StringBuilder assignment = new StringBuilder();
        Map<Integer, Integer> jSchedule = new HashMap<>();
        Map<Integer, Integer> cSchedule = new HashMap<>();

        for (Integer[] task : tasks) {
            int start = task[0];
            int end = task[1];

            if (isAvailable(jSchedule, start, end)) {
                assignment.append("J");
            } else if (isAvailable(cSchedule, start, end)) {
                assignment.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return assignment.toString();
    }

    private static boolean isAvailable(Map<Integer, Integer> schedule, int start, int end) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            if (!(end <= entry.getKey() || start >= entry.getValue())) {
                return false;
            }
        }
        schedule.put(start, end);
        return true;
    }
}