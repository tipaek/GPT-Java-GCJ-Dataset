import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numSlices = scanner.nextInt();
            int divisor = scanner.nextInt();
            long[] slices = new long[numSlices];
            int result = 0;

            for (int i = 0; i < numSlices; i++) {
                slices[i] = scanner.nextLong();
            }

            Arrays.sort(slices);

            if (divisor == 2) {
                result = 1;
                for (int i = 0; i < numSlices - 1; i++) {
                    if (slices[i] == slices[i + 1]) {
                        result = 0;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < numSlices - 1; i++) {
                    if (i < numSlices - 2 && slices[i] == slices[i + 1] && slices[i + 1] == slices[i + 2]) {
                        break;
                    }
                    if (slices[i] == slices[i + 1]) {
                        if (i == 0) {
                            result = 1;
                        }
                    }
                    if (existsHalf(slices[i], slices)) {
                        result = 1;
                    }
                }
                if (existsHalf(slices[numSlices - 1], slices)) {
                    result = 1;
                }
                if (result != 1) {
                    result = 2;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static boolean existsHalf(long value, long[] slices) {
        double halfValue = value / 2.0;
        for (long slice : slices) {
            if ((double) slice == halfValue) {
                return true;
            }
        }
        return false;
    }
}