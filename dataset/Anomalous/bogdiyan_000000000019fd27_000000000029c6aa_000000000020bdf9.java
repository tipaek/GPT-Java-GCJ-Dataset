import java.util.*;

public class Solution {

    private static class Task {
        private final int start;
        private final int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfTasks = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < numberOfTasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end));
            }

            List<Task> cTasks = new ArrayList<>();
            List<Task> jTasks = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean hasSolution = true;

            for (Task task : tasks) {
                if (canAssignTask(cTasks, task)) {
                    cTasks.add(task);
                    result.append("C");
                } else if (canAssignTask(jTasks, task)) {
                    jTasks.add(task);
                    result.append("J");
                } else {
                    hasSolution = false;
                    break;
                }
            }

            output.append("Case #").append(testCase).append(": ")
                  .append(hasSolution ? result.toString() : "IMPOSSIBLE")
                  .append("\n");
        }

        System.out.print(output.toString());
    }

    private static boolean canAssignTask(List<Task> tasks, Task task) {
        for (Task t : tasks) {
            if (!(task.getEnd() <= t.getStart() || task.getStart() >= t.getEnd())) {
                return false;
            }
        }
        return true;
    }
}