import java.util.Arrays;
import java.util.Scanner;

class C {
    public static void main(String... args) throws Exception {
        try (final Scanner sc = new Scanner(System.in)) {
            final int T = sc.nextInt();
            for (int t = 1; t <= T; t++) {
                final int N = sc.nextInt();
                final int D = sc.nextInt();
                final long[] A = new long[N];
                Arrays.setAll(A, $ -> sc.nextLong());
                Arrays.sort(A);
                if (D > 3)
                    throw null;

                System.out.printf("Case #%s: %d\n", t, D == 2 ? two(A) : three(A));
            }
        }
    }

    public static int two(long[] A) {
        for (int i = 1; i < A.length; i++)
            if (A[i - 1] == A[i])
                return 0;
        return 1;
    }

    public static int three(long[] A) {
        for (int i = 2; i < A.length; i++)
            if (A[i - 2] == A[i - 1] && A[i - 1] == A[i])
                return 0;
        for (int i = 1; i < A.length; i++)
            if (A[i] % 2 == 0) {
                if (Arrays.binarySearch(A, 0, i, A[i] / 2) >= 0)
                    return 1;
            }
        return 2;
    }
}
public class Solution {
    public static void main(String...args) throws Exception {
        C.main();
    }
}
