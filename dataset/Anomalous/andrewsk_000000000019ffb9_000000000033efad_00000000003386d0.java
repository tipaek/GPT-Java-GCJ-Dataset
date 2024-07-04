import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            long[] xCoordinates = new long[n];
            long[] yCoordinates = new long[n];
            for (int j = 0; j < n; j++) {
                xCoordinates[j] = scanner.nextLong();
                yCoordinates[j] = scanner.nextLong();
            }
            long result = calculateResult(xCoordinates, yCoordinates);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static long calculateResult(long[] x, long[] y) {
        int n = x.length;
        if (n <= 3) {
            return n;
        }

        Map<Slope, Set<Integer>> slopeFrequency = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long deltaX = x[i] - x[j];
                long deltaY = y[i] - y[j];
                Slope slope = new Slope(deltaX, deltaY);
                slopeFrequency.computeIfAbsent(slope, k -> new HashSet<>()).add(i);
                slopeFrequency.computeIfAbsent(slope, k -> new HashSet<>()).add(j);
            }
        }

        int maxSlopeFrequency = slopeFrequency.values().stream().mapToInt(Set::size).max().orElse(-1);
        int adjustment = maxSlopeFrequency % 2 == 0 ? 2 : 1;
        return Math.min(maxSlopeFrequency + adjustment, n);
    }

    static class Slope {
        long numerator;
        long denominator;

        public Slope(long numerator, long denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            simplify();
        }

        private void simplify() {
            long gcdValue = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcdValue;
            denominator /= gcdValue;
            if (numerator < 0) {
                numerator *= -1;
                denominator *= -1;
            }
        }

        private long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Slope slope = (Slope) obj;
            return numerator == slope.numerator && denominator == slope.denominator;
        }

        @Override
        public int hashCode() {
            return Objects.hash(numerator, denominator);
        }

        @Override
        public String toString() {
            return "Slope{" + numerator + "/" + denominator + '}';
        }
    }
}