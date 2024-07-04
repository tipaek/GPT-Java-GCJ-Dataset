import java.util.BitSet;
import java.util.Scanner;

class A {
    public static void main(String... args) throws Exception {
        try (final Scanner sc = new Scanner(System.in)) {
            final int T = sc.nextInt();
            for (int t = 1; t <= T; t++) {
                final int N = sc.nextInt();
                final int[][] M = new int[N][N];
                for (int i = 0; i < N; i++)
                    for (int j = 0; j < N; j++)
                        M[i][j] = sc.nextInt();
                int k = 0;
                for (int i = 0; i < N; i++)
                    k += M[i][i];
                int r = 0;
                for (int i = 0; i < N; i++) {
                    final BitSet bs = new BitSet(N + 1);
                    for (int j = 0; j < N; j++)
                        bs.set(M[i][j]);
                    if (bs.cardinality() < N)
                        r++;
                }
                int c = 0;
                for (int i = 0; i < N; i++) {
                    final BitSet bs = new BitSet(N + 1);
                    for (int j = 0; j < N; j++)
                        bs.set(M[j][i]);
                    if (bs.cardinality() < N)
                        c++;
                }
                System.out.printf("Case #%s: %s %s %s\n", t, k, r, c);
            }
        }
    }
}
public class Solution {
    public static void main(String...args) throws Exception {
        A.main();
    }
}
