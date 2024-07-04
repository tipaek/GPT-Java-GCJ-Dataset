import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int p, t;
        p = t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            long[] slices = new long[n];

            for (int i = 0; i < n; i++) {
                slices[i] = sc.nextLong();
            }

            Arrays.sort(slices);
            int ans = determineAnswer(n, d, slices);
            System.out.println("Case #" + (p - t) + ": " + ans);
        }
    }

    private static int determineAnswer(int n, int d, long[] slices) {
        if (d == 2) {
            return checkForDuplicates(n, slices) ? 0 : 1;
        } else if (d == 3) {
            int result = checkForTriplets(n, slices);
            if (result != 2) return result;

            result = checkForPairs(n, slices);
            if (result != 2) return result;

            return checkForHalfPairs(n, slices);
        } else {
            return 1;
        }
    }

    private static boolean checkForDuplicates(int n, long[] slices) {
        for (int i = 1; i < n; i++) {
            if (slices[i] == slices[i - 1]) {
                return true;
            }
        }
        return false;
    }

    private static int checkForTriplets(int n, long[] slices) {
        for (int i = 2; i < n; i++) {
            if (slices[i] == slices[i - 1] && slices[i] == slices[i - 2]) {
                return 0;
            }
        }
        return 2;
    }

    private static int checkForPairs(int n, long[] slices) {
        for (int i = 1; i < n; i++) {
            if (slices[i] == slices[i - 1] && i < n - 1) {
                return 1;
            }
        }
        return 2;
    }

    private static int checkForHalfPairs(int n, long[] slices) {
        for (int i = 1; i < n; i++) {
            if (slices[i] % 2 == 1) continue;
            if (binarySearch(slices, slices[i] / 2)) {
                return 1;
            }
        }
        return 2;
    }

    private static boolean binarySearch(long[] arr, long target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}