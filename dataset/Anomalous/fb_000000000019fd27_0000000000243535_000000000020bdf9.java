import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int caseId, Scanner scanner) {
        int numTasks = scanner.nextInt();
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < numTasks; i++) {
            tasks.add(new Task(scanner.nextInt(), scanner.nextInt()));
        }

        List<Task> originalOrder = new ArrayList<>(tasks);
        Collections.sort(tasks);

        int endTimeC = -1;
        int endTimeJ = -1;

        for (Task task : tasks) {
            if (task.start >= endTimeC) {
                task.executor = "C";
                endTimeC = task.end;
            } else if (task.start >= endTimeJ) {
                task.executor = "J";
                endTimeJ = task.end;
            } else {
                System.out.println("Case #" + caseId + ": IMPOSSIBLE");
                return;
            }
        }

        StringBuilder schedule = new StringBuilder();
        for (Task task : originalOrder) {
            schedule.append(task.executor);
        }

        System.out.println("Case #" + caseId + ": " + schedule.toString());
    }

    private static class Task implements Comparable<Task> {
        int start;
        int end;
        String executor;

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