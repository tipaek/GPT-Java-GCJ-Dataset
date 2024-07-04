import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int totalMinutes = 24 * 60 + 2;

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int[] schedule = new int[totalMinutes];
            int n = sc.nextInt();
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                schedule[start] = 1;
                schedule[end - 1] = -1;
                tasks[i] = new Task(start, end, i);
            }

            Arrays.sort(tasks);

            Task[] result = new Task[n];
            int cameronEnd = 0, jamieEnd = 0;
            boolean isPossible = true;
            StringBuilder taskAssignments = new StringBuilder();

            for (Task task : tasks) {
                if (cameronEnd <= task.start) {
                    cameronEnd = task.end;
                    task.assignedTo = 'C';
                } else if (jamieEnd <= task.start) {
                    jamieEnd = task.end;
                    task.assignedTo = 'J';
                } else {
                    isPossible = false;
                    break;
                }
                result[task.index] = task;
            }

            if (!isPossible) {
                taskAssignments.append("IMPOSSIBLE");
            } else {
                for (Task task : result) {
                    taskAssignments.append(task.assignedTo);
                }
            }

            sb.append("Case #").append(caseNum).append(": ").append(taskAssignments).append("\n");
        }

        System.out.println(sb.toString());
    }
}

class Task implements Comparable<Task> {
    int start, end, index;
    char assignedTo;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.assignedTo = 'C';
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}