import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int numberOfTasks = scanner.nextInt();
            scanner.nextLine();
            String[] tasks = new String[numberOfTasks];
            for (int j = 0; j < numberOfTasks; j++) {
                tasks[j] = scanner.nextLine();
            }
            printSolution(i + 1, tasks);
        }
        scanner.close();
    }

    private static void printSolution(int testCaseNumber, String[] tasks) {
        String result = calculate(tasks);
        System.out.printf("Case #%d: %s%n", testCaseNumber, result);
    }

    private static String calculate(String[] tasks) {
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            String[] parts = tasks[i].split(" ");
            taskList.add(new Task(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), i));
        }
        List<Task> sortedTaskList = taskList.stream()
                                            .sorted(Comparator.comparingInt(task -> task.start))
                                            .collect(Collectors.toList());
        return assignTasks(sortedTaskList);
    }

    private static String assignTasks(List<Task> sortedTaskList) {
        int cEndTime = 0;
        int jEndTime = 0;
        for (Task task : sortedTaskList) {
            if (cEndTime <= task.start) {
                task.executor = "C";
                cEndTime = task.end;
            } else if (jEndTime <= task.start) {
                task.executor = "J";
                jEndTime = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return sortedTaskList.stream()
                             .sorted(Comparator.comparingInt(task -> task.taskNumber))
                             .map(task -> task.executor)
                             .collect(Collectors.joining(""));
    }

    private static class Task {
        int start;
        int end;
        int taskNumber;
        String executor;

        Task(int start, int end, int taskNumber) {
            this.start = start;
            this.end = end;
            this.taskNumber = taskNumber;
        }
    }
}