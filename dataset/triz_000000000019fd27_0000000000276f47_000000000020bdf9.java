import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int i = 0; i < tests; i++) {
            List<Task> tasks = parseOne(scanner);
            String sol = solve(tasks);
            System.out.println(String.format("Case #%d: %s", i+1, sol ));
        }
    }

    private static List<Task> parseOne(Scanner scanner) {
        int tasks = scanner.nextInt();
        List<Task> ret = new ArrayList<>(tasks);
        for (int i = 0; i < tasks; i++) {
            Task t = new Task(scanner.nextInt(), scanner.nextInt(), i);
            ret.add(t);
        }
        return ret;
    }

    private static class Task {
        private final int startTime;
        private final int endTime;
        private final int originalTaskIndex;

        private Task(int startTime, int endTime, int originalTaskIndex) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.originalTaskIndex = originalTaskIndex;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getOriginalTaskIndex() {
            return originalTaskIndex;
        }
    }

    private static String solve(List<Task> tasks) {
        char [] solutionChars = new char[tasks.size()];

        Collections.sort(tasks, Comparator.comparingInt(Task::getStartTime));
        Task cameronsTask = new Task(0, 0, 0);
        Task jamiesTask = new Task(0, 0, 0);

        for (Task t : tasks) {
            if (t.getStartTime() < cameronsTask.getEndTime()) { // overlaps with cameron
                if (t.getStartTime() < jamiesTask.getEndTime()) { // overlaps with jamie
                    return "IMPOSSIBLE";
                } else {
                    jamiesTask = t;
                    solutionChars[t.getOriginalTaskIndex()] = 'J';
                }
            } else { // does not overlap with cameron
                cameronsTask = t;
                solutionChars[t.getOriginalTaskIndex()] = 'C';
            }
        }
        return new String(solutionChars);
    }
}
