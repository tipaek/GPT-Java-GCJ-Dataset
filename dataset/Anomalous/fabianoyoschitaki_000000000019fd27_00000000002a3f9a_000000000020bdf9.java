import java.util.*;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scan.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int tasksCount = scan.nextInt();
            Integer[][] tasks = new Integer[tasksCount][2];
            for (int j = 0; j < tasksCount; j++) {
                tasks[j][0] = scan.nextInt();
                tasks[j][1] = scan.nextInt();
            }
            results.add("Case #" + (i + 1) + ": " + assignTasks(tasks));
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String assignTasks(Integer[][] tasks) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Integer> jSchedule = new HashMap<>();
        Map<Integer, Integer> cSchedule = new HashMap<>();
        Integer[][] sortedTasks = Arrays.copyOf(tasks, tasks.length);

        Arrays.sort(sortedTasks, (task1, task2) -> {
            if (task1[0].equals(task2[0])) {
                return (task2[1] - task2[0]) - (task1[1] - task1[0]);
            } else {
                return task1[0] - task2[0];
            }
        });

        Map<Integer[], String> taskAssignments = new HashMap<>();

        for (Integer[] task : sortedTasks) {
            int start = task[0];
            int end = task[1];
            int cAvailability = checkAvailability(cSchedule, start, end);
            int jAvailability = checkAvailability(jSchedule, start, end);

            if (cAvailability < 0 && jAvailability < 0) {
                return "IMPOSSIBLE";
            } else if (jAvailability >= 0 && (cAvailability < 0 || jAvailability <= cAvailability)) {
                taskAssignments.put(task, "J");
                jSchedule.put(start, end);
            } else {
                taskAssignments.put(task, "C");
                cSchedule.put(start, end);
            }
        }

        for (Integer[] task : tasks) {
            result.append(taskAssignments.get(task));
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
                    minDistance = Math.min(minDistance, scheduledStart - end);
                } else {
                    minDistance = Math.min(minDistance, start - scheduledEnd);
                }
            } else {
                return -1;
            }
        }

        return minDistance;
    }
}