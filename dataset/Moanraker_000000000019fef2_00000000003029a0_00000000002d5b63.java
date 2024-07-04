import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] tokens = br.readLine().split("\\s+");
        long T = clong(tokens[0]), A = clong(tokens[1]), B = clong(tokens[2]);
        for (int i = 1; i <= T; i++) {
            oneRun(i, A, B);
        }
    }

    static boolean madeIt = false;

    static long small = -1000000000L, big = 1000000000L;
    private static void oneRun(int num, long A, long B) throws IOException {
        madeIt = false;
        for (long x = small + A; x <= big - A; x += A) {
            for (long y = small + A; x <= big - A; y += A) {
                boolean b = hit(x, y);
                if (madeIt) return;

                if (b) {
                    // x left
                    long left = x - A;
                    long right = x;
                    long mid = 0;
                    while (left <= right) {
                        mid = left + (right - left) / 2;

                        b = hit(mid, y);
                        if (madeIt) return;

                        if (b) { // too far right
                            right = mid - 1;
                        } else { // too far left
                            left = mid + 1;
                        }
                    }
                    long xLeft = mid;
                    // x right
                    left = x;
                    right = big;
                    while (left <= right) {
                        mid = left + (right - left) / 2;

                        b = hit(mid, y);
                        if (madeIt) return;

                        if (b) { // too far left
                            left = mid + 1;
                        } else { // too far right
                            right = mid - 1;
                        }
                    }
                    long xRight = mid;
                    // y bottom
                    long bottom = y - A;
                    long top = y;
                    while (bottom <= top) {
                        mid = bottom + (top - bottom) / 2;

                        b = hit(x, mid);
                        if (madeIt) return;

                        if (b) { // too far up
                            top = mid - 1;
                        } else { // too far down
                            bottom = mid + 1;
                        }
                    }
                    long yBottom = mid;
                    // y top
                    bottom = y;
                    top = big;
                    while (bottom <= top) {
                        mid = bottom + (top - bottom) / 2;

                        b = hit(x, mid);
                        if (madeIt) return;

                        if (b) { // too far down
                            bottom = mid + 1;
                        } else { // too far up
                            top = mid - 1;
                        }
                    }
                    long yTop = mid;

                    long xMid = xLeft + (xRight - xLeft) / 2;
                    long yMid = yBottom + (yTop - yBottom) / 2;

                    for (long v = xMid - 5; v <= xMid + 5; v+= 1) {
                        for (long w = yMid - 5; w <= yMid + 5; w += 1) {
                            b = hit(v, w);
                            if (madeIt) return;
                        }
                    }
                }
            }
        }
    }

    private static boolean hit(long x, long y) throws IOException {
        System.out.println(x + " " + y);
        String response = br.readLine();

        if (response.equals("HIT")) {
            return true;
        }
        if (response.equals("CENTER")) {
            madeIt = true;
            return true;
        }
        if (response.equals("WRONG")) {
            madeIt = false;
            return false;
        }
        if (response.equals("MISS")) {
            return false;
        }
        return false;
    }

    static long clong(String s) {
        return Long.parseLong(s);
    }
}
