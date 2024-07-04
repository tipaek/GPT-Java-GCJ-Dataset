import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T; i++) {
            result.append("Case #").append(i + 1).append(": ");
            int n = Integer.parseInt(reader.readLine());
            Time[] tasks = new Time[n];
            for (int j = 0; j < n; j++) {
                tasks[j] = new Time();
            }
            
            int[] timeLine = new int[1500];
            boolean isImpossible = false;
            
            for (int j = 0; j < n; j++) {
                String[] timeRange = reader.readLine().split(" ");
                int start = Integer.parseInt(timeRange[0]);
                int end = Integer.parseInt(timeRange[1]);
                
                tasks[j].task = j;
                tasks[j].start = start;
                tasks[j].end = end;
                
                for (int k = start; k < end; k++) {
                    timeLine[k]++;
                    if (timeLine[k] > 2) {
                        isImpossible = true;
                    }
                }
            }
            
            if (isImpossible) {
                result.append("IMPOSSIBLE\n");
                continue;
            }
            
            Arrays.sort(tasks, (a, b) -> Integer.compare(a.end, b.end));
            
            for (int j = 1; j < tasks.length; j++) {
                Time previousTask = tasks[j - 1];
                Time currentTask = tasks[j];
                if (previousTask.end > currentTask.start) {
                    currentTask.j = !previousTask.j;
                } else {
                    currentTask.j = previousTask.j;
                }
            }
            
            Arrays.sort(tasks, (a, b) -> Integer.compare(a.task, b.task));
            
            for (Time task : tasks) {
                result.append(task.j ? "J" : "C");
            }
            result.append("\n");
        }
        System.out.print(result);
    }
}

class Time {
    public int task;
    public int start;
    public int end;
    public boolean j;

    @Override
    public String toString() {
        return "Time{" +
                "task=" + task +
                ", start=" + start +
                ", end=" + end +
                ", j=" + j +
                '}';
    }
}