import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalCases = scanner.nextInt();

        for (int i = 0; i < totalCases; i++) {
            int numTasks = scanner.nextInt();
            scanner.nextLine();

            Task[] tasks = new Task[numTasks];
            for (int j = 0; j < numTasks; j++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                tasks[j] = new Task(start, end, j);
            }

            // Sort tasks by their start time
            Arrays.sort(tasks, (a, b) -> Integer.compare(a.start, b.start));

            int cEnd = 0, jEnd = 0;
            char[] assignments = new char[numTasks];
            boolean isImpossible = false;

            for (Task task : tasks) {
                if (cEnd <= task.start) {
                    cEnd = task.end;
                    assignments[task.index] = 'C';
                } else if (jEnd <= task.start) {
                    jEnd = task.end;
                    assignments[task.index] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + new String(assignments));
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