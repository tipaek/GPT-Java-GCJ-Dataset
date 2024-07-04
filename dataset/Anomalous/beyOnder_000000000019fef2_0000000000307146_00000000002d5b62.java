import java.util.*;

public class Solution {
    static final char[] DIRECTIONS = {'E', 'W', 'N', 'S'};
    static ArrayList<Character> path = new ArrayList<>();

    static int power(int n) {
        return 1 << n;
    }

    static int[] findWithSign(int x, int y) {
        int min = Math.min(Math.abs(x), Math.abs(y));
        int max;
        if (min == Math.abs(x)) {
            max = y;
            return new int[]{x, Integer.signum(x), max};
        } else {
            max = x;
            return new int[]{y, Integer.signum(y), max};
        }
    }

    static boolean findPath(int x, int y, int twoPow) {
        int stepSize = power(twoPow);
        if (x == 0 && y == 0) {
            return true;
        }

        if (x == 0) {
            if (stepSize > Math.abs(y)) {
                return false;
            } else if (stepSize == Math.abs(y)) {
                path.add(y < 0 ? 'S' : 'N');
                return true;
            } else if (findPath(0, y < 0 ? y + stepSize : y - stepSize, twoPow + 1)) {
                path.add(y < 0 ? 'S' : 'N');
                return true;
            }
            return false;
        }

        if (y == 0) {
            if (stepSize > Math.abs(x)) {
                return false;
            } else if (stepSize == Math.abs(x)) {
                path.add(x < 0 ? 'W' : 'E');
                return true;
            } else if (findPath(x < 0 ? x + stepSize : x - stepSize, y, twoPow + 1)) {
                path.add(x < 0 ? 'W' : 'E');
                return true;
            }
            return false;
        }

        if (stepSize > Math.min(Math.abs(x), Math.abs(y))) {
            return false;
        }

        if (findPath(x + stepSize, y, twoPow + 1)) {
            path.add('W');
            return true;
        }
        if (findPath(x - stepSize, y, twoPow + 1)) {
            path.add('E');
            return true;
        }
        if (findPath(x, y - stepSize, twoPow + 1)) {
            path.add('N');
            return true;
        }
        if (findPath(x, y + stepSize, twoPow + 1)) {
            path.add('S');
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int h = 1; h <= t; h++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.print("Case #" + h + ": ");
            boolean found = findPath(x, y, 0);
            if (!found) {
                System.out.println("Impossible");
            } else {
                for (int q = path.size() - 1; q >= 0; q--) {
                    System.out.print(path.get(q));
                }
                System.out.println();
            }
            path.clear();
        }
    }
}