import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int totalMinutes = 24 * 60 + 2;

        for (int testCase = 1; testCase <= t; testCase++) {
            int[] intervals = new int[totalMinutes];
            int n = sc.nextInt();
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt() - 1; // Adjust end time for inclusive range
                intervals[start] = 1;
                intervals[end] = -1;
                tasks[i] = new Task(start, end, i);
            }

            Arrays.sort(tasks);

            boolean overlap = false;
            for (int i = 1; i < totalMinutes; i++) {
                intervals[i] += intervals[i - 1];
                if (intervals[i] > 2) {
                    overlap = true;
                    break;
                }
            }

            sb.append("Case #").append(testCase).append(": ");

            if (!overlap) {
                char[] result = new char[n];
                char[] assignments = {'C', 'J'};
                int k = 0;

                for (int i = 0; i < n; i++) {
                    int currentEnd = tasks[i].end;
                    tasks[i].assignedTo = assignments[k % 2];
                    result[tasks[i].index] = tasks[i].assignedTo;

                    for (int j = i + 1; j < n; j++) {
                        if (tasks[j].start <= currentEnd) {
                            tasks[j].assignedTo = assignments[(k + 1) % 2];
                            result[tasks[j].index] = tasks[j].assignedTo;
                            i = j;
                        } else {
                            break;
                        }
                    }
                }

                sb.append(new String(result));
            } else {
                sb.append("IMPOSSIBLE");
            }

            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}

class Task implements Comparable<Task> {
    int start, end, index;
    char assignedTo;

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