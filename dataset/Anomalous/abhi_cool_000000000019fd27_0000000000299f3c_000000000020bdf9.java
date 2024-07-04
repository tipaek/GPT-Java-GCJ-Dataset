import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int numberOfTestCases;
    private static List<Integer> taskCounts = new ArrayList<>();
    private static List<List<Task>> allTasks = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();

        List<Task> cTasks = new ArrayList<>();
        List<Task> jTasks = new ArrayList<>();

        for (int i = 0; i < numberOfTestCases; i++) {
            String result = "";
            cTasks.clear();
            jTasks.clear();

            List<Task> tasks = allTasks.get(i);

            for (Task task : tasks) {
                if (assignTask(task, cTasks)) {
                    result += "C";
                } else if (assignTask(task, jTasks)) {
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.printf("Case #%d: %s%n", i + 1, result);
        }
    }

    private static boolean assignTask(Task task, List<Task> tasks) {
        for (Task existingTask : tasks) {
            if (tasksOverlap(task, existingTask)) {
                return false;
            }
        }
        tasks.add(task);
        return true;
    }

    private static boolean tasksOverlap(Task task1, Task task2) {
        return (task1.start < task2.end && task1.end > task2.start);
    }

    private void readInput() {
        Scanner scanner = new Scanner(System.in);
        numberOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            int taskCount = Integer.parseInt(scanner.nextLine());
            taskCounts.add(taskCount);

            List<Task> tasks = new ArrayList<>(taskCount);

            for (int j = 0; j < taskCount; j++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                tasks.add(new Task(start, end));
            }

            Collections.sort(tasks);
            allTasks.add(tasks);
        }
    }

    private static class Task implements Comparable<Task> {
        int start;
        int end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Task{" + "start=" + start + ", end=" + end + '}';
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }
}