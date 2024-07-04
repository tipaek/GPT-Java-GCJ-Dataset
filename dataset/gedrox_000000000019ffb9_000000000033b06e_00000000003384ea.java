import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main2(String[] args) {

        for (int R = 1; R < 1000; R++) {
        for (int L = 1; L < 1000; L++) {
         long[] b = brute(L, R);
         long[] a = smart(L, R);
         if (!Arrays.toString(b).equals(Arrays.toString(a))) {
             System.err.println(L);
             System.err.println(R);
             return;
         }
        }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long L = sc.nextLong();
            long R = sc.nextLong();

//            long[] ansBrute = brute(L, R);
            long[] ans = smart(L, R);

//            System.err.println(Arrays.toString(ansBrute));
//            System.err.println(Arrays.toString(ans));


            System.out.printf("Case #%d: %d %d %d%n", i + 1, ans[0], ans[1], ans[2]);
        }

    }



    private static long[] brute(long L, long R) {
        long j;
        for (j = 1L; j <= L || j <= R; j++) {
            if (L >= R) {
//                System.err.print('L');
                L -= j;
            } else {
//                System.err.print('R');
                R -= j;
            }
        }
        return new long[]{j - 1, L, R};
    }

    private static long[] smart(long L, long R) {

        long diff = Math.abs(L - R);
        long cnt = Math.max(0, (long)((Math.sqrt(8 * diff + 1) - 1) / 2 - 1));
        while (diff > cnt * (cnt + 1) / 2) {
            cnt++;
        }

        if (L >= R) {
            L -= cnt * (cnt + 1) / 2;
        } else {
            R -= cnt * (cnt + 1) / 2;
        }

        long sL, sR;
        char start;

        if (R > L) {
            sR = cnt + 1;
            sL = cnt + 2;
            start = 'R';
        } else {
            sR = cnt + 2;
            sL = cnt + 1;
            start = 'L';
        }

        long remL = (long)((Math.sqrt((sL - 1) * (sL - 1) + 4 * L) - (sL - 1)) / 2 - 1);
        long remR = (long)((Math.sqrt((sR - 1) * (sR - 1) + 4 * R) - (sR - 1)) / 2 - 1);

        long steps = Math.min(remL, remR);

        L -= steps * sL + steps * (steps - 1);
        R -= steps * sR + steps * (steps - 1);

        long nxt = cnt + 2 * steps;

        while (true) {
            if (start == 'L') {
                if (L < nxt + 1) {
                    break;
                }
                nxt++;
                L -= nxt;
                start = 'R';
            } else {
                if (R < nxt + 1) {
                    break;
                }
                nxt++;
                R -= nxt;
                start = 'L';
            }
        }

        return new long[]{nxt, L, R};
    }
}
