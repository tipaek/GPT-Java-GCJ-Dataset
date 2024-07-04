import java.io.*;
import java.util.*;

// Main class
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        new Solution();
    }

    public Solution() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int numTasks = sc.nextInt();
        for (int task = 1; task <= numTasks; task++) {
            int n = sc.nextInt();
            Task[] tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                tasks[i] = new Task(i, start, end);
            }
            Arrays.sort(tasks, Comparator.comparingInt((Task t) -> t.start).thenComparingInt(t -> t.end));

            boolean isCTurn = true;
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            for (Task taskObj : tasks) {
                if (isCTurn) {
                    if (taskObj.start < cEnd) {
                        possible = false;
                        break;
                    }
                    cEnd = taskObj.end;
                    taskObj.person = 'C';
                } else {
                    if (taskObj.start < jEnd) {
                        possible = false;
                        break;
                    }
                    jEnd = taskObj.end;
                    taskObj.person = 'J';
                }
                isCTurn = cEnd <= jEnd;
            }

            Arrays.sort(tasks, Comparator.comparingInt(t -> t.index));
            String result = possible ? Arrays.stream(tasks).map(t -> String.valueOf(t.person)).reduce("", String::concat) : "IMPOSSIBLE";

            System.out.println("Case #" + task + ": " + result);
        }

        sc.close();
    }

    static class Task {
        int index, start, end;
        char person;

        public Task(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}