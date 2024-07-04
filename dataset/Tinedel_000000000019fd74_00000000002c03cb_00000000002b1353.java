import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static Map<Pair, Long> cache = new HashMap<>();

    private static long computeValue(Pair pair) {
        return cache.computeIfAbsent(pair, p -> cache.computeIfAbsent(new Pair(pair.r - 1, pair.k - 1), Pair::getVal)
                + cache.computeIfAbsent(new Pair(pair.r - 1, pair.k), Pair::getVal));
    }

    static class Pair {

        @Override
        public String toString() {
            return String.format("(%d, %d)", r, k);
        }

        int r;
        int k;

        private long getVal() {
            if (r < 1 || k < 1 || k > r) return 0;
            if (r == 1 || k == 1 || r == k) return 1;

            return computeValue(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r &&
                    k == pair.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, k);
        }

        Pair(int r, int k) {
            this.r = r;
            this.k = k;
        }

        Pair l() {
            if (k == 1) return null;
            return new Pair(r, k - 1);
        }

        Pair r() {
            if (k == r) return null;
            return new Pair(r, k + 1);
        }

        Pair ul() {
            if (r == 1 || k == 1) return null;
            return new Pair(r - 1, k - 1);
        }

        Pair ur() {
            if (r == 1 || k == r) return null;
            return new Pair(r - 1, k);
        }

        Pair dl() {
            return new Pair(r + 1, k);
        }

        Pair dr() {
            return new Pair(r + 1, k + 1);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Pair> res = solve(n);
            printSolution(i, res);
        }
    }

    private static void printSolution(int i, List<Pair> res) {
        System.out.println("Case #" + i + ":");
        for (Pair p : res) {
            System.out.printf("%d %d%n", p.r, p.k);
        }
    }

    private static List<Pair> SOL1 = new ArrayList<Pair>() {{
        add(new Pair(1, 1));
    }};

    private static List<Pair> SOL2 = new ArrayList<Pair>() {{
        add(new Pair(1, 1));
        add(new Pair(2, 1));
    }};

    private static List<Pair> solve(int n) {
        if (n == 1) {
            return SOL1;
        } else if (n == 2) {
            return SOL2;
        }

        List<Pair> res = new ArrayList<>();
        Pair current = new Pair(1, 1);
        long sum = current.getVal();
        res.add(current);

        current = current.dr();
        sum += current.getVal();
        res.add(current);
        while (sum < n) {
            Pair left = current.l();
            Pair downLeft = current.dl();

            if (sum + downLeft.getVal() <= n) {
                sum += downLeft.getVal();
                current = downLeft;
                res.add(current);
            } else {
                sum += left.getVal();
                current = left;
                res.add(current);
            }
            if (res.size() >= 500) return res;
        }
        return res;
    }
}