import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final int MOD = (int) (1e9 + 7);
    private static final int BOUNDARY = (int) (1e9);
    private static int[] arr;
    private static int[][] pas;
    private static int L;
    private static int R;
    private static List<MPair> al;

    private static void testCase(int t) {
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();
        int x = 0;
        boolean xFound = false;
        for (int j = 0; j < 10 && !xFound; j++) {
            for (int i = -5; i <= 5 && !xFound; i++) {
                System.out.println(i + " " + (BOUNDARY - j));
                System.out.flush();
                String response = scanner.nextLine();
                if ("HIT".equals(response)) {
                    x = i;
                    xFound = true;
                }
            }
        }

        int y = 0;
        boolean yFound = false;
        for (int j = 0; j < 10 && !yFound; j++) {
            for (int i = -5; i <= 5 && !yFound; i++) {
                System.out.println((BOUNDARY - j) + " " + i);
                System.out.flush();
                String response = scanner.nextLine();
                if ("HIT".equals(response)) {
                    y = i;
                    yFound = true;
                }
            }
        }

        System.out.println(x + " " + y);
        System.out.flush();
        scanner.nextLine();
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
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
        return b == 0 ? a : gcd(b, a % b);
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
            return a == mPair.a && b == mPair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
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
            int cmp = Integer.compare(this.a, o.a);
            return cmp != 0 ? cmp : Integer.compare(this.b, o.b);
        }
    }
}