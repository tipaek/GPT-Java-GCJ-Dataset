import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static class Pair implements Comparable<Pair> {
        final int x;
        final int y;
        final int order;

        public Pair(int x, int y, int order) {
            this.x = x;
            this.y = y;
            this.order = order;
        }
        
        public int getOrder() {
            return order;
        }

        public boolean canTake(Pair pair) {
            if (this.y <= pair.x || this.x >= pair.y) {
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Pair o) {
            return this.x - o.x != 0 ? this.x - o.x : this.y - o.y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            char[] result = new char[n];
            List<Pair> cameronSet = new ArrayList<>();
            List<Pair> jamieSet = new ArrayList<>();

            List<Pair> jobs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int si = in.nextInt();
                int ei = in.nextInt();

                jobs.add(new Pair(si, ei, i));
            }

            Collections.sort(jobs);

            int pasted = 0;
            for (int i = 0; i < jobs.size(); i++) {
                Pair pair = jobs.get(i);
                if (pasted == i) {
                    boolean cameronCanTake = true;
                    for (Pair cPair : cameronSet) {
                        if (!cPair.canTake(pair)) {
                            cameronCanTake = false;
                        }
                    }
                    if (cameronCanTake) {
                        cameronSet.add(pair);
                        result[pair.getOrder()] = 'C';
                        pasted++;
                    } else {
                        boolean jamieCanTake = true;
                        for (Pair jPair : jamieSet) {
                            if (!jPair.canTake(pair)) {
                                jamieCanTake = false;
                            }
                        }
                        if (jamieCanTake) {
                            jamieSet.add(pair);
                            result[pair.getOrder()]= 'J';
                            pasted++;
                        }
                    }
                }
            }
            System.out.println("Case #" + x + ": " + (pasted == n ?
                    new String(result) : "IMPOSSIBLE"));
        }
    }
}
