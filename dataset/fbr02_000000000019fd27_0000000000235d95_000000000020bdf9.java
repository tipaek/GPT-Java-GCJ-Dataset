
import java.util.*;

public class Solution {

    Scanner sc;
    TreeMap<Integer, ArrayList<Interval>> delta;

    class Interval {
        int start;
        int end;
        char person;

        public Interval(int start, int end ) {
            this.start = start;
            this.end = end;
        }
    }

    List<Interval> intervals;

    void solve() {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            delta = new TreeMap<>();
            StringBuilder res = new StringBuilder();
            intervals = new ArrayList<>();
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
                List<Interval> ls = e.getValue();
                Integer time = e.getKey();
                int d = 0;
                for (Interval inter : ls) {
                    int val = time == inter.start ? 1 : -1;
                    d += val;
                    if (val == -1) {
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
                        int val = time == inter.start ? 1 : -1;
                        if (val == 1) {
                            if (jEnd == -1) {
                                inter.person = 'J';
                                jEnd = inter.end;
                            } else {
                                inter.person = 'C';
                                cEnd = inter.end;
                            }
                        }
                    }
                }
            }
            if (!res.toString().equals("IMPOSSIBLE"))
                for(Interval inter : intervals) {
                    res.append(inter.person);
                }
            System.out.println("Case #" + t + ":" + " " + res.toString());

        }
    }


    public void book(int start, int end) {
        ArrayList<Interval> st = delta.getOrDefault(start, new ArrayList<>());
        ArrayList<Interval> en = delta.getOrDefault(end, new ArrayList<>());
        Interval inter = new Interval(start, end);
        st.add(inter);
        en.add(inter);
        intervals.add(inter);
        delta.put(start, st);
        delta.put(end, en);
    }


    public static void main(String[] args) {
        Solution p = new Solution();
        p.solve();
    }
}
