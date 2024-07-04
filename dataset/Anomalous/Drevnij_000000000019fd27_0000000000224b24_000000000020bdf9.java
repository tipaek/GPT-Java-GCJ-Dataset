import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int x = 1; x <= t; x++) {
            int n = in.nextInt();
            List<Task> tasks = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                tasks.add(new Task(in.nextInt(), in.nextInt(), i));
            }
            
            tasks.sort(Comparator.comparingInt(task -> task.start));
            
            boolean isC = true, isJ = false;
            int cEnd = tasks.get(0).end, jEnd = 0;
            tasks.get(0).assigned = "C";
            String result = "";
            
            for (int i = 1; i < n; i++) {
                Task current = tasks.get(i);
                
                if (isC && cEnd <= current.start) isC = false;
                if (isJ && jEnd <= current.start) isJ = false;
                
                if (isC && isJ) {
                    result = "IMPOSSIBLE";
                    break;
                } else if (isC) {
                    isJ = true;
                    current.assigned = "J";
                    jEnd = current.end;
                } else {
                    isC = true;
                    current.assigned = "C";
                    cEnd = current.end;
                }
            }
            
            if (result.isEmpty()) {
                tasks.sort(Comparator.comparingInt(task -> task.origOrder));
                StringBuilder resultBuilder = new StringBuilder();
                for (Task task : tasks) {
                    resultBuilder.append(task.assigned);
                }
                result = resultBuilder.toString();
            }
            
            System.out.println("Case #" + x + ": " + result);
        }
    }

    private static class Task {
        int start, end, origOrder;
        String assigned;

        Task(int start, int end, int origOrder) {
            this.start = start;
            this.end = end;
            this.origOrder = origOrder;
        }
    }
}