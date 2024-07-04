import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            processTestCase(i + 1, scanner);
        }
    }

    private static void processTestCase(int caseId, Scanner scanner) {
        int numberOfTasks = scanner.nextInt();
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < numberOfTasks; i++) {
            tasks.add(new Task(scanner.nextInt(), scanner.nextInt()));
        }

        Collections.sort(tasks);

        StringBuilder schedule = new StringBuilder();
        int cEndTime = -1;
        int jEndTime = -1;

        for (Task task : tasks) {
            if (task.start >= cEndTime) {
                schedule.append("C");
                cEndTime = task.end;
            } else if (task.start >= jEndTime) {
                schedule.append("J");
                jEndTime = task.end;
            } else {
                System.out.println("Case #" + caseId + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + caseId + ": " + schedule.toString());
    }

    private static class Task implements Comparable<Task> {
        int start;
        int end;

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