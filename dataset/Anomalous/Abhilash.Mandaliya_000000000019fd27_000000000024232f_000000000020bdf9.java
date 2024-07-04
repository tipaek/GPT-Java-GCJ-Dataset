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
            
            tasks.sort((task1, task2) -> {
                int startComparison = Integer.compare(task1.start, task2.start);
                return startComparison != 0 ? startComparison : Integer.compare(task1.end, task2.end);
            });
            
            StringBuilder result = new StringBuilder();
            boolean ca = true, ja = true, impossible = false;
            int ci = -1, ji = -1;
            
            for (int i = 0; i < tasks.size() && !impossible; i++) {
                int startTime = tasks.get(i).start;
                
                if (ci >= 0 && tasks.get(ci).end <= startTime) ca = true;
                if (ji >= 0 && tasks.get(ji).end <= startTime) ja = true;
                
                if (ca) {
                    ca = false;
                    result.append("C");
                    ci = i;
                } else if (ja) {
                    ja = false;
                    result.append("J");
                    ji = i;
                } else {
                    if (tasks.get(ci).end <= startTime) {
                        result.append("C");
                        ci = i;
                    } else if (tasks.get(ji).end <= startTime) {
                        result.append("J");
                        ji = i;
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