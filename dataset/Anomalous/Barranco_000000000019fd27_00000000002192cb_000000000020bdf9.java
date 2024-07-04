import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int ncases = 1; ncases <= cases; ncases++) {
            int tasks = sc.nextInt();
            List<Task> tasksList = new ArrayList<>();

            for (int i = 0; i < tasks; i++) {
                tasksList.add(new Task(sc.nextInt(), sc.nextInt(), i));
            }

            Collections.sort(tasksList);

            String result = assignTasks(tasksList);

            System.out.println("Case #" + ncases + ": " + result);
        }

        sc.close();
    }

    private static String assignTasks(List<Task> tasksList) {
        int cEnd = 0, jEnd = 0;
        StringBuilder result = new StringBuilder();
        char[] assignments = new char[tasksList.size()];

        for (Task task : tasksList) {
            if (task.start >= cEnd) {
                assignments[task.index] = 'C';
                cEnd = task.end;
            } else if (task.start >= jEnd) {
                assignments[task.index] = 'J';
                jEnd = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (char assignment : assignments) {
            result.append(assignment);
        }

        return result.toString();
    }
}

class Task implements Comparable<Task> {
    int start, end, index;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}