import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = sc.nextInt();
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                tasks[i] = new Task(start, end, i);
            }

            Arrays.sort(tasks);

            Task[] schedule = new Task[n];
            int cEnd = 0, jEnd = 0;
            boolean isPossible = true;
            StringBuilder assignment = new StringBuilder();

            for (Task task : tasks) {
                if (cEnd <= task.start) {
                    cEnd = task.end;
                    task.assignedTo = 'C';
                } else if (jEnd <= task.start) {
                    jEnd = task.end;
                    task.assignedTo = 'J';
                } else {
                    isPossible = false;
                    break;
                }
                schedule[task.index] = task;
            }

            if (!isPossible) {
                assignment.append("IMPOSSIBLE");
            } else {
                for (Task task : schedule) {
                    assignment.append(task.assignedTo);
                }
            }

            result.append("Case #").append(caseNum).append(": ").append(assignment).append("\n");
        }

        System.out.println(result.toString());
    }
}

class Task implements Comparable<Task> {
    int start, end, index;
    char assignedTo;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.assignedTo = 'C'; // Default value
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}