import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    private final Scanner scanner;
    private List<Task> tasks;
    private final List<Task> cameronTasks = new ArrayList<>();
    private final List<Task> jamieTasks = new ArrayList<>();

    public Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Solution solution = new Solution(scanner);
            int testCases = scanner.nextInt();
            for (int tc = 1; tc <= testCases; tc++) {
                solution.processInput();
                System.out.printf("Case #%d:", tc);
                solution.solve();
                System.out.println();
            }
        }
    }

    private void processInput() {
        tasks = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(i + 1, scanner.nextInt(), scanner.nextInt()));
        }
    }

    private void solve() {
        Collections.sort(tasks);
        cameronTasks.clear();
        jamieTasks.clear();

        boolean impossible = false;

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            try {
                task.assign();
            } catch (IllegalStateException | UnsupportedOperationException e) {
                System.out.print(" IMPOSSIBLE");
                impossible = true;
                break;
            }
        }

        if (!impossible) {
            List<String> result = tasks.stream()
                    .sorted((t1, t2) -> Integer.compare(t1.id, t2.id))
                    .map(t -> t.assignee)
                    .collect(Collectors.toList());
            System.out.print(" " + String.join("", result));
        }
    }

    private boolean canAssignTo(Task task, List<Task> taskList) {
        return taskList.isEmpty() || taskList.get(taskList.size() - 1).end <= task.start;
    }

    private class Task implements Comparable<Task> {
        final int id;
        final int start;
        final int end;
        String assignee;
        int tries = 0;

        Task(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        void assign() {
            tries++;
            if (tries > 1000) throw new UnsupportedOperationException();
            if (assignee == null && canAssignTo(this, cameronTasks)) {
                assignee = "C";
                cameronTasks.add(this);
            } else if (assignee == null && canAssignTo(this, jamieTasks)) {
                assignee = "J";
                jamieTasks.add(this);
            } else {
                throw new IllegalStateException();
            }
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.end, other.end);
        }

        @Override
        public String toString() {
            return String.format("Task [id=%d, start=%d, end=%d, assignee=%s]", id, start, end, assignee);
        }
    }
}