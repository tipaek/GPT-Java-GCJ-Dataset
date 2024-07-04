import java.io.*;
import java.util.*;

public class Solution {
    private static Deque<String> pathStack = new ArrayDeque<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int numberOfTests = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();

            if (findPath(X, Y)) {
                StringBuilder result = new StringBuilder();
                while (!pathStack.isEmpty()) {
                    result.append(pathStack.removeLast());
                }
                System.out.println("Case #" + testCase + ": " + result);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean findPath(int targetX, int targetY) {
        pathStack.clear();
        return explorePath(targetX, targetY, 0, 0, 1);
    }

    private static boolean explorePath(int targetX, int targetY, int currentX, int currentY, int step) {
        if (currentX == targetX && currentY == targetY) {
            return true;
        }

        int jumpDistance = 1 << (step - 1); // equivalent to Math.pow(2, step - 1)

        if (currentX == targetX) {
            if (currentY + jumpDistance == targetY) {
                pathStack.add("N");
                return explorePath(targetX, targetY, currentX, currentY + jumpDistance, step + 1);
            } else if (currentY - jumpDistance == targetY) {
                pathStack.add("S");
                return explorePath(targetX, targetY, currentX, currentY - jumpDistance, step + 1);
            }
        }

        if (currentY == targetY) {
            if (currentX + jumpDistance == targetX) {
                pathStack.add("E");
                return explorePath(targetX, targetY, currentX + jumpDistance, currentY, step + 1);
            } else if (currentX - jumpDistance == targetX) {
                pathStack.add("W");
                return explorePath(targetX, targetY, currentX - jumpDistance, currentY, step + 1);
            }
        }

        if (Math.abs(currentX + jumpDistance) <= Math.abs(targetX)) {
            pathStack.add("E");
            if (explorePath(targetX, targetY, currentX + jumpDistance, currentY, step + 1)) {
                return true;
            }
            pathStack.removeLast();
        }

        if (Math.abs(currentX - jumpDistance) <= Math.abs(targetX)) {
            pathStack.add("W");
            if (explorePath(targetX, targetY, currentX - jumpDistance, currentY, step + 1)) {
                return true;
            }
            pathStack.removeLast();
        }

        if (Math.abs(currentY + jumpDistance) <= Math.abs(targetY)) {
            pathStack.add("N");
            if (explorePath(targetX, targetY, currentX, currentY + jumpDistance, step + 1)) {
                return true;
            }
            pathStack.removeLast();
        }

        if (Math.abs(currentY - jumpDistance) <= Math.abs(targetY)) {
            pathStack.add("S");
            if (explorePath(targetX, targetY, currentX, currentY - jumpDistance, step + 1)) {
                return true;
            }
            pathStack.removeLast();
        }

        return false;
    }

    static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        FastScanner(String fileName) {
            try {
                reader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}