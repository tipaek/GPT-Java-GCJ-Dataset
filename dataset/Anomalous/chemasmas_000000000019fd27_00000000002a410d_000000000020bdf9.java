import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    private static void solve() {
        int C = -1, J = -1;
        boolean cAvailable = true, jAvailable = true, impossible = false;

        ArrayList<Task> tasks = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            int[] times = Arrays.stream(scanner.nextLine().trim().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            tasks.add(new Task(times[0], times[1]));
        }

        tasks.sort(Task::compareTo);
        StringBuilder schedule = new StringBuilder();

        for (Task task : tasks) {
            if (task.start >= C) cAvailable = true;
            if (task.start >= J) jAvailable = true;

            if (task.start >= C || task.start >= J) {
                if (cAvailable) {
                    cAvailable = false;
                    C = task.end;
                    schedule.append("C");
                } else if (jAvailable) {
                    jAvailable = false;
                    J = task.end;
                    schedule.append("J");
                }
            } else {
                impossible = true;
                break;
            }
        }

        System.out.println(impossible ? "IMPOSSIBLE" : schedule.toString());
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }
}

class Task implements Comparable<Task> {
    int start, end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public String toString() {
        return "Task{" + "start=" + start + ", end=" + end + '}';
    }
}