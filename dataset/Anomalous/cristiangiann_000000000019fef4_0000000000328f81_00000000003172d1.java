import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            long[] slices = new long[N];

            for (int i = 0; i < N; i++) {
                slices[i] = scanner.nextLong();
            }

            Arrays.sort(slices);
            int result = determineResult(N, D, slices);

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static int determineResult(int N, int D, long[] slices) {
        if (D == 2) {
            for (int i = 0; i < N - 1; i++) {
                if (slices[i] == slices[i + 1]) {
                    return 0;
                }
            }
            return 1;
        } else {
            for (int i = 0; i < N - 2; i++) {
                if (slices[i] == slices[i + 1] && slices[i + 1] == slices[i + 2]) {
                    return 0;
                }
                if (slices[i] == slices[i + 1] || existHalf(slices[i], slices)) {
                    return 1;
                }
            }
            return 2;
        }
    }

    private static boolean existHalf(long value, long[] slices) {
        double halfValue = (double) value / 2;
        for (long slice : slices) {
            if ((double) slice == halfValue) {
                return true;
            }
        }
        return false;
    }
}