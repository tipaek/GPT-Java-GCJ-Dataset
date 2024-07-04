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
            
            handleTestCase(i + 1, tasks);
        }
        
        scanner.close();
    }

    private static void handleTestCase(int testCaseNumber, String[] tasks) {
        String result = assignExecutors(tasks);
        System.out.printf("Case #%d: %s%n", testCaseNumber, result);
    }

    private static String assignExecutors(String[] tasks) {
        List<Task> taskList = Arrays.stream(tasks)
                                    .map(Task::new)
                                    .sorted(Comparator.comparingInt(task -> task.start))
                                    .collect(Collectors.toList());
        
        return assignTasksToExecutors(taskList);
    }

    private static String assignTasksToExecutors(List<Task> sortedTaskList) {
        int endC = 0, endJ = 0;
        
        for (Task task : sortedTaskList) {
            if (endC <= task.start) {
                task.executor = "C";
                endC = task.end;
            } else if (endJ <= task.start) {
                task.executor = "J";
                endJ = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return sortedTaskList.stream()
                             .sorted(Comparator.comparingInt(task -> task.index))
                             .map(task -> task.executor)
                             .collect(Collectors.joining());
    }

    private static class Task {
        int start;
        int end;
        int index;
        String executor;

        Task(String taskDescription) {
            String[] parts = taskDescription.split(" ");
            this.start = Integer.parseInt(parts[0]);
            this.end = Integer.parseInt(parts[1]);
            this.index = TaskCounter.getNextIndex();
        }
    }

    private static class TaskCounter {
        private static int currentIndex = 0;

        static int getNextIndex() {
            return currentIndex++;
        }
    }
}