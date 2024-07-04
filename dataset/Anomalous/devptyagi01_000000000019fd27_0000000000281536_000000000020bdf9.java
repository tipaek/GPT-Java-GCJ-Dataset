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
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            List<Task> tasks = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end));
            }

            boolean allOverlap = true;
            for (int i = 0; i < n - 1; i++) {
                if (!tasks.get(i).overlapsWith(tasks.get(i + 1))) {
                    allOverlap = false;
                    break;
                }
            }

            if (allOverlap) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                caseNumber++;
                continue;
            }

            StringBuilder result = new StringBuilder();
            char currentParent = 'J';
            for (int i = 0; i < n - 1; i++) {
                result.append(currentParent);
                if (tasks.get(i).overlapsWith(tasks.get(i + 1))) {
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