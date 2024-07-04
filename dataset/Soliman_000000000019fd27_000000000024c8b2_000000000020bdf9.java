import java.io.PrintWriter;
import java.util.*;

public class Solution {

    static class Interval implements Comparable<Interval> {
        int s, e;

        Interval(int s, int e) {
            this.s = s;
            this.e = e;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            int N = sc.nextInt();

            List<Interval> intervalsList = new ArrayList<>();
            for (int i = 0; i < N; ++i) intervalsList.add(new Interval(sc.nextInt(), sc.nextInt()));

            Collections.shuffle(intervalsList);
            Collections.sort(intervalsList);
            Interval[] intervals = new Interval[N];
            intervalsList.toArray(intervals);

            char[] assignee = new char[N];
            Arrays.fill(assignee, 'X');

            char cur = 'C';

            for (int i = 0; i < N; ++i) {
                if (assignee[i] != 'X') continue;
                assignee[i] = cur;
                int last = i;

                for (int j = i + 1; j < N; ++j) {
                    if (intervals[last].overlapWith(intervals[j])) continue;
                    assignee[j] = assignee[i];
                    last = j;
                }

                if (cur == 'J') break; //IMPOSSIBLE (ONLY TWO ASSIGNMENTS)
                cur = 'J';
            }

            StringBuilder sb = new StringBuilder();
            boolean impossible = false;
            for (int i = 0; i < N; ++i) {
                if (assignee[i] == 'X') { //IMPOSSIBLE IF AT LEAST ONE IS NOT ASSIGNED
                    pw.printf("Case #%d: IMPOSSIBLE\n", t);
                    impossible = true;
                    break;
                }
                sb.append(assignee[i]);
            }

            if (!impossible)
                pw.printf("Case #%d: %s\n", t, sb.toString());
        }
        pw.flush();
        pw.close();
    }
}
