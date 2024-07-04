import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {
            List<Period> periods = new ArrayList<>();
            int n = in.nextInt();
            for (int i = 1; i <= n; i++) {
                periods.add(new Period(i, in.nextInt(), in.nextInt()));
            }

            Set<Period> cSet = new HashSet<>();
            Set<Period> jSet = new HashSet<>();

            Collections.sort(periods, Comparator.comparing(Period::start));
            boolean possible = true;
            for (Period p: periods) {
                if (!cSet.stream().anyMatch(c -> c.overlaps(p))) {
                    p.o = 'C';
                    cSet.add(p);
                    continue;
                }
                if (!jSet.stream().anyMatch(j -> j.overlaps(p))) {
                    p.o = 'J';
                    jSet.add(p);
                    continue;
                }
                possible = false;
                break;
            }

            if (!possible) {
                System.out.println("Case #" + num + ": IMPOSSIBLE");
                continue;
            }

            char[] out = new char[periods.size()];
            for(Period p: periods) {
                out[p.i -1 ] = p.o;
            }
            System.out.println("Case #" + num + ": " + String.valueOf(out));

        }
    }

    public static class Period {
        public final int i;
        public final int s;
        public final int e;
        public char o;

        public Period(int i, int s, int e) {
            this.i = i;
            this.s = s;
            this.e = e;
        }

        public int start() {
            return s;
        }

        boolean overlaps(Period p) {
            return (this.s > p.s && this.s < p.e)
                    || (p.s > this.s && p.s < this.e)
                    || (this.e > p.s && this.e < p.e)
                    || (p.e > this.s && p.e < this.e)
                    || (this.s == p.s && this.e == p.e);
        }

        @Override
        public boolean equals(Object obj) {
            return this.i == ((Period) obj).i;
        }
    }


}
