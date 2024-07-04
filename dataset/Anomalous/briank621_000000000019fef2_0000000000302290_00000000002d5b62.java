import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    public static boolean cover(String x, String y) {
        int xl = x.length();
        int yl = y.length();
        if (yl > xl) return cover(y, x);

        for (int i = 0; i < yl; i++) {
            if (x.charAt(xl - 1 - i) == y.charAt(yl - 1 - i)) {
                return false;
            }
        }

        for (int i = 0; i < xl - yl; i++) {
            if (x.charAt(i) == '0') return false;
        }

        return true;
    }

    public static String negate(String x) {
        StringBuilder sb = new StringBuilder();
        boolean foundZero = false;

        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '0') {
                foundZero = true;
            }
            if (foundZero) {
                sb.append(x.charAt(i) == '0' ? '1' : '0');
            }
        }

        return sb.toString();
    }

    public static int startsWithOnes(String x) {
        int index = 0;

        while (index < x.length() && x.charAt(index) == '1') {
            index++;
        }

        for (int i = index; i < x.length(); i++) {
            if (x.charAt(i) == '1') return -1;
        }

        return x.length() - index;
    }

    public static String flipX(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == 'E') sb.append('W');
            else if (c == 'W') sb.append('E');
            else sb.append(c);
        }

        return sb.toString();
    }

    public static String flipY(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == 'N') sb.append('S');
            else if (c == 'S') sb.append('N');
            else sb.append(c);
        }

        return sb.toString();
    }

    public static String build(String x, String y, String negX, String negY) {
        StringBuilder sb = new StringBuilder();
        int maxLen = Math.max(Math.max(x.length(), y.length()), Math.max(negX.length(), negY.length()));

        for (int i = 0; i < maxLen; i++) {
            if (i < x.length() && x.charAt(x.length() - 1 - i) == '1') sb.append('E');
            else if (i < y.length() && y.charAt(y.length() - 1 - i) == '1') sb.append('N');
            else if (i < negX.length() && negX.charAt(negX.length() - 1 - i) == '1') sb.append('W');
            else if (i < negY.length() && negY.charAt(negY.length() - 1 - i) == '1') sb.append('S');
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
            boolean fx = x < 0;
            boolean fy = y < 0;

            if (fx) x = -x;
            if (fy) y = -y;

            String sx = Integer.toBinaryString(x);
            String sy = Integer.toBinaryString(y);

            String ans = "";
            int minLength = Integer.MAX_VALUE;

            if (cover(sx, sy)) {
                String s = build(sx, sy, "", "");
                if (s.length() < minLength) {
                    minLength = s.length();
                    ans = s;
                }
            }

            String flipY = negate(sy);
            String flipX = negate(sx);
            int kx = Integer.parseInt(flipX, 2) + y;
            String k = Integer.toBinaryString(kx);

            if ((kx & x) == 0 && (kx & Integer.parseInt(flipX, 2)) == 0 && startsWithOnes(k) == sx.length()) {
                String s = build(sx, k, "", flipX);
                if (s.length() < minLength) {
                    minLength = s.length();
                    ans = s;
                }
            }

            int ky = Integer.parseInt(flipY, 2) + x;
            String kk = Integer.toBinaryString(ky);

            if ((ky & y) == 0 && (ky & Integer.parseInt(flipY, 2)) == 0 && startsWithOnes(kk) == sy.length()) {
                String s = build(kk, sy, flipY, "");
                if (s.length() < minLength) {
                    minLength = s.length();
                    ans = s;
                }
            }

            if (fx) ans = flipX(ans);
            if (fy) ans = flipY(ans);

            if (ans.isEmpty()) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", tc);
            } else {
                System.out.printf("Case #%d: %s\n", tc, ans);
            }
        }
    }
}