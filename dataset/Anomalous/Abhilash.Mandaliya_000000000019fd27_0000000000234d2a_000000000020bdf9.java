import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int z = 1; z <= t; z++) {
            int n = Integer.parseInt(br.readLine());
            List<Task> tasks = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                String[] times = br.readLine().split(" ");
                tasks.add(new Task(Integer.parseInt(times[0]), Integer.parseInt(times[1])));
            }
            tasks.sort((t1, t2) -> {
                int cmp = Integer.compare(t1.start, t2.start);
                return cmp != 0 ? cmp : Integer.compare(t1.end, t2.end);
            });

            StringBuilder result = new StringBuilder();
            boolean caFree = true, jaFree = true, impossible = false;
            int caIndex = -1, jaIndex = -1;

            for (int i = 0; i < tasks.size() && !impossible; i++) {
                Task currentTask = tasks.get(i);
                if (caIndex >= 0 && tasks.get(caIndex).end <= currentTask.start) caFree = true;
                if (jaIndex >= 0 && tasks.get(jaIndex).end <= currentTask.start) jaFree = true;

                if (caFree) {
                    caFree = false;
                    result.append("C");
                    caIndex = i;
                } else if (jaFree) {
                    jaFree = false;
                    result.append("J");
                    jaIndex = i;
                } else {
                    if (tasks.get(caIndex).end <= currentTask.start) {
                        result.append("C");
                        caIndex = i;
                    } else if (tasks.get(jaIndex).end <= currentTask.start) {
                        result.append("J");
                        jaIndex = i;
                    } else {
                        impossible = true;
                    }
                }
            }

            System.out.print("Case #" + z + ": ");
            System.out.println(impossible ? "IMPOSSIBLE" : result.toString());
        }
    }
}

class Task {
    int start, end;

    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }
}