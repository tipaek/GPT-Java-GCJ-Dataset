import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Interval implements Comparable<Interval> {
        int idx, s, e, p;

        public Interval(int idx, int s, int e) {
            this.idx = idx;
            this.s = s;
            this.e = e;
            p = -1;
        }

        @Override
        public int compareTo(Interval o) {
            int comp = s - o.s;
            if (comp == 0) comp = o.e - e;
            return comp == 0 ? idx - o.idx : comp;
        }
    }

    private void work() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = sc.nextInt();
        for (int tc = 1; tc <= nc; tc++) {
            int n = sc.nextInt();
            List<Interval> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                a.add(new Interval(i, s, e));
            }

            Collections.sort(a);

            Interval prev1 = null;
            Interval prev2 = null;
            boolean ok = true;
            for (Interval i : a) {
                if (prev1 != null && prev1.e <= i.s) prev1 = null;
                if (prev2 != null && prev2.e <= i.s) prev2 = null;

                if (prev1 != null && prev2 != null) {
                    ok = false;
                    break;
                }

                if (prev1 == null && prev2 == null) {
                    i.p = 0;
                    prev1 = i;
                } else if (prev1 == null) {
                    i.p = 1 - prev2.p;
                    prev1 = i;
                } else {
                    i.p = 1 - prev1.p;
                    prev2 = i;
                }
            }

            String res = "IMPOSSIBLE";
            char[] x = {'C', 'J'};
            if (ok) {
                char[] ans = new char[n];
                for (Interval i : a) {
                    ans[i.idx] = x[i.p];
                }
                res = String.copyValueOf(ans);
            }

            System.out.printf("Case #%d: %s\n", tc, res);
        }
        sc.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
