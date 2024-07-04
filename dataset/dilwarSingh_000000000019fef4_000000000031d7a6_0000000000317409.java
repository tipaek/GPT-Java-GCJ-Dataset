 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
        String path = scan.nextLine().trim();
        List<MPair> compute = compute(x, y, path);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < compute.size(); i++) {
            MPair p = compute.get(i);

            int q = Math.abs(p.a) + Math.abs(p.b);
            int newMin = Math.min(min, Math.max(q, p.c));
            if (q <= p.c) min = newMin;
        }
        if (min == Integer.MAX_VALUE)
            printCase(t, "IMPOSSIBLE");
        else
            printCase(t, min);
    }

    private static List<MPair> compute(int x, int y, String path) {
        List<MPair> lst = new ArrayList<>();
        lst.add(new MPair(x, y, 0));
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else if (c == 'W') x--;
            lst.add(new MPair(x, y, i + 1));
        }
        return lst;
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
        private int a, b, c;

        public MPair(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return "a=" + a + ", b=" + b + ", c=" + c;
        }

       /* @Override
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
*/

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MPair)) return false;
            MPair mPair = (MPair) o;
            return getA() == mPair.getA() &&
                    getB() == mPair.getB() &&
                    getC() == mPair.getC();
        }

        @Override
        public int hashCode() {

            return Objects.hash(getA(), getB(), getC());
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

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        @Override
        public int compareTo(MPair o) {
            return (this.getA() - o.getA()) | (this.getB() - o.getB() | (this.getC() - o.getC()));
        }
    }
}

