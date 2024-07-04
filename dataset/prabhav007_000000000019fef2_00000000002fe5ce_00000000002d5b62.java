import java.io.BufferedReader;
import java.io.InputStreamReader;
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
                String solution = solve(new Coordinate(m, n), new Coordinate(0, 0), 0, getPowerOfUpperMultipleOfTwo(number));
                if(null == solution) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": " + solution);
                }
            }

        }
    }


    private static double getPowerOfUpperMultipleOfTwo(int number) {
        double i = 0;
        for (; Math.pow(2d, i) < number; i++) {
        }
        return i+1;
    }

    private static String solve(Coordinate target, Coordinate current, double pow, double maxPow) {
        if(target.equals(current)) {
            return "";
        }
        if (pow > maxPow) {
            return null;
        }
        String solution = null;
        int length = (int) Math.pow(2, pow);
        if (Math.abs(current.getX()) > Math.abs(target.getX()) || Math.abs(current.getY()) > Math.abs(target.getY())) {
            return null;
        }
        solution = solve(target, navigate(current, "N", length), pow + 1, maxPow);
        if (null != solution) {
            return "N" + solution;
        }
        solution = solve(target, navigate(current, "E", length), pow + 1, maxPow);
        if (null != solution) {
            return "E" + solution;
        }
        solution = solve(target, navigate(current, "W", length), pow + 1, maxPow);
        if (null != solution) {
            return "W" + solution;
        }
        solution = solve(target, navigate(current, "S", length), pow + 1, maxPow);
        if (null != solution) {
            return "S" + solution;
        }
        return null;
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
    }
}
