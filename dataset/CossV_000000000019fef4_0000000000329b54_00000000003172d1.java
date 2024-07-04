import java.util.*;

public class Solution {

    public static int minCuts(long[] a, int pos, long peopleRem, long sliceSize) {
        int res = 0;

        if (peopleRem <= 0) {
            return 0;
        }
        if (pos < 0) {
            return Integer.MAX_VALUE;
        } else {
            if (a[pos] < sliceSize) {
                return minCuts(a, pos - 1, peopleRem, sliceSize);
            } else if (a[pos] == sliceSize) {
                return minCuts(a, pos - 1, peopleRem - 1, sliceSize);
            } else {
                // we don't cut it
                int min2 = minCuts(a, pos - 1, peopleRem, sliceSize);
                // we cut it
                long[] b = a.clone();
                b[pos] = b[pos] - sliceSize;
                int min1 = minCuts(b, pos, peopleRem - 1, sliceSize) + 1;
                res = Math.min(min1, min2);
            }
        }


        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            String[] nd = sc.nextLine().split(" ");
            int n = Integer.parseInt(nd[0]);
            int d = Integer.parseInt(nd[1]);
            long[] a = new long[n];
            String[] aString = sc.nextLine().split(" ");
            for (int i = 0; i < aString.length; i++) {
                a[i] = Long.parseLong(aString[i]);
            }
            Arrays.sort(a);

            long min = Integer.MAX_VALUE;
            if (a.length >= d) {
                for (int i = 0; i < d; i++) {
                    long currMin = minCuts(a, a.length - 1, d, a[i]);
                    if (currMin < min) {
                        min = currMin;
                    }
                }
            } else {
                long[] b = a.clone();
                for (int i = 0; i < b.length; i++) {
                    b[i] = b[i] * d;
                }
                min = minCuts(b, b.length - 1, d, a[0]);
                int minCandidate = minCuts(b, b.length - 1, d, b[0]);
                if (minCandidate < min) {
                    min = minCandidate;
                }
            }

            System.out.println("Case #" + k + ": " + min);
        }
    }
}
