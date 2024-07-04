import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

        public static class MyTask {
            final int start;
            final int end;

            MyTask(int start, int end) {
                this.start = start;
                this.end = end;
            }

            boolean overlaps(MyTask t2) {
                return (start < t2.start && t2.start < end) || (start < t2.end && t2.end < end)
                        || (t2.start < start && start < t2.end) || (t2.start < end && end < t2.end)
                        || (t2.start == start && end == t2.end);
            }
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                int sch = in.nextInt();
                String ans = solve(sch, in);
                System.out.println("Case #" + i + ": " + ans);
            }
        }

        public static String solve(int sch, Scanner in) {
            StringBuffer ans = new StringBuffer();
            ArrayList<MyTask> schs = new ArrayList<MyTask>();
            Deque<MyTask> jSchs = new ArrayDeque<MyTask>();
            Deque<MyTask> cSchs = new ArrayDeque<MyTask>();
            for (int i = 0; i < sch; i++) {
                schs.add(new MyTask(in.nextInt(), in.nextInt()));
            }
            Collections.sort(schs, new SortByTask());
            MyTask task = schs.isEmpty() ? null : schs.get(0);
            while (task != null) {
                task = schs.remove(0);
                MyTask jTask = jSchs.peekLast();
                MyTask cTask = cSchs.peekLast();
                if (jTask == null || !jTask.overlaps(task)) {
                    jSchs.add(task);
                    task = schs.isEmpty() ? null : schs.get(0);
                    ans.append("J");
                    continue;
                }
                if (cTask == null || !cTask.overlaps(task)) {
                    cSchs.add(task);
                    task = schs.isEmpty() ? null : schs.get(0);
                    ans.append("C");
                    continue;
                }
                return "IMPOSSIBLE";
            }
            String ans2 = ans.toString();
            return ans2.isEmpty() ? "IMPOSSIBLE" : ans2;
        }

        static class SortByTask implements Comparator<MyTask> {
            public int compare(MyTask a, MyTask b) {
                return new Integer(a.start).compareTo(new Integer(b.start));
            }
        }
    }