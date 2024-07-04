import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Task implements Comparable<Task> {
    private int start;
    private int end;
    private int index;

    public Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, false);

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Task> tasks = new ArrayList<>(N);

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                tasks.add(new Task(start, end, j));
            }

            Collections.sort(tasks);

            Task cTask = null;
            Task jTask = null;
            TreeMap<Integer, String> assignments = new TreeMap<>();
            boolean isImpossible = false;

            for (Task task : tasks) {
                if (cTask == null || cTask.getEnd() <= task.getStart()) {
                    cTask = task;
                    assignments.put(task.getIndex(), "C");
                } else if (jTask == null || jTask.getEnd() <= task.getStart()) {
                    jTask = task;
                    assignments.put(task.getIndex(), "J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                pw.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (String assignment : assignments.values()) {
                    result.append(assignment);
                }
                pw.println("Case #" + i + ": " + result);
            }
        }

        pw.flush();
    }
}