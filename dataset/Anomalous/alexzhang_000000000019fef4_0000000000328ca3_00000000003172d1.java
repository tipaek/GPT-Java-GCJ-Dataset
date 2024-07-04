import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            processTestCase(testCase);
        }
    }

    public static void processTestCase(int caseNumber) throws IOException {
        System.out.print("Case #" + caseNumber + ": ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] cakes = new long[N];
        for (int i = 0; i < N; i++) {
            cakes[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(cakes);
        Set<Pair> pairs = generatePairs(cakes, D);

        long minCuts = Long.MAX_VALUE;
        for (Pair pair : pairs) {
            minCuts = Math.min(minCuts, calculateCuts(cakes, pair, D));
        }

        System.out.println(minCuts);
    }

    private static Set<Pair> generatePairs(long[] cakes, int D) {
        Set<Pair> pairs = new HashSet<>();
        for (long cake : cakes) {
            for (long j = 1; j <= D; j++) {
                pairs.add(new Pair(cake, j));
            }
        }
        return pairs;
    }

    private static long calculateCuts(long[] cakes, Pair pair, int D) {
        long counter = 0;
        long cuts = 0;

        for (long cake : cakes) {
            if ((cake * pair.y) % pair.x == 0) {
                long required = cake * pair.y / pair.x;
                if (D - counter < required) {
                    cuts += D - counter;
                    counter = D;
                    break;
                }
                counter += required;
                cuts += required - 1;
            }

            if (counter >= D) {
                break;
            }
        }

        for (long cake : cakes) {
            if ((cake * pair.y) % pair.x != 0) {
                cuts += D - counter;
                counter = D;
                break;
            }

            if (counter >= D) {
                break;
            }
        }
        return cuts;
    }

    static class Pair {
        public long x;
        public long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}