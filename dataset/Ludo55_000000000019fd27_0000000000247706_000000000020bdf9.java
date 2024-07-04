import java.util.*;
import java.io.*;
public class Solution {
    public static class Task implements Comparable<Task>{
        private final int start;
        private final int end;
        private final int index;
        private final Task previous;
        private char c;

        public Task(int start, int end, int index, Task previous) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.previous = previous;
        }

        @Override
        public int compareTo(Task o) {
            int comp = Integer.compare(this.start, o.start);
            return comp == 0 ? Integer.compare(this.index, o.index) : comp;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "start=" + start +
                    ", end=" + end +
                    ", c=" + c +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t_n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.


        for (int t = 1; t <= t_n; ++t) {
            int n = in.nextInt();
            TreeSet<Task> tasks = new TreeSet<>();
            Task previous = null;
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                Task task = new Task(s,e, i, previous);
                tasks.add(task);
                previous = task;
            }
            boolean impossible = false;
            int cameron = 0, jamie = 0;
            for(Task task : tasks){
                if (task.start >= cameron){
                    cameron = task.end;
                    task.c = 'C';
                }else if (task.start >= jamie){
                    jamie = task.end;
                    task.c = 'J';
                }else{
                    impossible = true;
                    break;
                }
            }
            if(impossible){
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }else{
                StringBuilder string = new StringBuilder();
                while(previous != null){
                    string.append(previous.c);
                    previous = previous.previous;
                }
                System.out.println("Case #" + t + ": " + string.reverse().toString());
            }

        }
    }

}
