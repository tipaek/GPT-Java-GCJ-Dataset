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

    private static void processTestCase(int caseNumber) throws IOException {
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
        Set<Pair> pairsSet = generatePairs(cakes, D);
        long minCuts = calculateMinCuts(cakes, D, pairsSet);
        
        System.out.println(minCuts);
    }

    private static Set<Pair> generatePairs(long[] cakes, int D) {
        Set<Pair> pairsSet = new HashSet<>();
        for (long cake : cakes) {
            for (long j = 1; j <= D; j++) {
                pairsSet.add(new Pair(cake, j));
            }
        }
        return pairsSet;
    }

    private static long calculateMinCuts(long[] cakes, int D, Set<Pair> pairsSet) {
        long minCuts = Long.MAX_VALUE;
        for (Pair pair : pairsSet) {
            long counter = 0;
            long cuts = 0;
            for (long cake : cakes) {
                if ((cake * pair.y) % pair.x == 0) {
                    counter += cake * pair.y / pair.x;
                    cuts += cake * pair.y / pair.x - 1;
                }
                if (counter >= D) {
                    minCuts = Math.min(cuts, minCuts);
                    break;
                }
            }
            for (long cake : cakes) {
                if ((cake * pair.y) % pair.x != 0) {
                    counter += cake * pair.y / pair.x;
                    cuts += cake * pair.y / pair.x;
                }
                if (counter >= D) {
                    minCuts = Math.min(cuts, minCuts);
                    break;
                }
            }
        }
        return minCuts;
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