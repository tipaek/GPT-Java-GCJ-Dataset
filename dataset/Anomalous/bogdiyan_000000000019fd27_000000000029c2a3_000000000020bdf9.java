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
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = sc.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfTasks = sc.nextInt();
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < numberOfTasks; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                tasks.add(new Task(start, end));
            }

            tasks.sort(Comparator.comparingInt(Task::getStart));

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

            output.append("Case #")
                  .append(testCase)
                  .append(": ")
                  .append(hasSolution ? result.toString() : "IMPOSSIBLE")
                  .append(testCase < testCases ? "\n" : "");
        }

        System.out.print(output.toString());
    }

    private static boolean canAssignTask(List<Task> tasks, Task newTask) {
        for (Task task : tasks) {
            if (!(newTask.getEnd() <= task.getStart() || newTask.getStart() >= task.getEnd())) {
                return false;
            }
        }
        return true;
    }
}