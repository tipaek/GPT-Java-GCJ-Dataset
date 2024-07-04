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
    private static List<Pair> pairList;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            solveTestCase(i + 1);
        }
    }

    private static void solveTestCase(int testCaseNumber) {
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();
        
        int x = findCoordinate(A, B, true);
        int y = findCoordinate(A, B, false);

        System.out.println((x + A) + " " + (y + B));
        System.out.flush();
        scanner.nextLine();
    }

    private static int findCoordinate(int A, int B, boolean isX) {
        int coordinate = 0;
        boolean found = false;
        for (int j = 0; j < 10 && !found; j++) {
            for (int i = -5; i <= 5 && !found; i++) {
                if (isX) {
                    System.out.println(i + " " + (BOUNDARY - j));
                } else {
                    System.out.println((BOUNDARY - j) + " " + i);
                }
                System.out.flush();
                String response = scanner.nextLine();
                if ("HIT".equals(response)) {
                    coordinate = i;
                    found = true;
                }
            }
        }
        return coordinate;
    }

    private static void printCase(int testCaseNumber) {
        System.out.print("Case #" + testCaseNumber + ": ");
    }

    private static void printCase(int testCaseNumber, Object result) {
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static boolean isPowerOfTwo(int x) {
        return x != 0 && (x & (x - 1)) == 0;
    }

    static class Pair implements Comparable<Pair> {
        private int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "a=" + a + ", b=" + b;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Pair)) return false;
            Pair other = (Pair) obj;
            return a == other.a && b == other.b;
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
        public int compareTo(Pair other) {
            int compareA = Integer.compare(this.a, other.a);
            return compareA != 0 ? compareA : Integer.compare(this.b, other.b);
        }
    }
}