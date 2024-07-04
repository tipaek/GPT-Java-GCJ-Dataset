import java.util.Arrays;
import java.util.Scanner;

class C {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int t = 1; t <= T; t++) {
                int N = sc.nextInt();
                int D = sc.nextInt();
                long[] A = new long[N];
                for (int i = 0; i < N; i++) {
                    A[i] = sc.nextLong();
                }
                Arrays.sort(A);
                if (D > 3) {
                    throw new IllegalArgumentException("D should be 2 or 3");
                }

                int result = (D == 2) ? checkTwo(A) : checkThree(A);
                System.out.printf("Case #%d: %d\n", t, result);
            }
        }
    }

    private static int checkTwo(long[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                return 0;
            }
        }
        return 1;
    }

    private static int checkThree(long[] A) {
        for (int i = 2; i < A.length; i++) {
            if (A[i - 2] == A[i - 1] && A[i - 1] == A[i]) {
                return 0;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (Arrays.binarySearch(A, i + 1, A.length, A[i] * 2) >= 0) {
                return 1;
            }
        }
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] == A[i]) {
                return 1;
            }
        }
        return 2;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        C.main(args);
    }
}