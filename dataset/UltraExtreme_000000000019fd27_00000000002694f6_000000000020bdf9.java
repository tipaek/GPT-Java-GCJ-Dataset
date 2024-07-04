import java.util.*;
import java.io.*;
public class Solution {

    private static String  impossible = "IMPOSSIBLE";
    private static char Cameron = 'C';
    private static char Jamie = 'J';

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
            Object[] sorted = tasks.toArray();
            Arrays.sort(sorted, Comparator.comparingInt(t -> ((Task) t).start));
            for (Object element : sorted) {
                Task task = (Task) element;
                if(cameron.canTake(task)){
                    cameron.assign(task);
                    task.setAsignee(Cameron);
                } else if(jamie.canTake(task)){
                    jamie.assign(task);
                    task.setAsignee(Jamie);
                } else{
                    return impossible;
                }
            }
            Arrays.sort(sorted, Comparator.comparingInt(t -> ((Task) t).getId()));
            StringBuilder result = new StringBuilder();
            for (Object element : sorted) {
                Task task = (Task) element;
                result.append(task.asignee);
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

        public char getAsignee() {
            return asignee;
        }

        public void setAsignee(char asignee) {
            this.asignee = asignee;
        }

        private char asignee;

        public int getId() {
            return id;
        }

        private int id;
        private static int seq = 0;
        public Task(int start, int end) {
            this.start = start;
            this.end = end;
            this.id = seq++;
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