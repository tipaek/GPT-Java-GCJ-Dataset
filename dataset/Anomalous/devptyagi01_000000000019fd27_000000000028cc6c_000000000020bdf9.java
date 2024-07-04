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

    int getStart() {
        return this.start;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            List<Task> tasks = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                tasks.add(new Task(start, end));
            }

            StringBuilder result = new StringBuilder();
            boolean possible = true;
            int cEnd = 0;
            int jEnd = 0;

            tasks.sort(Comparator.comparingInt(Task::getStart));

            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    result.append('C');
                    cEnd = task.end;
                } else if (task.start >= jEnd) {
                    result.append('J');
                    jEnd = task.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": " + result.toString());
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }
    }
}