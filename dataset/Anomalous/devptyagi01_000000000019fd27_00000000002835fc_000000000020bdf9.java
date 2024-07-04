import java.util.*;
import java.io.*;

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

            boolean allOverlap = true;
            for (int i = 0; i < n - 1; i++) {
                if (!tasks.get(i).overlaps(tasks.get(i + 1))) {
                    allOverlap = false;
                    break;
                }
            }

            if (allOverlap) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                caseNumber++;
                continue;
            }

            char parent = 'J';
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n - 1; i++) {
                result.append(parent);
                if (tasks.get(i).overlaps(tasks.get(i + 1))) {
                    parent = (parent == 'C') ? 'J' : 'C';
                }
            }
            result.append(parent);

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
        sc.close();
    }
}