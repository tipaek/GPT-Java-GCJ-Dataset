import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static class Task {
        int startTime;
        int endTime;
        int taskIndex;
        char owner;

        public Task(int index, int start, int end) {
            this.startTime = start;
            this.endTime = end;
            this.taskIndex = index;
        }

        public void assignTo(char person) {
            this.owner = person;
        }

        @Override
        public String toString() {
            return String.format("Index: %d Start: %d End: %d Owner: %c", taskIndex, startTime, endTime, owner);
        }
    }

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String result = solve(scanner);
            writer.printf("Case #%d: %s%n", i + 1, result);
            writer.flush();
        }
    }

    private static String solve(Scanner scanner) {
        int numberOfTasks = scanner.nextInt();
        Task[] tasks = new Task[numberOfTasks];
        Task cameronTask = new Task(-1, Integer.MIN_VALUE, Integer.MIN_VALUE);
        Task jamieTask = new Task(-1, Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (int i = 0; i < numberOfTasks; i++) {
            tasks[i] = new Task(i, scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(tasks, (a, b) -> Integer.compare(a.startTime, b.startTime));

        for (Task task : tasks) {
            if (jamieTask.endTime <= task.startTime) {
                jamieTask = task;
                task.assignTo('C');
            } else if (cameronTask.endTime <= task.startTime) {
                cameronTask = task;
                task.assignTo('J');
            } else {
                return IMPOSSIBLE;
            }
        }

        Arrays.sort(tasks, (a, b) -> Integer.compare(a.taskIndex, b.taskIndex));
        StringBuilder resultBuilder = new StringBuilder();
        for (Task task : tasks) {
            resultBuilder.append(task.owner);
        }

        return resultBuilder.toString();
    }
}