import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int tci = 0; tci < tc; tci++) {
            int n = Integer.parseInt(br.readLine());
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                tasks.add(new Task(start, end, i));
            }
            Collections.sort(tasks);

            boolean[] boolC = new boolean[24 * 60];
            boolean[] boolJ = new boolean[24 * 60];
            char[] solution = new char[n];
            boolean impossible = false;

            for (Task task : tasks) {
                if (canAssign(boolC, task.start, task.end)) {
                    Arrays.fill(boolC, task.start, task.end, true);
                    solution[task.index] = 'C';
                } else if (canAssign(boolJ, task.start, task.end)) {
                    Arrays.fill(boolJ, task.start, task.end, true);
                    solution[task.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", tci + 1);
            } else {
                System.out.printf("Case #%d: %s\n", tci + 1, new String(solution));
            }
        }
        br.close();
    }

    private static boolean canAssign(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }
}

class Task implements Comparable<Task> {
    int start;
    int end;
    int index;

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