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

            if (possible(0, periods, cSet, jSet)) {
                String out = "";
                for (Period p : periods) {
                    out += p.o;
                }
                System.out.println("Case #" + num + ": " + out);
            } else {
                System.out.println("Case #" + num + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean possible(int i, List<Period> periods, Set<Period> cSet, Set<Period> jSet) {
        if (i == periods.size()) {
            return true;
        }
        Period p = periods.get(i);
        if (!cSet.contains(p) && !cSet.stream().anyMatch(c -> c.overlaps(p))) {
            p.o = 'C';
            cSet.add(p);
            if (possible(i + 1, periods, cSet, jSet)) {
                return true;
            }
            cSet.remove(p);
        }
        if (!jSet.contains(p) && !jSet.stream().anyMatch(j -> j.overlaps(p))) {
            p.o = 'J';
            jSet.add(p);
            if (possible(i + 1, periods, cSet, jSet)) {
                return true;
            }
            jSet.remove(p);
        }
        return false;
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

        boolean overlaps(Period p) {
            return (this.s > p.s && this.s < p.e)
                    || (p.s > this.s && p.s < this.e)
                    || (this.e > p.s && this.e < p.e)
                    || (p.e > this.s && p.e < this.e);
        }

        @Override
        public boolean equals(Object obj) {
            return this.i == ((Period) obj).i;
        }
    }


}
