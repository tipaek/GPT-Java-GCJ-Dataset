import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    private static Scanner scan;
    private static int MOD = (int) (1e9 + 7);
    private static int BOUNDARY = (int) (1e9);
    private static int[] arr;
    private static int[][] pas;
    private static int L;
    private static int R;
    private static List<MPair> al;


    private static void testCase(int t) {
        int A = scan.nextInt();
        int B = scan.nextInt();
        scan.nextLine();
        int x = 0;
        boolean xFount = false;
        for (int j = 0; j < 10 && !xFount; j++) {
            for (int i = -5; i < 6 && !xFount; i++) {
                System.out.println(i + " " + (BOUNDARY - j));
                System.out.flush();
                String resp = scan.nextLine();
                if (resp.equals("HIT")) {
                    x = i;
                    xFount = true;
                }

            }
        }
        int y = 0;
        boolean yFount = false;
        for (int j = 0; j < 10 && !yFount; j++) {
            for (int i = -5; i < 6 && !yFount; i++) {
                System.out.println(BOUNDARY - j + " " + i);
                System.out.flush();
                String resp = scan.nextLine();
                if (resp.equals("HIT")) {
                    y = i;
                    yFount = true;
                }

            }
        }
        System.out.println((x + A) + " " + (y + B));
        System.out.flush();
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

