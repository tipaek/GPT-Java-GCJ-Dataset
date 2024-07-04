import java.util.*;

class Task {
    int start;
    int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    boolean overlaps(Task other) {
        return this.end > other.start;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int numActivities = scanner.nextInt();
            List<Task> tasks = new ArrayList<>(numActivities);

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end));
            }

            char currentParent = 'C';
            StringBuilder result = new StringBuilder();
            boolean allOverlap = true;

            for (int i = 0; i < numActivities - 1; i++) {
                Task currentTask = tasks.get(i);
                Task nextTask = tasks.get(i + 1);

                if (!currentTask.overlaps(nextTask)) {
                    allOverlap = false;
                    break;
                }
            }

            if (allOverlap) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                caseNumber++;
                continue;
            }

            for (int i = 0; i < numActivities - 1; i++) {
                result.append(currentParent);
                Task currentTask = tasks.get(i);
                Task nextTask = tasks.get(i + 1);

                if (currentTask.overlaps(nextTask)) {
                    currentParent = (currentParent == 'C') ? 'J' : 'C';
                }
            }

            result.append(currentParent);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        scanner.close();
    }
}