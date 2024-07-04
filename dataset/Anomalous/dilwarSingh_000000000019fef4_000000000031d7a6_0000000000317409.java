import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static final int MOD = (int) (1e9 + 7);
    private static int[] arr;
    private static int[][] pas;
    private static int L;
    private static int R;
    private static List<MPair> al;

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            handleTestCase(i + 1);
        }
    }

    private static void handleTestCase(int t) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String path = scanner.nextLine().trim();
        List<MPair> computedPath = computePath(x, y, path);

        int minTime = Integer.MAX_VALUE;
        for (MPair p : computedPath) {
            int distance = Math.abs(p.getA()) + Math.abs(p.getB());
            int newMinTime = Math.min(minTime, Math.max(distance, p.getC()));
            if (distance <= p.getC()) {
                minTime = newMinTime;
            }
        }
        if (minTime == Integer.MAX_VALUE) {
            printResult(t, "IMPOSSIBLE");
        } else {
            printResult(t, minTime);
        }
    }

    private static List<MPair> computePath(int x, int y, String path) {
        List<MPair> pathList = new ArrayList<>();
        pathList.add(new MPair(x, y, 0));
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            switch (direction) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            pathList.add(new MPair(x, y, i + 1));
        }
        return pathList;
    }

    private static void printResult(int t, Object result) {
        System.out.println("Case #" + t + ": " + result);
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private static boolean isPowerOfTwo(int x) {
        return x != 0 && (x & (x - 1)) == 0;
    }

    static class MPair implements Comparable<MPair> {
        private int a, b, c;

        public MPair(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MPair)) return false;
            MPair mPair = (MPair) o;
            return a == mPair.a && b == mPair.b && c == mPair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }

        @Override
        public int compareTo(MPair o) {
            return Comparator.comparingInt(MPair::getA)
                    .thenComparingInt(MPair::getB)
                    .thenComparingInt(MPair::getC)
                    .compare(this, o);
        }

        @Override
        public String toString() {
            return "a=" + a + ", b=" + b + ", c=" + c;
        }
    }
}