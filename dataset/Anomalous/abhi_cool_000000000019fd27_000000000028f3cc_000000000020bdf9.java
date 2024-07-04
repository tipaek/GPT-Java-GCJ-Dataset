import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int noOfTestCases;
    private static List<Integer> listOfTasks = new ArrayList<>();
    private static List<List<Task>> tasksList = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();
        solution.processTasks();
    }

    private void processTasks() {
        List<Task> cTasks = new ArrayList<>();
        List<Task> jTasks = new ArrayList<>();

        for (int i = 0; i < noOfTestCases; i++) {
            String output = "";
            cTasks.clear();
            jTasks.clear();

            List<Task> tasks = tasksList.get(i);

            for (Task task : tasks) {
                boolean isCFree = assignTask(task, cTasks);

                if (!isCFree) {
                    boolean isJFree = assignTask(task, jTasks);

                    if (!isJFree) {
                        output = "IMPOSSIBLE";
                        break;
                    } else {
                        output += "J";
                    }
                } else {
                    output += "C";
                }
            }

            System.out.printf("Case #%d: %s%n", i + 1, output);
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

    private class Task implements Comparable<Task> {
        int start;
        int end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return "Task{" + "start=" + start + ", end=" + end + '}';
        }
    }

    private void readInput() {
        Scanner scanner = new Scanner(System.in);
        noOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < noOfTestCases; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            listOfTasks.add(n);

            List<Task> tasks = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                tasks.add(new Task(start, end));
            }

            tasksList.add(tasks);
        }
    }
}