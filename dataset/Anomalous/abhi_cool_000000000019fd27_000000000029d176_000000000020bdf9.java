import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int noOfTestCases;
    private static List<Integer> listOfTasks = new ArrayList<>();
    private static List<List<Task>> tasksList = new ArrayList<>();

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
            boolean isCTurn = true;

            for (Task task : tasks) {
                boolean isCFree = isCTurn && assignTask(task, cTasks);

                if (!isCFree) {
                    boolean isJFree = assignTask(task, jTasks);

                    if (!isJFree) {
                        isCFree = assignTask(task, cTasks);

                        if (!isCFree) {
                            output = new StringBuilder("IMPOSSIBLE");
                            break;
                        } else {
                            output.append("C");
                            isCTurn = false;
                        }
                    } else {
                        output.append("J");
                        isCTurn = true;
                    }
                } else {
                    output.append("C");
                    isCTurn = false;
                }
            }

            System.out.printf("Case #%d: %s%n", i + 1, output.toString());
        }
    }

    private static boolean assignTask(Task task, List<Task> tasks) {
        for (Task t : tasks) {
            if ((task.end <= t.end && task.end > t.start)
                    || (task.start < t.end && task.start >= t.start)
                    || (task.end == t.end && task.start == t.start)
                    || (task.start == t.start)
                    || (task.end == t.end)
                    || (t.end <= task.end && t.start >= task.start)) {
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
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
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

            Collections.sort(tasks);
            tasksList.add(tasks);
        }
    }
}