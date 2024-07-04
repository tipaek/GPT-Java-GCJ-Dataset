import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            processCase(testCase);
        }
    }

    public static void processCase(int caseNumber) throws IOException {
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

        TreeSet<Pair> possibleCuts = new TreeSet<>();
        for (long cake : cakes) {
            for (int j = 1; j <= D; j++) {
                possibleCuts.add(new Pair(cake, j));
            }
        }

        Set<Pair> sortedCuts = possibleCuts.descendingSet();
        int minCuts = Integer.MAX_VALUE;

        for (Pair p : sortedCuts) {
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

class Pair implements Comparable<Pair> {
    public long x;
    public int y;

    public Pair(long x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Pair pair = (Pair) other;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int compareTo(Pair other) {
        double ratioThis = x / (double) y;
        double ratioOther = other.x / (double) other.y;
        return Double.compare(ratioThis, ratioOther);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}