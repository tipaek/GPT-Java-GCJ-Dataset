import java.util.*;

public class Parenting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            handleTestCase(i, scanner);
        }
    }

    private static void handleTestCase(int caseId, Scanner scanner) {
        int taskCount = scanner.nextInt();
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < taskCount; i++) {
            tasks.add(new Task(scanner.nextInt(), scanner.nextInt()));
        }

        List<Task> originalOrder = new ArrayList<>(tasks);
        Collections.sort(tasks);

        int cBusyUntil = -1;
        int jBusyUntil = -1;

        for (Task task : tasks) {
            if (task.start >= cBusyUntil) {
                task.assignedTo = 'C';
                cBusyUntil = task.end;
            } else if (task.start >= jBusyUntil) {
                task.assignedTo = 'J';
                jBusyUntil = task.end;
            } else {
                System.out.println("Case #" + caseId + ": IMPOSSIBLE");
                return;
            }
        }

        StringBuilder schedule = new StringBuilder();
        for (Task task : originalOrder) {
            schedule.append(task.assignedTo);
        }

        System.out.println("Case #" + caseId + ": " + schedule.toString());
    }

    private static class Task implements Comparable<Task> {
        int start;
        int end;
        char assignedTo;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return "[" + start + "-" + end + "]";
        }
    }
}