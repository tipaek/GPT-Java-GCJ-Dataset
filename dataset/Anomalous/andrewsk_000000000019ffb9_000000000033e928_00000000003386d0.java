import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int pointsCount = scanner.nextInt();
            long[] xCoordinates = new long[pointsCount];
            long[] yCoordinates = new long[pointsCount];
            for (int pointIndex = 0; pointIndex < pointsCount; pointIndex++) {
                xCoordinates[pointIndex] = scanner.nextLong();
                yCoordinates[pointIndex] = scanner.nextLong();
            }
            long result = calculateMaxPointsOnLine(xCoordinates, yCoordinates);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static long calculateMaxPointsOnLine(long[] xCoordinates, long[] yCoordinates) {
        Map<Slope, Set<Integer>> slopeFrequencyMap = new HashMap<>();
        int numberOfPoints = xCoordinates.length;
        for (int i = 0; i < numberOfPoints; i++) {
            for (int j = i + 1; j < numberOfPoints; j++) {
                long deltaX = xCoordinates[i] - xCoordinates[j];
                long deltaY = yCoordinates[i] - yCoordinates[j];
                Slope slope = new Slope(deltaX, deltaY);
                slopeFrequencyMap.computeIfAbsent(slope, k -> new HashSet<>()).add(i);
                slopeFrequencyMap.computeIfAbsent(slope, k -> new HashSet<>()).add(j);
            }
        }
        int maxPointsOnLine = slopeFrequencyMap.values().stream().mapToInt(Set::size).max().orElse(-1);
        int bonusPoints = (maxPointsOnLine % 2 == 0) ? 2 : 1;
        return Math.min(maxPointsOnLine + bonusPoints, numberOfPoints);
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