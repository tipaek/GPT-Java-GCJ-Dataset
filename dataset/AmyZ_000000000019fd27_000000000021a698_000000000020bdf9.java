import java.util.*;
import java.io.*;
//12:00

public class Solution {
    static class Task implements Comparable<Task> {
        int start;
        int end;
        int order;

        Task(int order, int start, int end) {
            this.order = order;
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Task other) {
            return this.start - other.start;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= cases; i++) {
            int n = Integer.parseInt(in.nextLine());
            Task[] tasks = new Task[n];
            for(int t = 0; t < n; t++) {
                String[] eventT = in.nextLine().split(" ");
                tasks[t] = new Task(t, Integer.parseInt(eventT[0]), Integer.parseInt(eventT[1]));
            }
            System.out.println("Case #" + i + ": " + getAnswer(tasks));
        }
    }

    public static String getAnswer(Task[] tasks) {
        Arrays.sort(tasks);
        int cEnd = 0;
        int jEnd = 0;
        char[] assign = new char[tasks.length];
        for(int i = 0; i < tasks.length; i++) {
            if(cEnd <= tasks[i].start) {
                cEnd = tasks[i].end;
                assign[tasks[i].order] = 'C';
            } else if(jEnd <= tasks[i].start) {
                jEnd = tasks[i].end;
                assign[tasks[i].order] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(assign);
    }
}
