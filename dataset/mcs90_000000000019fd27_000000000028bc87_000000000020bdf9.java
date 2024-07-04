import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    static class Task implements Comparable<Task> {
        int index;
        int start;
        int end;
        
        Task(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Task other) {
            return start - other.start;
        }
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; ++t) {
            int n = s.nextInt();
            Task[] tasks = new Task[n];
            for (int j = 0; j < n; ++j) {
                int st = s.nextInt();
                int e = s.nextInt();
                tasks[j] = new Task(j, st, e);
            }
            
            System.out.println(String.format(
                "Case #%d: %s",
                t, new Solution().solve(tasks)));
        }
    }
    
    private char[] who = new char[] {'C', 'J'};
    private int[] end = new int[2];
    
    public String solve(Task[] tasks) {
        Arrays.sort(tasks);
        
        char[] res = new char[tasks.length];
        for (int i = 0; i < tasks.length; ++i) {
            int found = -1;
            for (int j = 0; j < 2; ++j) {
                if (end[j] <= tasks[i].start) {
                    end[j] = tasks[i].end;
                    found = j;
                    break;
                }
            }
            if (found < 0) {
                return "IMPOSSIBLE";
            }
            res[tasks[i].index] = who[found];
        }
        
        return new String(res);
    }
}