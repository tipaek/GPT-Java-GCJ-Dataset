import java.util.*;

public class Parenting {
    
    public static void main(String[] args) {
        
       Scanner s = new Scanner(System.in);

       int T = s.nextInt();

       for(int i = 0; i < T; i++) {
           solve(i+1, s);
       }

        
    }

    private static void solve(int cid, Scanner s) {

        int N = s.nextInt();

        List<Task> tasks = new ArrayList<Task>();

        for(int i = 0; i < N; i++) {
            tasks.add(new Task(s.nextInt(), s.nextInt()));
        }
        
        List<Task> unsorted = new ArrayList<Task>(tasks);

        Collections.sort(tasks);

        // System.out.print(tasks);

        int busy_c = -1;
        int busy_j = -1;
        for(Task t : tasks) {
            if(t.start >= busy_c) {
                // assign to C
                t.exec = "C";
                busy_c = t.end;
            } else if(t.start >= busy_j) {
                t.exec = "J";
                busy_j = t.end;
            } else {
                System.out.println("Case #" + cid + ": IMPOSSIBLE");
                return;
            }
        }

        String schedule = "";
        for(Task t : unsorted) {
            schedule += t.exec;
        }

        System.out.println("Case #" + cid + ": " + schedule);

    }

    private static class Task implements Comparable<Task>{

        int start;
        int end;
        String exec;
        Task(int s, int e) {
            start = s;
            end = e;
        }
        
        public int compareTo(Task t) {
            return this.start - t.start;
        }

        public String toString() {
            return "[" + start + "-" + end + "]";
        }

    }

}