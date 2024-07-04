import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= testcase; i++) {
            int n = sc.nextInt();
            Task[] tasks = new Task[n];

            for (int j = 0; j < n; j++) {
                tasks[j] = new Task(sc.nextInt(), sc.nextInt(), j);
            }

            Arrays.sort(tasks);
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;
            int cEnd = 0, jEnd = 0;

            cEnd = tasks[0].end;
            schedule.append("C");

            for (int j = 1; j < n; j++) {
                if (cEnd <= tasks[j].start) {
                    cEnd = tasks[j].end;
                    schedule.append("C");
                } else if (jEnd <= tasks[j].start) {
                    jEnd = tasks[j].end;
                    schedule.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                char[] result = new char[n];
                for (int j = 0; j < n; j++) {
                    result[tasks[j].index] = schedule.charAt(j);
                }
                System.out.println("Case #" + i + ": " + new String(result));
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}

class Task implements Comparable<Task> {
    int start, end, index;

    public Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}