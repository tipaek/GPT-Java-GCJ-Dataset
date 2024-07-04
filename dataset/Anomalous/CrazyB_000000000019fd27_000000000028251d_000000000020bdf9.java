import java.util.*;

public class Solution {

    private static class Task implements Comparable<Task> {
        public int start;
        public int end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            int cameronAvailable = -1;
            int jamieAvailable = -1;
            List<Task> tasks = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                tasks.add(new Task(scanner.nextInt(), scanner.nextInt()));
            }

            Collections.sort(tasks);

            for (Task task : tasks) {
                if (cameronAvailable <= task.start) {
                    cameronAvailable = task.end;
                    result.append("C");
                } else if (jamieAvailable <= task.start) {
                    jamieAvailable = task.end;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}