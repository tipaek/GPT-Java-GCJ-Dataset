import java.util.*;

public class Solution {

    private static class Task implements Comparable<Task> {
        public int start;
        public int end;
        public char assignedTo;

        public Task(int start, int end) {
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
            String result = "";
            int cameronEnd = -1;
            int jamieEnd = -1;
            ArrayList<Task> originalTasks = new ArrayList<>();
            ArrayList<Task> sortedTasks = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                Task task = new Task(scanner.nextInt(), scanner.nextInt());
                originalTasks.add(task);
                sortedTasks.add(task);
            }

            Collections.sort(sortedTasks);

            for (Task task : sortedTasks) {
                if (cameronEnd <= task.start) {
                    cameronEnd = task.end;
                    task.assignedTo = 'C';
                } else if (jamieEnd <= task.start) {
                    jamieEnd = task.end;
                    task.assignedTo = 'J';
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (result.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (Task task : originalTasks) {
                    sb.append(task.assignedTo);
                }
                result = sb.toString();
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}