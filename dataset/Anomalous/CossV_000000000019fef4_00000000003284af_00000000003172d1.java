import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static int minCuts(long[] a, int pos, long peopleRem, long sliceSize) {
        if (peopleRem == 0) {
            return 0;
        }
        if (pos < 0 && peopleRem > 0) {
            return Integer.MAX_VALUE;
        }

        if (a[pos] < sliceSize) {
            return minCuts(a, pos - 1, peopleRem, sliceSize);
        } else if (a[pos] == sliceSize) {
            return minCuts(a, pos - 1, peopleRem - 1, sliceSize);
        } else {
            int withoutCut = minCuts(a, pos - 1, peopleRem, sliceSize);
            long[] b = a.clone();
            b[pos] -= sliceSize;
            int withCut = minCuts(b, pos, peopleRem - 1, sliceSize) + 1;
            return Math.min(withCut, withoutCut);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            String[] nd = sc.nextLine().split(" ");
            int n = Integer.parseInt(nd[0]);
            int d = Integer.parseInt(nd[1]);
            long[] a = Arrays.stream(sc.nextLine().split(" "))
                             .mapToLong(Long::parseLong)
                             .toArray();
            Arrays.sort(a);

            long min = Integer.MAX_VALUE;
            if (a.length >= d) {
                for (int i = 0; i < d; i++) {
                    min = Math.min(min, minCuts(a, a.length - 1, d, a[i]));
                }
            } else {
                long[] b = Arrays.copyOf(a, a.length);
                for (int i = 0; i < b.length; i++) {
                    b[i] *= d;
                }
                min = minCuts(b, b.length - 1, d, a[0]);
                min = Math.min(min, minCuts(b, b.length - 1, d, b[0]));
            }

            System.out.println("Case #" + k + ": " + min);
        }
    }
}