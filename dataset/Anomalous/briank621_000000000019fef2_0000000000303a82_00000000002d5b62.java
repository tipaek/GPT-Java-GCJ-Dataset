import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean cover(String x, String y) {
        if (y.length() > x.length()) {
            return cover(y, x);
        }
        int xl = x.length(), yl = y.length();
        for (int i = 0; i < yl; i++) {
            if (x.charAt(xl - 1 - i) == y.charAt(yl - 1 - i)) {
                return false;
            }
        }
        for (int i = 0; i < xl - yl; i++) {
            if (x.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }

    public static String negate(String x) {
        StringBuilder sb = new StringBuilder();
        boolean foundZero = false;
        for (char c : x.toCharArray()) {
            if (c == '0') {
                foundZero = true;
            }
            if (foundZero) {
                sb.append(c == '0' ? '1' : '0');
            }
        }
        return sb.toString();
    }

    public static int startsWithOnes(String x) {
        int index = x.indexOf('0');
        if (index == -1) return 0; 
        for (int i = index; i < x.length(); i++) {
            if (x.charAt(i) == '1') return -1;
        }
        return x.length() - index;
    }

    public static String flipX(String s) {
        return s.replace('E', 'X').replace('W', 'E').replace('X', 'W');
    }

    public static String flipY(String s) {
        return s.replace('N', 'X').replace('S', 'N').replace('X', 'S');
    }

    public static String build(String x, String y, String negX, String negY) {
        StringBuilder sb = new StringBuilder();
        int maxLength = Math.max(Math.max(x.length(), y.length()), Math.max(negX.length(), negY.length()));
        for (int i = 0; i < maxLength; i++) {
            if (i < x.length() && x.charAt(x.length() - 1 - i) == '1') {
                sb.append('E');
            } else if (i < y.length() && y.charAt(y.length() - 1 - i) == '1') {
                sb.append('N');
            } else if (i < negX.length() && negX.charAt(negX.length() - 1 - i) == '1') {
                sb.append('W');
            } else if (i < negY.length() && negY.charAt(negY.length() - 1 - i) == '1') {
                sb.append('S');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            String[] l = br.readLine().split(" ");
            int x = Integer.parseInt(l[0]);
            int y = Integer.parseInt(l[1]);
            boolean fx = false, fy = false;

            if (x < 1) {
                x = -x;
                fx = true;
            }
            if (y < 1) {
                y = -y;
                fy = true;
            }

            String sx = Integer.toBinaryString(x);
            String sy = Integer.toBinaryString(y);
            int minLength = Integer.MAX_VALUE;
            String ans = "";

            if (cover(sx, sy)) {
                String s = build(sx, sy, "", "");
                if (s.length() < minLength) {
                    minLength = s.length();
                    ans = s;
                }
            }

            String flipY = negate(sy);
            String flipX = negate(sx);
            int nx = Integer.parseInt(flipX, 2);
            int ny = Integer.parseInt(flipY, 2);
            int kx = nx + y;
            int ky = ny + x;
            String k = Integer.toBinaryString(kx);
            String kk = Integer.toBinaryString(ky);

            if ((kx & x) == 0 && (kx & nx) == 0 && startsWithOnes(k) == sx.length()) {
                String s = build(sx, k, "", flipX);
                if (s.length() < minLength) {
                    minLength = s.length();
                    ans = s;
                }
            }

            if ((ky & y) == 0 && (ky & ny) == 0 && startsWithOnes(kk) == sy.length()) {
                String s = build(kk, sy, flipY, "");
                if (s.length() < minLength) {
                    minLength = s.length();
                    ans = s;
                }
            }

            if (fx) {
                ans = flipX(ans);
            }
            if (fy) {
                ans = flipY(ans);
            }

            if (ans.isEmpty()) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", tc);
            } else {
                System.out.printf("Case #%d: %s\n", tc, ans);
            }
        }
    }
}