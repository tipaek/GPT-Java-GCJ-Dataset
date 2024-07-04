import java.io.*;
import java.util.*;

public class Solution {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        long border = 1000 * 1000 * 1000; // 10^9

        for (int i = 1; i <= t; i++) {
            boolean hitcenter = false;
            long hitx = 0, hity = 0;

            // Initial grid search to find a HIT or CENTER
            outerLoop:
            for (int j = 1; j <= 7; j++) {
                for (int k = 1; k <= 7; k++) {
                    long x1 = -border + 2 * border * j / 7;
                    long y1 = -border + 2 * border * k / 7;
                    System.out.println(x1 + " " + y1);
                    System.out.flush();
                    String judge = sc.next();
                    check(judge);

                    if (judge.equals("HIT") || judge.equals("CENTER")) {
                        hitx = x1;
                        hity = y1;
                        if (judge.equals("CENTER")) {
                            hitcenter = true;
                            break outerLoop;
                        }
                    }
                }
            }

            if (hitcenter) continue;

            // Binary search for the rightmost HIT
            long rightmost = binarySearchRightmost(hitx, hity, border);

            // Binary search for the upmost HIT
            long upmost = binarySearchUpmost(rightmost, hity, border);

            // Binary search for the downmost HIT
            long downmost = binarySearchDownmost(rightmost, hity, border);

            // Binary search for the leftmost HIT
            long leftmost = binarySearchLeftmost(upmost, border);

            // Find the center
            long cenx = (leftmost + rightmost) / 2;
            long ceny = (upmost + downmost) / 2;

            // Fine-tune to find the exact CENTER
            fineTuneCenter(cenx, ceny);
        }
    }

    public static void check(String s) {
        if (s.equals("WRONG")) {
            System.exit(1);
        }
    }

    private static long binarySearchRightmost(long hitx, long hity, long border) {
        long l = hitx, r = border, rightmost = Long.MIN_VALUE;
        while (l <= r) {
            long m = (l + r) / 2;
            System.out.println(m + " " + hity);
            System.out.flush();
            String judge = sc.next();
            check(judge);

            if (judge.equals("HIT") || judge.equals("CENTER")) {
                rightmost = Math.max(rightmost, m);
                l = m + 1;
            } else if (judge.equals("MISS")) {
                r = m - 1;
            }
        }
        return rightmost;
    }

    private static long binarySearchUpmost(long rightmost, long hity, long border) {
        long d = border, u = -border, upmost = Long.MAX_VALUE;
        while (u <= d) {
            long m = (u + d) / 2;
            System.out.println(rightmost + " " + m);
            System.out.flush();
            String judge = sc.next();
            check(judge);

            if (judge.equals("HIT") || judge.equals("CENTER")) {
                upmost = Math.min(upmost, m);
                d = m - 1;
            } else if (judge.equals("MISS")) {
                u = m + 1;
            }
        }
        return upmost;
    }

    private static long binarySearchDownmost(long rightmost, long hity, long border) {
        long d = border, u = -border, downmost = Long.MIN_VALUE;
        while (u <= d) {
            long m = (u + d) / 2;
            System.out.println(rightmost + " " + m);
            System.out.flush();
            String judge = sc.next();
            check(judge);

            if (judge.equals("HIT") || judge.equals("CENTER")) {
                downmost = Math.max(downmost, m);
                u = m + 1;
            } else if (judge.equals("MISS")) {
                d = m - 1;
            }
        }
        return downmost;
    }

    private static long binarySearchLeftmost(long upmost, long border) {
        long l = -border, r = border, leftmost = Long.MIN_VALUE;
        while (l <= r) {
            long m = (l + r) / 2;
            System.out.println(m + " " + upmost);
            System.out.flush();
            String judge = sc.next();
            check(judge);

            if (judge.equals("HIT") || judge.equals("CENTER")) {
                leftmost = Math.min(leftmost, m);
                r = m - 1;
            } else if (judge.equals("MISS")) {
                l = m + 1;
            }
        }
        return leftmost;
    }

    private static void fineTuneCenter(long cenx, long ceny) {
        boolean hitcenter = false;
        for (long j = -4; j <= 4; j++) {
            if (hitcenter) break;
            for (long k = -4; k <= 4; k++) {
                if (hitcenter) break;
                long x1 = cenx + j;
                long x2 = ceny + k;
                System.out.println(x1 + " " + x2);
                System.out.flush();
                String judge = sc.next();
                check(judge);
                if (judge.equals("CENTER")) {
                    hitcenter = true;
                } else if (judge.equals("WRONG")) {
                    System.exit(0);
                }
            }
        }
    }
}