import java.io.*;
import java.util.*;
class Solution {

    static int A, B;
    static int srchlen;

    static Scanner sc;
    static void testcase(int no) {

        int leftx, rightx;
        leftx = rightx = 0;

        for (int i = -1000000000; i + 1000000000 <= srchlen; i++) {
            System.out.printf("%d 1000000000\n", i);

            String res = sc.next();

            if (res.equals("HIT")) { leftx = i; break; }

        }

        for (int i = 1000000000; i - 1000000000 + srchlen >= 0; i--) {
            System.out.printf("%d 1000000000\n", i);

            String res = sc.next();

            if (res.equals("HIT")) { rightx = i; break; }
        }

        long cx = (((long) leftx) + rightx)/2L;

        long dcenter = cx - leftx;

        long rad = A;
        long dy = (long) Math.sqrt(rad*rad - dcenter*dcenter);


        /* Try general vicinity of center. */
        for (int i = -2; i < 2; i++) {
            for (int j = -2; j < 2; j++) {

                System.out.printf("%d %d\n", cx + i, 1000000000 + dy + j);
                String res = sc.next();
                if (res.equals("CENTER")) { return; }
            }
        }

        /* Try general vicinity of center. */
        for (int i = -2; i < 2; i++) {
            for (int j = -2; j < 2; j++) {

                System.out.printf("%d %d\n", cx + i, 1000000000 - dy + j);
                String res = sc.next();
                if (res.equals("CENTER")) { return; }
            }
        }


    }
    public static void main(String args[]) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        srchlen = -2*(A - 1000000000);
        for (int i = 0; i < n; i++) {
            testcase(i + 1);
        }
    }
}