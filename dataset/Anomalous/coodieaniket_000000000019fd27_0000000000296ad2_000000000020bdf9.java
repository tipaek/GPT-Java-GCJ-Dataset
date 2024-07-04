import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (caseNumber <= testCases) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));

            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    task.assignedTo = 'C';
                    cEnd = task.end;
                } else if (task.start >= jEnd) {
                    task.assignedTo = 'J';
                    jEnd = task.end;
                } else {
                    possible = false;
                    break;
                }
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.index));

            System.out.print("Case #" + caseNumber++ + ": ");
            if (possible) {
                for (Task task : tasks) {
                    System.out.print(task.assignedTo);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}

class Task {
    int start, end, index;
    char assignedTo;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}