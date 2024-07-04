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

        boolean isImpossible = false;

        for (Task task : tasks) {
            try {
                task.assign();
            } catch (IllegalStateException e) {
                task.unassign();
                isImpossible = true;
                break;
            } catch (UnsupportedOperationException e) {
                System.out.print(" IMPOSSIBLE");
                isImpossible = true;
                break;
            }
        }

        if (!isImpossible) {
            String result = tasks.stream()
                    .sorted((t1, t2) -> Integer.compare(t1.id, t2.id))
                    .map(t -> t.assignee)
                    .collect(Collectors.joining());
            System.out.print(" " + result);
        } else {
            System.out.print(" IMPOSSIBLE");
        }
    }

    private boolean canAssignTo(Task task, List<Task> taskList) {
        return taskList.isEmpty() || taskList.get(taskList.size() - 1).end <= task.start;
    }

    class Task implements Comparable<Task> {
        int id, start, end;
        String assignee;
        int tries = 0;

        Task(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        public void assign() {
            tries++;
            if (tries > 30) throw new UnsupportedOperationException();

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

        public void unassign() {
            assignee = null;
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(this.end, o.end);
        }

        @Override
        public String toString() {
            return String.format("Task [id=%d, start=%d, end=%d, assignee=%s]", id, start, end, assignee);
        }
    }
}