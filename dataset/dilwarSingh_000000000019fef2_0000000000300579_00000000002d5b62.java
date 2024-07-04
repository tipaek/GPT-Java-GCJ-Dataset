
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    private static Scanner scan;
    private static int MOD = (int) (1e9 + 7);
    private static int[] arr;
    private static int[][] pas;
    private static int L;
    private static int R;
    private static List<MPair> al;


    private static void testCase(int t) {
        int x = scan.nextInt();
        int y = scan.nextInt();

        String dp = findDP(0, 0, x, y, 1, "");
        if (dp.isEmpty()) dp = "IMPOSSIBLE";
        printCase(t, dp);
    }

    static int limit = 10;

    private static String findDP(long x1, long y1, long x, long y, long i, String res) {
        if (x1 > (Math.abs(x) * 3) || y1 > (Math.abs(y) * 3) || x1 < -(Math.abs(x) * 3) || y1 < -(Math.abs(y) * 3))
            return "";
        if (x1 == x && y1 == y) return res;

        String[] s = new String[4];
        s[0] = findDP(x1, y1 - i, x, y, i * 2, res + "S");
        s[1] = findDP(x1 + i, y1, x, y, i * 2, res + "E");
        s[2] = findDP(x1, y1 + i, x, y, i * 2, res + "N");
        s[3] = findDP(x1 - i, y1, x, y, i * 2, res + "W");

        String z = "";
        for (String str : s) {
            if (!str.isEmpty()) {
                if (z.isEmpty()) z = str;
                else if (str.length() < z.length()) z = str;
            }
        }
        return z;
    }


    public static void main(String[] args) {
        scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            testCase(i + 1);
        }
    }

    private static void printCase(int t) {
        System.out.print("Case #" + t + ": ");
    }

    private static void printCase(int t, Object o) {
        System.out.println("Case #" + t + ": " + o);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static boolean isPowerOfTwo(int x) {
        return x != 0 && ((x & (x - 1)) == 0);
    }

    static class MPair implements Comparable<MPair> {
        private int a, b;

        public MPair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "a=" + a + ", b=" + b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MPair)) return false;
            MPair mPair = (MPair) o;
            return getA() == mPair.getA() &&
                    getB() == mPair.getB();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getA(), getB());
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        @Override
        public int compareTo(MPair o) {
            return (this.getA() - o.getA()) | (this.getB() - o.getB());
        }
    }
}

