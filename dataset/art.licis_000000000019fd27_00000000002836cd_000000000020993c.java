import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int k = 0;
            final Set<Integer>[] rowNums = createEmptySets(n);
            BitSet rowDups = new BitSet(n);
            final Set<Integer>[] colNums = createEmptySets(n);
            BitSet colDups = new BitSet(n);

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int num = sc.nextInt();
                    if (!rowNums[r].add(num)) rowDups.set(r);
                    if (!colNums[c].add(num)) colDups.set(c);

                    if (r == c) k += num;
                }
            }

            System.out.printf("Case %d: %d %d %d%n", tc, k, rowDups.cardinality(), colDups.cardinality());
        }
        System.out.flush();
    }

    private static Set<Integer>[] createEmptySets(int n) {
        final Set<Integer>[] numSets = new Set[n];
        for (int i = 0; i < n; i++) {
            numSets[i] = new HashSet<>();
        }

        return numSets;
    }
}