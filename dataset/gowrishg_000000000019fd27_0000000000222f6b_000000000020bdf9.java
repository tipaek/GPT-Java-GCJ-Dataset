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
            ArrayDeque<MyTask> schs = new ArrayDeque<MyTask>();
            ArrayDeque<MyTask> jSchs = new ArrayDeque<MyTask>();
            ArrayDeque<MyTask> cSchs = new ArrayDeque<MyTask>();

            for (int i = 0; i < sch; i++) {
                MyTask task = new MyTask(in.nextInt(), in.nextInt());
                schs.add(task);
            }

            MyTask task = schs.peekLast();
            while (task != null) {
                task = schs.remove();
                if (!overlaps(jSchs.clone(), task)) {
                    jSchs.add(task);
                    task = schs.peekLast();
                    ans.append("J");
                    continue;
                }
                if (!overlaps(cSchs.clone(), task)) {
                    cSchs.add(task);
                    task = schs.peekLast();
                    ans.append("C");
                    continue;
                }
                return "IMPOSSIBLE";
            }
            String ans2 = ans.toString();
            return ans2.isEmpty() ? "IMPOSSIBLE" : ans2;
        }

        static boolean overlaps(Deque<MyTask> schs, MyTask task) {
            if (schs.isEmpty()) return false;
            MyTask t = schs.peekLast();
            while (t != null) {
                t = schs.remove();
                if (t.overlaps(task)) return true;
                t = schs.peekLast();
            }
            return false;
        }
    }