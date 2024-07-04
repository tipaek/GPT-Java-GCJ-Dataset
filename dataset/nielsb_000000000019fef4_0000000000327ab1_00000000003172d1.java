import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            long solution = new Solution(scanner).solve();
            System.out.println("Case #" + t + ": " + solution);
        }
    }

    final int N, D;
    final long[] A;
    final Set<Long> distinctA = new HashSet<>();

    public Solution(Scanner scanner) {
        N = scanner.nextInt();
        D = scanner.nextInt();
        A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
            distinctA.add(A[i]);
        }
    }

    private long solve() {
        Set<Long> cuts = new HashSet<>();
        for (int d = 1; d <= D; d++) {
            for (long a : distinctA) {
                cuts.add(calculateCuts(a, d));
            }
        }
        return cuts.stream().mapToLong(i -> i).min().getAsLong();
    }

    private long calculateCuts(long n, int d) {
        List<CutAPiece> cutAPieces = Arrays.stream(A)
                .mapToObj(a -> CutAPiece.of(a, n, d))
                .sorted()
                .collect(Collectors.toList());

        //System.out.println(cutAPieces);

        int pieces = 0;
        int cuts = 0;
        for (CutAPiece cp : cutAPieces) {
            if (pieces + cp.slices > D) {
                return cuts + D - pieces;
            } else if (pieces + cp.slices == D) {
                return cuts + cp.cuts;
            } else {
                pieces += cp.slices;
                cuts += cp.cuts;
            }
        }
        return Long.MAX_VALUE;
    }

    static class CutAPiece implements Comparable<CutAPiece> {
        long slices;
        long cuts;

        public CutAPiece(long slices, long cuts) {
            this.slices = slices;
            this.cuts = cuts;
        }

        public static CutAPiece of(long a, long n, int d) {
            if (a * d == n) {
                return new CutAPiece(1, 0);
            } else if (a * d % n == 0) {
                return new CutAPiece(a * d / n, a * d / n - 1);
            } else {
                return new CutAPiece(a * d / n, a * d / n);
            }
        }

        @Override
        public int compareTo(CutAPiece that) {
            if (this.slices - this.cuts == that.slices - that.cuts) {
                if (this.slices < that.slices) {
                    return -1;
                } else if (this.slices == that.slices) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (this.slices - this.cuts < that.slices - that.cuts) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "CutAPiece{" +
                    "slices=" + slices +
                    ", cuts=" + cuts +
                    '}';
        }
    }

}
