import java.util.*;
import java.io.*;

class Task {
    int start;
    int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    boolean overlapsWith(Task other) {
        return this.end > other.start;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            List<Task> tasks = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end));
            }

            boolean allOverlap = true;
            for (int i = 0; i < n - 1; i++) {
                Task currentTask = tasks.get(i);
                for (int j = i + 1; j < n; j++) {
                    Task nextTask = tasks.get(j);
                    if (!currentTask.overlapsWith(nextTask)) {
                        allOverlap = false;
                    }
                }
            }

            if (allOverlap && tasks.size() > 2) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                caseNumber++;
                continue;
            }

            char parent = 'J';
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n - 1; i++) {
                result.append(parent);
                Task currentTask = tasks.get(i);
                Task nextTask = tasks.get(i + 1);
                if (currentTask.overlapsWith(nextTask)) {
                    parent = (parent == 'C') ? 'J' : 'C';
                }
            }
            result.append(parent);
            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
    }
}