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

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int taskCount = scanner.nextInt();
            List<Task> tasks = new ArrayList<>(taskCount);

            for (int i = 0; i < taskCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end));
            }

            if (areAllTasksOverlapping(tasks)) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + assignTasks(tasks));
            }
        }
    }

    private static boolean areAllTasksOverlapping(List<Task> tasks) {
        for (int i = 0; i < tasks.size() - 1; i++) {
            if (!tasks.get(i).overlapsWith(tasks.get(i + 1))) {
                return false;
            }
        }
        return tasks.size() > 2;
    }

    private static String assignTasks(List<Task> tasks) {
        StringBuilder result = new StringBuilder();
        char currentParent = 'J';

        for (int i = 0; i < tasks.size() - 1; i++) {
            result.append(currentParent);
            if (tasks.get(i).overlapsWith(tasks.get(i + 1))) {
                currentParent = (currentParent == 'J') ? 'C' : 'J';
            }
        }
        result.append(currentParent);
        return result.toString();
    }
}