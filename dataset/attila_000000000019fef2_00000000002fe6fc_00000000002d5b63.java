//package codejam2020b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static final int POW = (int) Math.pow(10, 9);

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] line = sc.readLine().split(" ");
        int ttt = Integer.parseInt(line[0]);
        int a = Integer.parseInt(line[1]);
        int b = Integer.parseInt(line[2]);

        for (int tt = 1; tt <= ttt; tt++) {

            int d = POW - a;

            long left = bsFirst(-1 * POW, -1 * POW + 3 * d, 'x', sc);
            long top = bsFirst(-1 * POW, -1 * POW + 3 * d, 'y', sc);
            long right = bsLast(POW - 3 * d, POW, 'x', sc);
            long bottom = bsLast(POW - 3 * d, POW, 'y', sc);

            long cx = (left + right) / 2L;
            long cy = (top + bottom) / 2L;

            outer:
            for (long i = cx - 2; i <= cx + 2; i++) {
                for (long j = cy - 2; j <= cy + 2; j++) {
                    System.out.println(i + " " + j);
                    System.out.flush();
                    String answ = sc.readLine();
                    if (answ.equals("CENTER")) {
                        break outer;
                    } else if (answ.equals("WRONG")) {
                        throw new IllegalStateException("wrong :(");
                    }
                }
            }
        }
    }

    private static long bsLast(long left, long right, char x, BufferedReader sc) throws IOException {
        long lastHit = -1;
        while (left <= right) {
            long mid = (left + right) / 2L;
            if (x == 'x') {
                System.out.println(mid + " 0");
            } else if (x == 'y') {
                System.out.println("0 " + mid);
            }
            System.out.flush();
            String answ = sc.readLine();
            if (answ.equals("HIT")) {
                lastHit = mid;
                left = mid + 1;
            } else if (answ.equals("MISS")) {
                right = mid - 1;
            } else {
                throw new IllegalStateException("??");
            }
        }
        return lastHit;
    }

    private static long bsFirst(long left, long right, char x, BufferedReader sc) throws IOException {

        long firstHit = -1;
        while (left <= right) {
            long mid = (left + right) / 2L;
            if (x == 'x') {
                System.out.println(mid + " 0");
            } else if (x == 'y') {
                System.out.println("0 " + mid);
            }
            System.out.flush();
            String answ = sc.readLine();
            if (answ.equals("HIT")) {
                firstHit = mid;
                right = mid - 1;
            } else if (answ.equals("MISS")) {
                left = mid + 1;
            } else {
                throw new IllegalStateException("??");
            }
        }
        return firstHit;
    }
}
