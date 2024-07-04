import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader reader = new FastReader();

        int tests = reader.nextInt();

        for (int test = 1; test <= tests; test++) {
            int slices = reader.nextInt();
            int dinners = reader.nextInt();

            long[] s = new long[slices];
            long total = 0;
            double maxSlice = 0;
            double minSlice = Double.MAX_VALUE;

            for (int i = 0; i < slices; i++) {
                long e = reader.nextLong();
                s[i] = e;
                total += e;

                maxSlice = Math.max(maxSlice, e);
                minSlice = Math.min(minSlice, (double) e / 3);
            }

            Arrays.sort(s);

            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < slices; i++) {
                if (i > 0 && s[i] == s[i - 1]) {
                    continue;
                }

                int cuts = numberOfCutsUsing(s, s[i], dinners);
                bestScore = Math.min(bestScore, cuts);
            }

            if (bestScore == Integer.MAX_VALUE) {
                bestScore = numberOfCutsUsing(s,(double)s[0] / dinners,dinners);
            }

            System.out.println("Case #" + test + ": " + bestScore);

            // 1. pick slice size

            // 2. find all duplicates

            // 3. get remaining slices
            // 3a) from smallest to largest pick best cuts first (pizza % slice_size == 0)
            // so that it's possible get one cut back
            // 3b) fill the rest greedily
        }
    }

    private static int numberOfCutsUsing(long[]s, double cs, int dinners) {
        int cuts = 0;
        Set<Integer> visited = new HashSet<>();

        int ready = 0;
        double eps = 0.000000001;

        // best cut first
        for (int j = 0; j < s.length; j++) {
            if (s[j] / cs > dinners - ready) {
                break;
            }

            if((double)s[j] % cs < eps) {
                visited.add(j);
                if (s[j] > cs) {
                    long times = (long) (s[j] / cs - 1);
                    cuts += times;
                    ready += times;
                }
                ready++;
            }
        }

        if (ready < dinners) {
            for (int j = 0; j < s.length && dinners - ready > 0; j++) {
                if (visited.contains(j)) {
                    continue;
                }

                if (s[j] > cs) {
                    long times = (long) (s[j] / cs - 1);
                    cuts += times;
                    ready += times;
                }
            }
        }

        if (ready >= dinners) {
            return cuts;
        }

        return Integer.MAX_VALUE;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
