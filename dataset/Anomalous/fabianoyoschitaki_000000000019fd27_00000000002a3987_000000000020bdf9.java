import java.util.*;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scan.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < tests; i++) {
            int tasksSize = scan.nextInt();
            Integer[][] tasks = new Integer[tasksSize][2];

            for (int j = 0; j < tasksSize; j++) {
                tasks[j][0] = scan.nextInt();
                tasks[j][1] = scan.nextInt();
            }

            results.add("Case #" + (i + 1) + ": " + distributeTasks(tasks));
        }

        results.forEach(System.out::println);
    }

    private static String distributeTasks(Integer[][] tasks) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Integer> jCalendar = new HashMap<>();
        Map<Integer, Integer> cCalendar = new HashMap<>();
        Integer[][] sortedTasks = Arrays.copyOf(tasks, tasks.length);

        Arrays.sort(sortedTasks, Comparator.comparingInt(o -> o[1] - o[0]));

        Map<Integer[], List<String>> answers = new HashMap<>();

        for (Integer[] task : sortedTasks) {
            int startTime = task[0];
            int endTime = task[1];
            int cDistance = getFreeTime(cCalendar, startTime, endTime);
            int jDistance = getFreeTime(jCalendar, startTime, endTime);

            if (cDistance < 0 && jDistance < 0) {
                return "IMPOSSIBLE";
            } else if (jDistance != -1 && (cDistance < 0 || jDistance <= cDistance)) {
                answers.computeIfAbsent(task, k -> new ArrayList<>()).add("J");
                jCalendar.put(startTime, endTime);
            } else {
                answers.computeIfAbsent(task, k -> new ArrayList<>()).add("C");
                cCalendar.put(startTime, endTime);
            }
        }

        for (Integer[] task : tasks) {
            result.append(answers.get(task).remove(0));
        }

        return result.toString();
    }

    private static int getFreeTime(Map<Integer, Integer> calendar, int startTime, int endTime) {
        int minDistance = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();

            if (endTime <= start || startTime >= end) {
                minDistance = Math.min(minDistance, Math.min(start - endTime, startTime - end));
            } else {
                return -1;
            }
        }

        return minDistance;
    }
}