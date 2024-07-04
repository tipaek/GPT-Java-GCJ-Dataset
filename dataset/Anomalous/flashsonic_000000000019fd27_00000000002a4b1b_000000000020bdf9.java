import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            int tasks = scanner.nextInt();
            Task[] tasksArray = new Task[tasks];

            for (int i = 0; i < tasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasksArray[i] = new Task(start, end, i);
            }

            Arrays.sort(tasksArray, Comparator.comparingInt(task -> task.start));

            int endC = 0;
            int endJ = 0;
            char[] result = new char[tasks];
            boolean possible = true;

            for (Task task : tasksArray) {
                if (endC <= task.start) {
                    endC = task.end;
                    result[task.index] = 'C';
                } else if (endJ <= task.start) {
                    endJ = task.end;
                    result[task.index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + caseNum + ": ");
            if (possible) {
                System.out.println(new String(result));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}

class Task {
    int start;
    int end;
    int index;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}