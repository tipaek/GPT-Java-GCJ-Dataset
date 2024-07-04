import java.util.*;

class Task implements Comparable<Task> {
    int index;
    int start;
    int end;
    char assignedTo;

    Task(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
        this.assignedTo = '.';
    }

    @Override
    public String toString() {
        return "Index: " + index + " Start time: " + start + " End time: " + end + " Assigned to: " + assignedTo;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(i, start, end));
            }

            Collections.sort(tasks);

            int cameronEndTime = 0;
            int jamieEndTime = 0;
            String result = "";

            for (Task task : tasks) {
                if (cameronEndTime <= task.start) {
                    cameronEndTime = task.end;
                    task.assignedTo = 'C';
                } else if (jamieEndTime <= task.start) {
                    jamieEndTime = task.end;
                    task.assignedTo = 'J';
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                char[] schedule = new char[n];
                for (Task task : tasks) {
                    schedule[task.index] = task.assignedTo;
                }
                result = new String(schedule);
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
        scanner.close();
    }
}