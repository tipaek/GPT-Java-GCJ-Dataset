import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][3];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                tasks[i][2] = i;
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

            List<TaskAssignment> assignments = new ArrayList<>();
            int cameronBusyUntil = 0;
            int jamieBusyUntil = 0;

            for (int i = 0; i < n; i++) {
                if (tasks[i][0] >= cameronBusyUntil) {
                    cameronBusyUntil = tasks[i][1];
                    assignments.add(new TaskAssignment('C', tasks[i][2]));
                } else if (tasks[i][0] >= jamieBusyUntil) {
                    jamieBusyUntil = tasks[i][1];
                    assignments.add(new TaskAssignment('J', tasks[i][2]));
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (impossible) continue;

            assignments.sort(Comparator.comparingInt(a -> a.position));
            StringBuilder result = new StringBuilder();
            for (TaskAssignment assignment : assignments) {
                result.append(assignment.assignedTo);
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}

class TaskAssignment {
    char assignedTo;
    int position;

    TaskAssignment(char assignedTo, int position) {
        this.assignedTo = assignedTo;
        this.position = position;
    }
}