
import java.util.*;

public class Solution {

    Scanner sc;
    TreeMap<Integer, ArrayList<Interval>> delta;

    class Interval {
        int start;
        int end;
        int val;

        public Interval(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }

    void solve() {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            delta = new TreeMap<>();
            StringBuilder res = new StringBuilder();
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                book(start, end);
            }
            int active = 0;
            int cEnd = -1;
            int jEnd = -1;
            for (Map.Entry<Integer, ArrayList<Interval>> e : delta.entrySet()) {
                int time = e.getKey();
                List<Interval> ls = e.getValue();
                int d = 0;
                for (Interval inter : ls) {
                    d += inter.val == 1 ? 1 : -1;
                    if (inter.val == -1) {
                        cEnd = cEnd == inter.end ? -1 : cEnd;
                        jEnd = jEnd == inter.end ? -1 : jEnd;
                    }
                }
                active += d;
                if (active >= 3) {
                    res = new StringBuilder("IMPOSSIBLE");
                    break;
                } else {
                    for (Interval inter : ls) {
                        if (inter.val == 1) {
                            if (jEnd == -1) {
                                res.append('J');
                                jEnd = inter.end;
                            } else {
                                res.append('C');
                                cEnd = inter.end;
                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + t + ":" + " " + res.toString());

        }
    }


    public void book(int start, int end) {
        ArrayList<Interval> st = delta.getOrDefault(start, new ArrayList<>());
        ArrayList<Interval> en = delta.getOrDefault(end, new ArrayList<>());
        st.add(new Interval(start, end, +1));
        en.add(new Interval(start, end, -1));
        delta.put(start, st);
        delta.put(end, en);
    }


    public static void main(String[] args) {
        Solution p = new Solution();
        p.solve();
    }
}
