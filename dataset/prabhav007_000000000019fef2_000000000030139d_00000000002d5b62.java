import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int m = in.nextInt();
            int n = in.nextInt();
            int number = Math.abs(m) + Math.abs(n);
            if ((number) % 2 != 1) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                List<String> solutionList = solve(new Coordinate(m, n), new Coordinate(0, 0), 0, getPowerOfUpperMultipleOfTwo(number));
                if(null == solutionList) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    String shortestSolution = "";
                    for(String solution:solutionList) {
                        if(shortestSolution.isEmpty()) {
                            shortestSolution = solution;
                        }
                        if(solution.length()<shortestSolution.length()) {
                            shortestSolution=solution;
                        }
                    }
                    System.out.println("Case #" + i + ": " + shortestSolution);
                }
            }

        }
    }


    private static double getPowerOfUpperMultipleOfTwo(int number) {
        double i = 0;
        for (; Math.pow(2d, i) < number; i++) {
        }
        return i;
    }

    private static List<String> solve(Coordinate target, Coordinate current, double pow, double maxPow) {
        List<String> solutionList = null;
        List<String> newSolutionList = null;
        if(target.equals(current)) {
            solutionList = new ArrayList<>();
            solutionList.add("");
            return solutionList;
        }
        if (pow > maxPow) {
            return null;
        }
        int length = (int) Math.pow(2, pow);
        if (Math.abs(current.getX()) > Math.abs(target.getX()) || Math.abs(current.getY()) > Math.abs(target.getY())) {
            return null;
        }
        solutionList = solve(target, navigate(current, "N", length), pow + 1, maxPow);
        if (null != solutionList) {
            if(null==newSolutionList) {
                newSolutionList = new ArrayList<>();
            }
            for(String solution:solutionList) {
                newSolutionList.add("N" + solution);
            }
        }
        solutionList = solve(target, navigate(current, "E", length), pow + 1, maxPow);
        if (null != solutionList) {
            if(null==newSolutionList) {
                newSolutionList = new ArrayList<>();
            }
            for(String solution:solutionList) {
                newSolutionList.add("E" + solution);
            }
        }
        solutionList = solve(target, navigate(current, "W", length), pow + 1, maxPow);
        if (null != solutionList) {
            if(null==newSolutionList) {
                newSolutionList = new ArrayList<>();
            }
            for(String solution:solutionList) {
                newSolutionList.add("W" + solution);
            }
        }
        solutionList = solve(target, navigate(current, "S", length), pow + 1, maxPow);
        if (null != solutionList) {
            if(null==newSolutionList) {
                newSolutionList = new ArrayList<>();
            }
            for(String solution:solutionList) {
                newSolutionList.add("S" + solution);
            }
        }
        return newSolutionList;
    }

    private static Coordinate navigate(Coordinate current, String direction, int length) {
        Coordinate newCoordinate = new Coordinate(current.getX(), current.getY());
        if ("N".equals(direction)) {
            newCoordinate.setY(current.getY() + length);
        } else if ("S".equals(direction)) {
            newCoordinate.setY(current.getY() - length);
        } else if ("E".equals(direction)) {
            newCoordinate.setX(current.getX() + length);
        } else if ("W".equals(direction)) {
            newCoordinate.setX(current.getX() - length);
        }
        return newCoordinate;
    }

    private static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate) o;
            return getX() == that.getX() &&
                    getY() == that.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
