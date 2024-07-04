import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    private static void solve() {
        int cEndTime = 0;
        boolean isCAvailable = true;
        int jEndTime = 0;
        boolean isJAvailable = true;

        boolean isImpossible = false;

        ArrayList<Task> tasks = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            int[] taskTimes = Arrays.stream(scanner.nextLine().trim().split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
            tasks.add(new Task(taskTimes[0], taskTimes[1]));
        }

        tasks.sort(Task::compareTo);

        StringBuilder result = new StringBuilder();

        for (Task task : tasks) {
            if (task.start >= cEndTime || task.start >= jEndTime) {
                if (task.start >= cEndTime) {
                    isCAvailable = true;
                }
                if (task.start >= jEndTime) {
                    isJAvailable = true;
                }

                if (isCAvailable) {
                    isCAvailable = false;
                    cEndTime = task.end;
                    result.append("C");
                } else if (isJAvailable) {
                    isJAvailable = false;
                    jEndTime = task.end;
                    result.append("J");
                }
            } else {
                isImpossible = true;
                break;
            }
        }

        if (isImpossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result.toString());
        }
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #");
            System.out.print(i);
            System.out.print(": ");
            solve();
        }
    }
}

class Task implements Comparable<Task> {
    int start;
    int end;

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
        return "Task{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}