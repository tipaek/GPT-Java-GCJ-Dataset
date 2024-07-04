import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static class Activity implements Comparable<Activity> {
        int id;

        int start;
        int end;

        public Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return Integer.compare(o.end, this.end);
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "id=" + id +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();

        outer:
        for (int tt = 0; tt < t; tt++) {
            int n = scanner.nextInt();

            Queue<Activity> q = new PriorityQueue<>(n);

            for (int nn = 0; nn < n; nn++) {
                Activity a = new Activity(nn, scanner.nextInt(), scanner.nextInt());
                q.add(a);
            }

            LinkedList<Activity> c = new LinkedList<>();
            LinkedList<Activity> j = new LinkedList<>();

            char[] res = new char[n];

            Activity activity;
            while ((activity = q.poll()) != null) {
                if (c.isEmpty() || c.getFirst().start >= activity.end) {
                    c.addFirst(activity);
                    res[activity.id] = 'C';
                    continue;
                } else if (j.isEmpty() || j.getFirst().start >= activity.end) {
                    j.addFirst(activity);
                    res[activity.id] = 'J';
                    continue;
                } else {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", tt + 1);
                    continue outer;
                }
            }

            System.out.printf("Case #%d: %s\n", tt + 1, new String(res));
        }
    }
}
