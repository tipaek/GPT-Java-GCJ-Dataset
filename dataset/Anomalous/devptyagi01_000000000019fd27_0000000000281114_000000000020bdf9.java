import java.util.*;

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
            int numberOfTasks = scanner.nextInt();
            List<Task> tasks = new ArrayList<>(numberOfTasks);

            for (int i = 0; i < numberOfTasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end));
            }

            StringBuilder result = new StringBuilder();
            boolean allOverlap = true;

            for (int i = 0; i < numberOfTasks - 1; i++) {
                if (!tasks.get(i).overlapsWith(tasks.get(i + 1))) {
                    allOverlap = false;
                    break;
                }
            }

            if (allOverlap) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                char currentParent = 'J';
                for (int i = 0; i < numberOfTasks - 1; i++) {
                    result.append(currentParent);
                    if (tasks.get(i).overlapsWith(tasks.get(i + 1))) {
                        currentParent = (currentParent == 'J') ? 'C' : 'J';
                    }
                }
                result.append(currentParent);
                System.out.println("Case #" + caseNumber + ": " + result);
            }

            caseNumber++;
        }

        scanner.close();
    }
}