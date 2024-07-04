import java.io.PrintWriter;
import java.util.*;

public class Solution {

    static class Interval implements Comparable<Interval> {
        int s, e, index;

        Interval(int s, int e, int index) {
            this.s = s;
            this.e = e;
            this.index = index;
        }

        @Override
        public int compareTo(Interval o) {
            if (this.s == o.s)
                return this.e - o.e;
            return this.s - o.s;
        }

        @Override
        public String toString() {
            return this.s + ", " + this.e;
        }

        boolean overlapWith(Interval o) {
            return Math.max(s, o.s) < Math.min(e, o.e);
        }
    }

    static boolean canBeASolution(Interval[] intervals, String cur) {
        int N = intervals.length;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i == j) continue;
                if (cur.charAt(i) == cur.charAt(j) && intervals[i].overlapWith(intervals[j])) return false;
            }
        }
        return true;
    }

    static String solve(Interval[] intervals) {
        StringBuilder cur = new StringBuilder();
        ArrayList<String> all = new ArrayList<>();
        helper("", intervals.length, all);

        for (String trial : all) {
            if (canBeASolution(intervals, trial)) return trial;
        }
        return "IMPOSSIBLE";
    }

    static void helper(String cur, int N, ArrayList<String> all) {
        if (cur.length() == N) {
            all.add(cur);
            return;
        }
        String s1 = cur + "C";
        String s2 = cur + "J";

        helper(s1, N, all);
        helper(s2 , N, all);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            int N = sc.nextInt();

            List<Interval> intervalsList = new ArrayList<>();
            for (int i = 0; i < N; ++i) intervalsList.add(new Interval(sc.nextInt(), sc.nextInt(), i));

//            Collections.shuffle(intervalsList);
//            Collections.sort(intervalsList);
            Interval[] intervals = new Interval[N];
            intervalsList.toArray(intervals);

//            char[] assignee = new char[N];
//            Arrays.fill(assignee, 'X');
//
//            char cur = 'C';
//
//            for (int i = 0; i < N; ++i) {
//                int curIndex = intervals[i].index;
//                if (assignee[curIndex] != 'X') continue;
//                assignee[curIndex] = cur;
//                int last = i;
//
//                for (int j = i + 1; j < N; ++j) {
//                    if (intervals[last].overlapWith(intervals[j])) continue;
//                    assignee[intervals[j].index] = assignee[curIndex];
//                    last = j;
//                }
//
//                if (cur == 'J') break; //IMPOSSIBLE (ONLY TWO ASSIGNMENTS)
//                cur = 'J';
//            }
//
//            StringBuilder sb = new StringBuilder();
//            boolean impossible = false;
//            for (int i = 0; i < N; ++i) {
//                if (assignee[i] == 'X') { //IMPOSSIBLE IF AT LEAST ONE IS NOT ASSIGNED
//                    pw.printf("Case #%d: IMPOSSIBLE\n", t);
//                    impossible = true;
//                    break;
//                }
//                sb.append(assignee[i]);
//            }
//
//            if (!impossible)
//                pw.printf("Case #%d: %s\n", t, sb.toString());
            pw.printf("Case #%d: %s\n", t, solve(intervals));
        }
        pw.flush();
        pw.close();
    }
}
