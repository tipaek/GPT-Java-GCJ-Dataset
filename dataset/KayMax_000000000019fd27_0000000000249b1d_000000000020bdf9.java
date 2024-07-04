import java.io.*;
import java.util.*;

public class Solution {

    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        int cases = in.nextInt();

        for(int i = 1; i <= cases; i++) {
            solve(i);
        }
    }

    public static void solve(int num) {
        
        int n = in.nextInt();
        List<Task> tasks = new ArrayList<Task>();

        for(int i = 0; i < n; i++) {
            tasks.add(new Task(in.nextInt(), in.nextInt()));
        }
        
        List<Task> copy = new ArrayList<Task>(tasks);
        Collections.sort(copy);

        int cBusy = 0;
        int jBusy = 0;
        boolean impossible = false;

        for(Task t : copy) {
            if(cBusy <= t.start) {
                t.assign("C");
                cBusy = t.end;
            } else if(jBusy <= t.start) {
                t.assign("J");
                jBusy = t.end;
            } else {
                impossible = true;
                break;
            }
        }

        if(impossible) {
            System.out.printf("Case #%d: IMPOSSIBLE%n", num);
        } else {
            StringBuilder sb = new StringBuilder();
            for(Task t : tasks) {
                sb.append(t.assignedTo);
            }
            System.out.printf("Case #%d: %s", num, sb.toString());
        }

    }

    static class Task implements Comparable<Task>{
        int start, end;
        String assignedTo;
        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
        void assign(String person) {
            this.assignedTo = person;
        }

        @Override
        public int compareTo(Task o) {
            return this.start - o.start;
        }
    }
}
