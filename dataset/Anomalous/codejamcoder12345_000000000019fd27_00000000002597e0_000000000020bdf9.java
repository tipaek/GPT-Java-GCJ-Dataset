import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                tasks[i] = new Task(startTimes[i], endTimes[i], i);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));

            int cEnd = 0, jEnd = 0;
            char[] assignments = new char[n];
            boolean impossible = false;

            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    assignments[task.index] = 'C';
                    cEnd = task.end;
                } else if (task.start >= jEnd) {
                    assignments[task.index] = 'J';
                    jEnd = task.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + caseNum + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
    }

    static class Task {
        int start;
        int end;
        int index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}