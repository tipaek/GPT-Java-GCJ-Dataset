import java.util.*;
public class Solution{
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();
        for (int x = 1; x <= T; x++) {
            // init
            final ArrayList<task> C = new ArrayList<task>();
            final ArrayList<task> J = new ArrayList<task>();
            final ArrayList<task> tasks = new ArrayList<task>();
            final StringBuilder sb = new StringBuilder();
            boolean ans = true;
            // input
            final int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                final int start = sc.nextInt();
                final int end = sc.nextInt();
                final task t = new task(i, start, end, "C");
                tasks.add(t);
            }
            // process
            Collections.sort(tasks, task.timeComparator);
            for (int i = 0; i < N; i++) {
                final task cur = tasks.get(i);
                if (C.size() == 0 || cur.start >= C.get(C.size() - 1).end) {
                    cur.point = "C";
                    C.add(cur);
                } else if (J.size() == 0 || cur.start >= J.get(J.size() - 1).end) {
                    cur.point = "J";
                    J.add(cur);
                } else {
                    ans = false;
                    break;
                }
            }
            // output
            if (!ans)
                System.out.println("case #" + x + ": IMPOSSIBLE");
            else {
                Collections.sort(tasks, task.idComparator);
                for (int i = 0; i < N; i++) {
                    sb.append(tasks.get(i).point);
                }
                System.out.println("case #" + x + ": " + sb.toString());
            }
        }
    }
}

class task {
    int id;
    int start;
    int end;
    String point;

    public task(final int id, final int start, final int end, final String point) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.point = point;
    }

    public static Comparator<task> timeComparator = new Comparator<task>() { 
        public int compare(task a, task b){
            return a.start != b.start ? a.start - b.start : a.end - b.end;
        }
    };

    public static Comparator<task> idComparator = new Comparator<task>(){
        public int compare(task a, task b){
            return a.id - b. id;
        }
    };
}
