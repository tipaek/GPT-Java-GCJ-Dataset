import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Task implements Comparable<Task> {
    int startTime;
    int endTime;
    int index;

    public Task(int startTime, int endTime, int index) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.startTime, other.startTime);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int k = 1; k <= t; k++) {
            int numTasks = sc.nextInt();
            Task[] tasks = new Task[numTasks];

            for (int i = 0; i < numTasks; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                tasks[i] = new Task(start, end, i);
            }

            Arrays.sort(tasks);

            int freeC = 0;
            int freeJ = 0;
            boolean impossible = false;
            char[] result = new char[numTasks];

            for (Task task : tasks) {
                if (task.startTime >= freeC) {
                    result[task.index] = 'C';
                    freeC = task.endTime;
                } else if (task.startTime >= freeJ) {
                    result[task.index] = 'J';
                    freeJ = task.endTime;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + k + ": " + new String(result));
            }
        }
        sc.close();
    }
}