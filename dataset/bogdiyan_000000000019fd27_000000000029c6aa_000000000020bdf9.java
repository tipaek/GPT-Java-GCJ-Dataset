import java.util.*;

public class Solution {

    private static class Task {
        Integer start;
        Integer end;

        public Task(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        public Integer getStart() {
            return start;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String out = "";
        int testCases = sc.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int numberOfTasks = sc.nextInt();

            List<Task> tasks = new ArrayList<>();
            for (int c = 0; c < numberOfTasks; c++) {
                int cStart = sc.nextInt();
                int cEnd = sc.nextInt();

                tasks.add(new Task(cStart, cEnd));
            }

            // tasks.sort(Comparator.comparing(Task::getStart));

            List<Task> jTasks = new ArrayList<>();
            List<Task> cTasks = new ArrayList<>();

            boolean hasSolution = true;
            String result = "";
            for (int t = 0; t < numberOfTasks && hasSolution; t++) {
                Task task = tasks.get(t);

                if (canTaskTask(cTasks, task)) {
                    cTasks.add(task);
                    result += "C";
                } else if (canTaskTask(jTasks, task)) {
                    jTasks.add(task);
                    result += "J";
                } else {
                    hasSolution = false;
                }
            }

            out += "Case #" + (testCase+1) + ": " + (hasSolution ? result : "IMPOSSIBLE") + (testCase + 1 < testCases ? "\n" : "");
        }

        System.out.print(out);
    }

    private static boolean canTaskTask(List<Task> tasks, Task task) {
        return tasks.stream().allMatch(t -> task.end <= t.start || task.start >= t.end);
    }
}