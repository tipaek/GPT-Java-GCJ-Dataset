import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Task implements Comparable<Task> {
    int id;
    int start;
    int end;
    String who;

    public Task(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.who = "";
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int noOfIntervals = scanner.nextInt();
            List<Task> originalTasks = new ArrayList<>();
            List<Task> sortedTasks = new ArrayList<>();

            for (int j = 0; j < noOfIntervals; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Task task = new Task(j, start, end);
                originalTasks.add(task);
                sortedTasks.add(task);
            }

            Collections.sort(sortedTasks);

            int cEnd = 0;
            int jEnd = 0;
            String result = "";

            for (Task task : sortedTasks) {
                if (task.start >= cEnd) {
                    cEnd = task.end;
                    task.who = "C";
                } else if (task.start >= jEnd) {
                    jEnd = task.end;
                    task.who = "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                StringBuilder sb = new StringBuilder();
                for (Task task : originalTasks) {
                    sb.append(task.who);
                }
                result = sb.toString();
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}