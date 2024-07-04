import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int noOfTestCases = 0;
    private static final List<Integer> listOfTasks = new ArrayList<>();
    private static final List<List<Task>> tasksList = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();

        for (int i = 0; i < noOfTestCases; i++) {
            String output = assignTasks(tasksList.get(i));
            System.out.printf("Case #%d: %s%n", i + 1, output);
        }
    }

    private static String assignTasks(List<Task> tasks) {
        List<Task> cTasks = new ArrayList<>();
        List<Task> jTasks = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        for (Task task : tasks) {
            if (assignTask(task, cTasks)) {
                output.append("C");
            } else if (assignTask(task, jTasks)) {
                output.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return output.toString();
    }

    private static boolean assignTask(Task task, List<Task> tasks) {
        for (Task t : tasks) {
            if (task.conflictsWith(t)) {
                return false;
            }
        }
        tasks.add(task);
        return true;
    }

    private static class Task implements Comparable<Task> {
        int start;
        int end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean conflictsWith(Task other) {
            return (this.start < other.end && this.end > other.start);
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare((other.end - other.start), (this.end - this.start));
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