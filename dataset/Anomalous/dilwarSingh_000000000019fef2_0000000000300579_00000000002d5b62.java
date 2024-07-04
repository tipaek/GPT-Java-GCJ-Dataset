import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static final int MOD = 1_000_000_007;
    private static int[] array;
    private static int[][] pascal;
    private static int left;
    private static int right;
    private static List<Pair> pairList;

    private static void processTestCase(int testCaseNumber) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        String result = findPath(0, 0, x, y, 1, "");
        if (result.isEmpty()) {
            result = "IMPOSSIBLE";
        }
        printTestCaseResult(testCaseNumber, result);
    }

    private static final int LIMIT = 10;

    private static String findPath(long currentX, long currentY, long targetX, long targetY, long step, String path) {
        if (Math.abs(currentX) > Math.abs(targetX) * 3 || Math.abs(currentY) > Math.abs(targetY) * 3) {
            return "";
        }
        if (currentX == targetX && currentY == targetY) {
            return path;
        }

        String[] directions = new String[4];
        directions[0] = findPath(currentX, currentY - step, targetX, targetY, step * 2, path + "S");
        directions[1] = findPath(currentX + step, currentY, targetX, targetY, step * 2, path + "E");
        directions[2] = findPath(currentX, currentY + step, targetX, targetY, step * 2, path + "N");
        directions[3] = findPath(currentX - step, currentY, targetX, targetY, step * 2, path + "W");

        String shortestPath = "";
        for (String direction : directions) {
            if (!direction.isEmpty() && (shortestPath.isEmpty() || direction.length() < shortestPath.length())) {
                shortestPath = direction;
            }
        }
        return shortestPath;
    }

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            processTestCase(i + 1);
        }
    }

    private static void printTestCaseResult(int testCaseNumber, Object result) {
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }

    private static int computeGCD(int a, int b) {
        return b == 0 ? a : computeGCD(b, a % b);
    }

    private static boolean isPowerOfTwo(int number) {
        return number != 0 && (number & (number - 1)) == 0;
    }

    static class Pair implements Comparable<Pair> {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "first=" + first + ", second=" + second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Pair)) return false;
            Pair pair = (Pair) obj;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            int comparison = Integer.compare(this.first, other.first);
            return comparison != 0 ? comparison : Integer.compare(this.second, other.second);
        }
    }
}