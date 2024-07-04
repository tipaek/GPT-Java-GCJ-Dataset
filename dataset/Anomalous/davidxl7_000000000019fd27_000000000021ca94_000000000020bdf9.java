import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            int T = Integer.parseInt(br.readLine());
            Task[] tasks = new Task[T];
            
            for (int j = 0; j < T; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                tasks[j] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), j);
            }
            
            Arrays.sort(tasks);
            char[] schedule = new char[T];
            boolean isSolvable = true;
            int cameronEnd = -1;
            int jamieEnd = -1;
            
            for (int j = 0; j < T; j++) {
                if (cameronEnd <= tasks[j].start) {
                    cameronEnd = tasks[j].end;
                    schedule[tasks[j].index] = 'C';
                } else if (jamieEnd <= tasks[j].start) {
                    jamieEnd = tasks[j].end;
                    schedule[tasks[j].index] = 'J';
                } else {
                    isSolvable = false;
                    break;
                }
            }
            
            if (isSolvable) {
                System.out.print(new String(schedule));
            } else {
                System.out.print("IMPOSSIBLE");
            }
            
            if (i != N - 1) {
                System.out.println();
            }
        }
    }

    static class Task implements Comparable<Task> {
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
}