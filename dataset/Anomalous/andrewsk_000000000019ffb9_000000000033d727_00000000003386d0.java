import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            long[] xCoordinates = new long[n];
            long[] yCoordinates = new long[n];
            
            for (int j = 0; j < n; j++) {
                xCoordinates[j] = scanner.nextLong();
                yCoordinates[j] = scanner.nextLong();
            }
            
            long result = calculateMaxPointsOnLine(xCoordinates, yCoordinates);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static long calculateMaxPointsOnLine(long[] x, long[] y) {
        Map<Slope, Set<Integer>> slopeFrequencyMap = new HashMap<>();
        int numPoints = x.length;
        
        for (int i = 0; i < numPoints; i++) {
            for (int j = i + 1; j < numPoints; j++) {
                long deltaX = x[i] - x[j];
                long deltaY = y[i] - y[j];
                Slope slope = new Slope(deltaX, deltaY);
                
                slopeFrequencyMap
                    .computeIfAbsent(slope, k -> new HashSet<>())
                    .add(i);
                
                slopeFrequencyMap.get(slope).add(j);
            }
        }
        
        int maxPoints = slopeFrequencyMap.values().stream()
                                          .mapToInt(Set::size)
                                          .max()
                                          .orElse(-1);
        
        return Math.min(maxPoints + 2, numPoints);
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
            long gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
            
            if (numerator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
        }

        private long gcd(long a, long b) {
            while (b != 0) {
                long temp = b;
                b = a % b;
                a = temp;
            }
            return a;
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