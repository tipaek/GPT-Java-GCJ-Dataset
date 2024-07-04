import java.util.*;
import java.io.*;
public class Solution {

    private static String  impossible = "IMPOSSIBLE";
    private static String Cameron = "C";
    private static String Jamie = "J";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int numberOfLines = in.nextInt();
            Solver solver = new Solver();
            for (int line = 0; line < numberOfLines; line++) {
                int start = in.nextInt();
                int end = in.nextInt();
                solver.addTask(start,end);
            }
            System.out.println("Case #" + i + ": " + solver.solve());
        }
    }

    public static class Solver {
        private List<Task> tasks = new LinkedList<>();

        public String solve() {
            Person cameron = new Person();
            Person jamie = new Person();
            StringBuilder result = new StringBuilder();
            for (Task task : tasks) {
                if(cameron.canTake(task)){
                    cameron.assign(task);
                    result.append(Cameron);
                } else if(jamie.canTake(task)){
                    jamie.assign(task);
                    result.append(Jamie);
                } else{
                    return impossible;
                }
            }
            return result.toString();
        }

        public void addTask(int start, int end) {
            tasks.add(new Task(start,end));
        }
    }

    private static class Person{
        List<Task> tasks = new LinkedList<>();

        public boolean canTake(Task task) {
            for (Task task1 : tasks) {
                if(task1.intersects(task))
                    return false;
            }
            return true;
        }

        public void assign(Task task) {
            this.tasks.add(task);
        }
    }

    private static class Task {
        private int start;
        private int end;
        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean intersects(Task task) {
            if(this.end<=task.start)
                return false;
            if(task.end<=this.start)
                return false;
            return true;
        }
    }
}