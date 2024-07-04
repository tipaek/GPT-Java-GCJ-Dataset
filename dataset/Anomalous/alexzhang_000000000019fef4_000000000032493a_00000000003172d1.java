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

    public static void processTestCase(int testCaseNumber) throws IOException {
        System.out.print("Case #" + testCaseNumber + ": ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] cakes = new long[N];
        for (int i = 0; i < N; i++) {
            cakes[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(cakes);

        HashSet<Pair> pairsSet = new HashSet<>();
        for (long cake : cakes) {
            for (long j = 1; j <= D; j++) {
                pairsSet.add(new Pair(cake, j));
            }
        }

        int minCuts = Integer.MAX_VALUE;
        for (Pair p : pairsSet) {
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
            if (totalPieces >= D) {
                minCuts = Math.min(cuts, minCuts);
            }
        }
        System.out.println(minCuts);
    }
}

class Pair {
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