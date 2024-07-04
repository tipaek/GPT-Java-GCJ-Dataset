import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            long x = in.nextLong();
            long y = in.nextLong();
            System.out.println("Case #" + i + ": " + getPath(x, y));
        }
    }

    private static String getPath(long x, long y) {
        if (x % 2 == y % 2) {
            return "IMPOSSIBLE";
        }

        long ax = Math.abs(x);
        long ay = Math.abs(y);
        String bx = getBinary(ax);
        String by = getBinary(ay);

        if (noZeroes(bx, by)) {
            // return
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < Math.max(bx.length(), by.length()); i++) {
                if (i < bx.length() && bx.charAt(i) == '1') {
                    answer.append(x > 0 ? 'E' : 'W');
                } else {
                    answer.append(y > 0 ? 'N' : 'S');
                }
            }

            return answer.toString();
        } else {
            {
                String ix = getInverseBinary(by);
                StringBuilder answer = new StringBuilder();
                long rx = 0, pow = 1;
                for (int i = 0; i < ix.length(); i++) {
                    if (ix.charAt(i) == '1') {
                        answer.append(x > 0 ? 'W' : 'E');
                        rx -= pow;
                    } else {
                        answer.append(y > 0 ? 'N' : 'S');
                    }

                    pow *= 2;
                }

                while (rx < ax) {
                    rx += pow;
                    pow *= 2;
                    answer.append(x > 0 ? 'E' : 'W');
                }

                if (rx == ax) {
                    return answer.toString();
                }
            }

            String iy = getInverseBinary(bx);
            StringBuilder answer = new StringBuilder();
            long ry = 0, pow = 1;
            for (int i = 0; i < iy.length(); i++) {
                if (iy.charAt(i) == '1') {
                    answer.append(y > 0 ? 'S' : 'N');
                    ry -= pow;
                } else {
                    answer.append(x > 0 ? 'E' : 'W');
                }

                pow *= 2;
            }

            while (ry < ay) {
                ry += pow;
                pow *= 2;
                answer.append(y > 0 ? 'N' : 'S');
            }

            if (ry == ay) {
                return answer.toString();
            }
        }

         return "IMPOSSIBLE";
    }

    private static String getBinary(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        return new StringBuilder(Long.toBinaryString(n)).reverse().toString();
    }

    private static boolean noZeroes(String bx, String by) {
        for (int i = 0; i < Math.max(bx.length(), by.length()); i++) {
            if (i < bx.length() && i < by.length() && bx.charAt(i) == by.charAt(i)) return false;
            else if (i >= bx.length() && by.charAt(i) == '0') return false;
            else if (i >= by.length() && bx.charAt(i) == '0') return false;
        }

        return true;
    }

    private static String getInverseBinary(String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            sb.append(b.charAt(i) == '1' ? '0' : '1');
        }

        return sb.toString();
    }
}