import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            Task[] tasks = new Task[N];
            for (int j = 0; j < N; ++j) {
                tasks[j] = new Task(in.nextInt(), in.nextInt(), j);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));
            
            int camFree = 0;
            int jamFree = 0;
            boolean isPossible = true;
            char[] parent = new char[N];
            
            for (Task task : tasks) {
                if (camFree <= task.start) {
                    camFree = task.end;
                    parent[task.index] = 'C';
                } else if (jamFree <= task.start) {
                    jamFree = task.end;
                    parent[task.index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isPossible) {
                for (char c : parent) {
                    result.append(c);
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    static class Task {
        int start;
        int end;
        int index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}