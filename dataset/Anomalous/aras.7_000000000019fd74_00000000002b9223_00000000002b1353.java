import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    private static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("%d %d", x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        boolean isValid() {
            return x >= 1 && y >= 1 && y <= x;
        }
    }

    private static final BigInteger[] factorial = new BigInteger[600];

    public static void main(String[] args) {
        initializeFactorials();

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                System.out.printf("Case #%d:\n", testNumber);
                int n = scanner.nextInt();

                Set<Pair> visited = new HashSet<>();
                Pair startPoint = new Pair(1, 1);
                visited.add(startPoint);

                List<Pair> path = new ArrayList<>();
                findPath(startPoint, n - 1, visited, 1, path);

                Collections.reverse(path);
                for (Pair p : path) {
                    System.out.println(p);
                }
            }
        }
    }

    private static void initializeFactorials() {
        factorial[0] = BigInteger.ONE;
        factorial[1] = BigInteger.ONE;
        for (int i = 2; i < factorial.length; i++) {
            factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
        }
    }

    private static boolean findPath(Pair point, int remainingSum, Set<Pair> visited, int depth, List<Pair> path) {
        if (depth > 500 || remainingSum < 0) {
            return false;
        }
        if (remainingSum == 0) {
            path.add(point);
            return true;
        }

        int[][] moves = {
            {-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}
        };

        for (int[] move : moves) {
            Pair newPair = new Pair(point.x + move[0], point.y + move[1]);
            if (newPair.isValid() && !visited.contains(newPair)) {
                visited.add(newPair);
                if (findPath(newPair, remainingSum - getPascalValue(newPair), visited, depth + 1, path)) {
                    path.add(point);
                    visited.remove(point);
                    return true;
                }
            }
        }

        visited.remove(point);
        return false;
    }

    private static int getPascalValue(Pair pair) {
        int x = pair.x - 1;
        int y = pair.y - 1;
        BigInteger numerator = factorial[x];
        BigInteger denominator = factorial[y].multiply(factorial[x - y]);
        return numerator.divide(denominator).intValue();
    }
}