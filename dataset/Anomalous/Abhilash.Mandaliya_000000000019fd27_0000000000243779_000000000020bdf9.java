import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numTasks = scanner.nextInt();
            List<Task> tasks = new ArrayList<>(numTasks);
            for (int i = 0; i < numTasks; i++) {
                tasks.add(new Task(scanner.nextInt(), scanner.nextInt()));
            }
            tasks.sort((task1, task2) -> {
                if (task1.start == task2.start) {
                    return Integer.compare(task1.end, task2.end);
                }
                return Integer.compare(task1.start, task2.start);
            });

            StringBuilder assignment = new StringBuilder();
            boolean cameronAvailable = true, jamieAvailable = true, impossible = false;
            int cameronLastIndex = -1, jamieLastIndex = -1;

            for (int i = 0; i < tasks.size() && !impossible; i++) {
                int currentStartTime = tasks.get(i).start;
                if (cameronLastIndex >= 0 && tasks.get(cameronLastIndex).end <= currentStartTime) cameronAvailable = true;
                if (jamieLastIndex >= 0 && tasks.get(jamieLastIndex).end <= currentStartTime) jamieAvailable = true;

                if (cameronAvailable) {
                    cameronAvailable = false;
                    assignment.append("C");
                    cameronLastIndex = i;
                } else if (jamieAvailable) {
                    jamieAvailable = false;
                    assignment.append("J");
                    jamieLastIndex = i;
                } else {
                    if (tasks.get(cameronLastIndex).end <= currentStartTime) {
                        assignment.append("C");
                        cameronLastIndex = i;
                    } else if (tasks.get(jamieLastIndex).end <= currentStartTime) {
                        assignment.append("J");
                        jamieLastIndex = i;
                    } else {
                        impossible = true;
                    }
                }
            }

            System.out.print("Case #" + testCase + ": ");
            System.out.println(impossible ? "IMPOSSIBLE" : assignment.toString());
        }
        scanner.close();
    }
}

class Task {
    int start, end;

    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }
}