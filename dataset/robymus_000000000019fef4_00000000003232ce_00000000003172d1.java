import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

    static long gcd(long x, long y) {
        while (y != 0) {
            long z = y;
            y = x % y;
            x = z;
        }
        return x;
    }

    static class Rational {
        long a;
        long b;

        Rational(long a, long b) {
            long x = gcd(a,b);
            this.a = a/x;
            this.b = b/x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rational rational = (Rational) o;
            return a == rational.a &&
                    b == rational.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        // what / (a/b) is integer? -> what*b/a = integer -> what*b % a == 0 -> what % a == 0
        public boolean divisible(long what) {
            return what%a == 0;
        }

        // what / (a/b) = what * b / a
        public long divide(long what) {
            return what * b / a;
        }


        // a/b > what -> a > what*b
        public boolean greaterThan(long what) {
            return a > what * b;
        }
    }

    static long[] slice = new long[10000];
    static int n;
    static int d;

    static HashMap<Rational, Integer> buf = new HashMap<>();

    static int[] perfectCut = new int[51];
    static int totalPossible;

    // Try to find how many cuts are needed to get to enough sliceSize
    static int solveFor(Rational sliceSize) {
        Integer cached = buf.get(sliceSize);
        if (cached != null) return cached;

        // case 1: with X cuts we can cut to X+1 slices of the same (cool) - if same size, that's X==0
        Arrays.fill(perfectCut, 0);

        // case 2: with X cuts we can cut X new slices
        totalPossible = 0;

        // case 3: not possible (smaller than sliceSize)

        Arrays.stream(slice, 0, n).forEach((s) -> {
            if (sliceSize.greaterThan(s)) return; // not possible
            long div = sliceSize.divide(s);
            if (div > d) div = d;
            int idiv = (int) div;
            if (sliceSize.divisible(s)) {
                perfectCut[idiv-1] += 1;
                totalPossible += idiv;
            }
            else {
                totalPossible += idiv;
            }
        });

        if (totalPossible < d) {
            buf.put(sliceSize, Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        if (perfectCut[0] >= d) {
            buf.put(sliceSize, 0);
            return 0;
        }

        // eagerly add perfectcuts
        int t = 0;
        int cuts = 0;
        for (int i = 0; i <= d; i++) {
            int n = Math.min((d-t)/(i+1), perfectCut[i]);
            t += n * (i+1);
            cuts += n * i;
        }

        // finish up with not perfects
        cuts += (d-t);
        buf.put(sliceSize, cuts);
        return cuts;
    }

    static int solve() {
        int min = Integer.MAX_VALUE;

        buf.clear();
        for (int i = 0; i < n; i++) {
            for (long j = 1; j <= d; j++) {
                min = Math.min(min, solveFor(new Rational(slice[i],j)));
            }
        }

        return min;
    }

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("choppers.in"))));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            n = in.nextInt();
            d = in.nextInt();
            for (int j = 0; j < n; j++) {
                slice[j] = in.nextLong();
            }
            int r = solve();
            System.out.println("Case #" + i + ": " + r);
        }
    }
}
