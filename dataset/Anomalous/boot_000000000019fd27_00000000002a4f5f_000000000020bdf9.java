import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    private Scanner scanner;
    private List<Task> tasks;

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

    void processInput() {
        tasks = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(i + 1, scanner.nextInt(), scanner.nextInt()));
        }
    }

    private List<Task> cameronTasks = new ArrayList<>();
    private List<Task> jamieTasks = new ArrayList<>();

    void solve() {
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
            String result = tasks.stream()
                                 .sorted((o1, o2) -> o1.id - o2.id)
                                 .map(task -> task.assignee)
                                 .collect(Collectors.joining(""));
            System.out.print(" " + result);
        }
    }

    private boolean canAssignTo(Task task, List<Task> taskList) {
        return taskList.isEmpty() || taskList.get(taskList.size() - 1).end <= task.start;
    }

    class Task implements Comparable<Task> {
        int id, start, end;
        String assignee;
        private int tries = 0;
        private List<Task> ref;

        Task(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        void assign() {
            if (++tries > 1000) throw new UnsupportedOperationException();
            if ((assignee == null || "J".equals(assignee)) && canAssignTo(this, cameronTasks)) {
                assignee = "C";
                cameronTasks.add(this);
                ref = cameronTasks;
            } else if ((assignee == null || "C".equals(assignee)) && canAssignTo(this, jamieTasks)) {
                assignee = "J";
                jamieTasks.add(this);
                ref = jamieTasks;
            } else {
                throw new IllegalStateException();
            }
        }

        void unassign() {
            assignee = null;
            if (ref != null && !ref.isEmpty()) {
                ref.remove(ref.size() - 1);
            }
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return String.format("Task [id=%d, start=%d, end=%d, assignee=%s]", id, start, end, assignee);
        }
    }
}