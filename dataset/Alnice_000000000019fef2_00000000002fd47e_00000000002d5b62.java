import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int numTestCase = 1; numTestCase <= T; ++numTestCase) {
            int n = in.nextInt();
            int m = in.nextInt();
            boolean isPossible = true;
            if (n % 2 != 0 && m % 2 != 0) {
                isPossible = false;
            }
            String solution = "";
            if(isPossible) {
                int minNumSteps = (int) (Math.log(Math.abs(n) + Math.abs(m)) / Math.log(2)) - 1;
                for(int currSteps = minNumSteps; true; currSteps++) {
                    if(currSteps > 32) {
                        solution = "IMPOSSIBLE";
                        break;
                    }
                    solution = solve(new Triple(n, m, currSteps), "");
                    if(solution != null) {
                        solution = new StringBuilder(solution).reverse().toString();
                        break;
                    }
                }
            } else {
                solution = "IMPOSSIBLE";
            }
            System.out.println("Case #" + numTestCase + ": " + solution);
        }
    }

    static Map<Triple, String> cache = new HashMap<>();
    static List<String> solutions = new ArrayList<>();

    public static String solve(Triple triple, String solution) {
        if (triple.numSteps == -1) {
            if (triple.n == 0 && triple.m == 0) {
                solutions.add(solution);
                cache.put(triple, solution);
                return solution;
            } else {
                cache.put(triple, null);
                return null;
            }
        }

        String cachedSol = cache.get(triple);
        if (cachedSol == null) {
            int currentValue = (int) Math.pow(2, triple.numSteps);
//            System.out.println(currentValue);
            //Try North
//            System.out.println(triple.m + "::" + currentValue);
            String solNorth = solve(
                new Triple(triple.n, triple.m - currentValue, triple.numSteps - 1), solution + "N");

            //Try South
            String solSouth = solve(
                new Triple(triple.n, triple.m + currentValue, triple.numSteps - 1), solution + "S");

            //Try West
            String solWest = solve(
                new Triple(triple.n + currentValue, triple.m, triple.numSteps - 1), solution + "W");

            //Try East
            String solEast = solve(
                new Triple(triple.n - currentValue, triple.m, triple.numSteps - 1),
                solution + "E");

            int a = solNorth == null ? 0 : solNorth.length();
            int b = solSouth == null ? 0 : solSouth.length();
            int c = solWest == null ? 0 : solWest.length();
            int d = solEast == null ? 0 : solEast.length();

            if (a != 0 && biggerThanAll(a, b, c, d)) {
                cachedSol = solNorth;
            } else if (b != 0 && biggerThanAll(b, a, c, d)) {
                cachedSol = solSouth;
            } else if (c != 0 && biggerThanAll(c, a, b, d)) {
                cachedSol = solWest;
            } else if (d != 0 && biggerThanAll(d, a, b, c)) {
                cachedSol = solEast;
            } else {
                cachedSol = null;
            }
            cache.put(triple, cachedSol);
        } else {
            System.out.println("found cahce: " + cachedSol);
        }
        return cachedSol;
    }

    public static boolean biggerThanAll(int a, int b, int c, int d) {
        List<Integer> nums = new ArrayList<>();
        nums.add(a);
        nums.add(b);
        nums.add(c);
        nums.add(d);
        return Collections.max(nums) == a;
    }

    public static class Triple {

        public int n;
        public int m;
        public int numSteps;

        public Triple(int n, int m, int numSteps) {
            this.n = n;
            this.m = m;
            this.numSteps = numSteps;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Triple triple = (Triple) o;

            if (n != triple.n) {
                return false;
            }
            if (m != triple.m) {
                return false;
            }
            return numSteps == triple.numSteps;
        }

        @Override
        public int hashCode() {
            int result = n;
            result = 31 * result + m;
            result = 31 * result + numSteps;
            return result;
        }
    }
}