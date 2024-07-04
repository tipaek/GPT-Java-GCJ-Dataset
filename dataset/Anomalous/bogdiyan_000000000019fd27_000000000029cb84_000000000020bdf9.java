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
            List<Task> originalTasks = new ArrayList<>();
            for (int i = 0; i < numberOfTasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Task task = new Task(start, end);
                tasks.add(task);
                originalTasks.add(task);
            }

            tasks.sort(Comparator.comparingInt(Task::getStart));

            List<Task> cTasks = new ArrayList<>();
            List<Task> jTasks = new ArrayList<>();
            String[] result = new String[numberOfTasks];
            boolean possible = true;

            for (Task task : tasks) {
                if (canAssignTask(cTasks, task)) {
                    cTasks.add(task);
                    result[originalTasks.indexOf(task)] = "C";
                } else if (canAssignTask(jTasks, task)) {
                    jTasks.add(task);
                    result[originalTasks.indexOf(task)] = "J";
                } else {
                    possible = false;
                    break;
                }
            }

            output.append("Case #").append(testCase).append(": ")
                  .append(possible ? String.join("", result) : "IMPOSSIBLE")
                  .append(testCase < testCases ? "\n" : "");
        }

        System.out.print(output);
    }

    private static boolean canAssignTask(List<Task> tasks, Task task) {
        return tasks.stream().allMatch(t -> task.getEnd() <= t.getStart() || task.getStart() >= t.getEnd());
    }
}