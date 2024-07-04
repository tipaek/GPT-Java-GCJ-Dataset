import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int noOfTestCases;
    private static final List<Integer> listOfTasks = new ArrayList<>();
    private static final List<List<Task>> tasksList = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();

        List<Task> cTasks = new ArrayList<>();
        List<Task> jTasks = new ArrayList<>();

        for (int i = 0; i < noOfTestCases; i++) {
            StringBuilder output = new StringBuilder();
            cTasks.clear();
            jTasks.clear();

            List<Task> tasks = tasksList.get(i);

            for (Task task : tasks) {
                if (assignTask(task, cTasks)) {
                    output.append("C");
                } else if (assignTask(task, jTasks)) {
                    output.append("J");
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.printf("Case #%d: %s%n", i + 1, output);
        }
    }

    private static boolean assignTask(Task task, List<Task> tasks) {
        for (Task t : tasks) {
            if ((task.end > t.start && task.start < t.end)) {
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

        @Override
        public String toString() {
            return "Task{" + "start=" + start + ", end=" + end + '}';
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(this.end - this.start, o.end - o.start);
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