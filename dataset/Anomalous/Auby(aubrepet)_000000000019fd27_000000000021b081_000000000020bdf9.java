import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner in;

    private void run() {
        in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        for (int i = 0; i < tests; i++) {
            List<Task> tasks = readTasks();
            String result = processTestcase(tasks);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private String processTestcase(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(Task::getFrom));

        int cEnd = 0, jEnd = 0;
        for (Task task : tasks) {
            if (cEnd <= task.getFrom()) {
                task.setOwner('C');
                cEnd = task.getTo();
            } else if (jEnd <= task.getFrom()) {
                task.setOwner('J');
                jEnd = task.getTo();
            } else {
                return "IMPOSSIBLE";
            }
        }

        tasks.sort(Comparator.comparingInt(Task::getPosition));
        StringBuilder result = new StringBuilder();
        for (Task task : tasks) {
            result.append(task.getOwner());
        }
        return result.toString();
    }

    private List<Task> readTasks() {
        int taskCount = in.nextInt();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < taskCount; i++) {
            tasks.add(new Task(i, in.nextInt(), in.nextInt()));
        }
        return tasks;
    }

    private static class Task {
        private final int position;
        private final int from;
        private final int to;
        private char owner;

        public Task(int position, int from, int to) {
            this.position = position;
            this.from = from;
            this.to = to;
        }

        public int getPosition() {
            return position;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public char getOwner() {
            return owner;
        }

        public void setOwner(char owner) {
            this.owner = owner;
        }
    }
}