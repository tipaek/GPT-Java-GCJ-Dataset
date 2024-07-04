package main;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        PrintWriter out = new PrintWriter(System.out);

        int T = in.nextInt();
        testing:
        for (int ntest = 1; ntest <= T; ntest++) {
            int A = in.nextInt();
            int B = in.nextInt();

            long minX = -1000000001;
            long maxX = 1000000001;
            long minY = -1000000001;
            long maxY = 1000000001;

            long pc = 500000000;

            long cx = minX + 1, cy = minY + 1;
            while (true) {
                out.println(cx + " " + cy);
                out.flush();
                String s = in.next();

                if (s.equals("CENTER")) {
                    continue testing;
                }
                if (s.equals("HIT")) {
                    break;
                }

                cx += pc;
                if (cx >= maxX) {
                    cx = minX + 1;
                    cy += pc;
                }
            }

            long xn = cx;
            long xp = cx;
            long yn = cy;
            long yp = cy;

            while (minX + 1 < xn) {
                long mid = (minX + xn) / 2;
                out.println(mid + " " + cy);
                out.flush();
                String s = in.next();
                if (s.equals("CENTER")) {
                    continue testing;
                }
                if (s.equals("HIT")) {
                    xn = mid;
                } else {
                    minX = mid;
                }
            }

            while (xp + 1 < maxX) {
                long mid = (maxX + xp) / 2;
                out.println(mid + " " + cy);
                out.flush();
                String s = in.next();
                if (s.equals("CENTER")) {
                    continue testing;
                }
                if (s.equals("HIT")) {
                    xp = mid;
                } else {
                    maxX = mid;
                }
            }

            cx = (xn + xp) / 2;

            while (minY + 1 < yn) {
                long mid = (minY + yn) / 2;
                out.println(cx + " " + mid);
                out.flush();
                String s = in.next();
                if (s.equals("CENTER")) {
                    continue testing;
                }
                if (s.equals("HIT")) {
                    yn = mid;
                } else {
                    minY = mid;
                }
            }

            while (yp + 1 < maxY) {
                long mid = (maxY + yp) / 2;
                out.println(cx + " " + mid);
                out.flush();
                String s = in.next();
                if (s.equals("CENTER")) {
                    continue testing;
                }
                if (s.equals("HIT")) {
                    yp = mid;
                } else {
                    maxY = mid;
                }
            }

            cy = (yn + yp) / 2;

            out.println(cx + " " + cy);
            out.flush();
            String s = in.next();
            if (s.equals("CENTER")) {
                continue testing;
            }

            throw new IllegalStateException("WTF");
        }
    }
}
