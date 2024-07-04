import java.io.*;
import java.util.*;

public class Solution {
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            processTestCase(testCase);
        }
    }

    private static void processTestCase(int testCaseNumber) throws IOException {
        System.out.print("Case #" + testCaseNumber + ": ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        long[] cakes = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cakes[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(cakes);

        TreeSet<Pair> pairs = new TreeSet<>();
        for (long cake : cakes) {
            for (int j = 1; j <= D; j++) {
                pairs.add(new Pair(cake, j));
            }
        }

        Set<Pair> descendingPairs = pairs.descendingSet();
        int minCuts = Integer.MAX_VALUE;
        for (Pair p : descendingPairs) {
            long totalPieces = 0;
            int cuts = 0;
            for (long cake : cakes) {
                if ((cake * p.y) % p.x == 0) {
                    totalPieces += cake * p.y / p.x;
                    cuts += cake * p.y / p.x - 1;
                }
            }
            if (totalPieces >= D) {
                minCuts = Math.min(cuts, minCuts);
                continue;
            }
            for (long cake : cakes) {
                if ((cake * p.y) % p.x != 0) {
                    totalPieces += cake * p.y / p.x;
                    cuts += cake * p.y / p.x;
                }
            }
        }
        System.out.println(minCuts);
    }

    private static class Pair implements Comparable<Pair> {
        private final long x;
        private final int y;

        public Pair(long x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair other = (Pair) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Pair other) {
            double ratioThis = (double) x / y;
            double ratioOther = (double) other.x / other.y;
            return Double.compare(ratioThis, ratioOther);
        }
    }
}