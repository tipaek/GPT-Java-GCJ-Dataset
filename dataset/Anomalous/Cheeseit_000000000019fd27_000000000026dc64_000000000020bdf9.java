import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int numberTasks = scanner.nextInt();
            scanner.nextLine();
            String[] tasks = new String[numberTasks];
            
            for (int j = 0; j < numberTasks; j++) {
                tasks[j] = scanner.nextLine();
            }
            
            processTestCase(i + 1, tasks);
        }
        
        scanner.close();
    }

    private static void processTestCase(int testCaseNumber, String[] tasks) {
        String result = determineTaskAssignment(tasks);
        System.out.printf("Case #%d: %s\n", testCaseNumber, result);
    }

    private static String determineTaskAssignment(String[] tasks) {
        List<Task> taskList = new ArrayList<>();

        for (String task : tasks) {
            String[] parts = task.split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            taskList.add(new Task(start, end));
        }

        taskList.sort(Comparator.comparingInt(task -> task.start));

        return assignTasks(taskList);
    }

    private static String assignTasks(List<Task> tasks) {
        int cEnd = 0, jEnd = 0;
        StringBuilder schedule = new StringBuilder();

        for (Task task : tasks) {
            if (task.start >= cEnd) {
                schedule.append("C");
                cEnd = task.end;
            } else if (task.start >= jEnd) {
                schedule.append("J");
                jEnd = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static class Task {
        int start, end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}