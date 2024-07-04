import java.io.*;
import java.util.*;

class Task {
    int start, end, index;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        if (t1.start != t2.start) {
            return t1.start - t2.start;
        } else {
            return t1.index - t2.index;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        int testCases = getInt();
        for (int i = 1; i <= testCases; i++) {
            int n = getInt();
            int[] assignments = new int[n];
            boolean possible = true;
            int cBusyUntil = 0, jBusyUntil = 0;

            PriorityQueue<Task> taskQueue = new PriorityQueue<>(new TaskComparator());
            for (int j = 0; j < n; j++) {
                taskQueue.add(new Task(getInt(), getInt(), j));
            }

            while (!taskQueue.isEmpty()) {
                Task task = taskQueue.poll();
                if (task.start >= cBusyUntil) {
                    assignments[task.index] = 1;
                    cBusyUntil = task.end;
                } else if (task.start >= jBusyUntil) {
                    assignments[task.index] = 2;
                    jBusyUntil = task.end;
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + i + ": ");
            if (possible) {
                for (int assignment : assignments) {
                    System.out.print(assignment == 1 ? 'C' : 'J');
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private static int getInt() throws IOException {
        int c = skipWhitespace();
        boolean isNegative = (char) c == '-';
        int result = 0;
        if (isNegative) {
            c = input.read();
        }
        do {
            result = result * 10 + (c - '0');
            c = input.read();
        } while (c >= '0' && c <= '9');
        return isNegative ? -result : result;
    }

    private static int skipWhitespace() throws IOException {
        int c;
        while ((c = input.read()) == ' ' || c == '\n' || c == '\r') {
            // Skip whitespace
        }
        return c;
    }
}