import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String result = findSolution(n, m);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String findSolution(int n, int m) {
        if (n % 2 != 0 && m % 2 != 0) {
            return "IMPOSSIBLE";
        }

        int minSteps = (int) (Math.log(Math.abs(n) + Math.abs(m)) / Math.log(2)) - 1;
        for (int steps = minSteps; steps <= 32; steps++) {
            String solution = solve(new Triple(n, m, steps), "");
            if (solution != null) {
                return new StringBuilder(solution).reverse().toString();
            }
        }
        return "IMPOSSIBLE";
    }

    private static final Map<Triple, String> cache = new HashMap<>();

    private static String solve(Triple triple, String path) {
        if (triple.numSteps == -1) {
            if (triple.n == 0 && triple.m == 0) {
                cache.put(triple, path);
                return path;
            }
            cache.put(triple, null);
            return null;
        }

        if (cache.containsKey(triple)) {
            return cache.get(triple);
        }

        int stepValue = (int) Math.pow(2, triple.numSteps);
        String north = solve(new Triple(triple.n, triple.m - stepValue, triple.numSteps - 1), path + "N");
        String south = solve(new Triple(triple.n, triple.m + stepValue, triple.numSteps - 1), path + "S");
        String west = solve(new Triple(triple.n + stepValue, triple.m, triple.numSteps - 1), path + "W");
        String east = solve(new Triple(triple.n - stepValue, triple.m, triple.numSteps - 1), path + "E");

        String bestSolution = getBestSolution(north, south, west, east);
        cache.put(triple, bestSolution);
        return bestSolution;
    }

    private static String getBestSolution(String... solutions) {
        return Arrays.stream(solutions)
                     .filter(Objects::nonNull)
                     .min(Comparator.comparingInt(String::length))
                     .orElse(null);
    }

    private static class Triple {
        int n, m, numSteps;

        Triple(int n, int m, int numSteps) {
            this.n = n;
            this.m = m;
            this.numSteps = numSteps;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Triple triple = (Triple) obj;
            return n == triple.n && m == triple.m && numSteps == triple.numSteps;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, m, numSteps);
        }
    }
}