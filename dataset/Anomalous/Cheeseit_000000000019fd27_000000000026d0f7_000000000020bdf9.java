import java.util.*;

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

    public static void printSolution(int testCaseNumber, String[] tasks) {
        System.out.println(calculate(tasks));
    }

    public static String calculate(String[] tasks) {
        List<Task> taskList = new ArrayList<>();
        for (String task : tasks) {
            String[] parts = task.split(" ");
            taskList.add(new Task(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
        }
        taskList.sort(Comparator.comparingInt(t -> t.begin));
        return assignTasks(taskList);
    }

    public static String assignTasks(List<Task> sortedTaskList) {
        int cEnd = 0;
        int jEnd = 0;
        StringBuilder schedule = new StringBuilder();
        for (Task task : sortedTaskList) {
            if (cEnd <= task.begin) {
                schedule.append("C");
                cEnd = task.end;
            } else if (jEnd <= task.begin) {
                schedule.append("J");
                jEnd = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    public static class Task {
        int begin;
        int end;

        public Task(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}