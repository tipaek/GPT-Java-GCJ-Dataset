import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    private static Stack<String> pathStack = new Stack<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            if (findPath(targetX, targetY)) {
                StringBuilder result = new StringBuilder();
                while (!pathStack.isEmpty()) {
                    result.append(pathStack.pop());
                }
                System.out.println("Case #" + (testIndex + 1) + ": " + result.reverse().toString());
            } else {
                System.out.println("Case #" + (testIndex + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean findPath(int targetX, int targetY) {
        pathStack.clear();
        return explore(targetX, targetY, 0, 0, 1);
    }

    private static boolean explore(int targetX, int targetY, int currentX, int currentY, int step) {
        if (currentX == targetX && currentY == targetY) return true;

        int jumpDistance = (int) Math.pow(2, step - 1);

        // Try moving North
        if (Math.abs(currentY + jumpDistance) <= Math.abs(targetY)) {
            pathStack.push("N");
            if (explore(targetX, targetY, currentX, currentY + jumpDistance, step + 1)) return true;
            pathStack.pop();
        }

        // Try moving South
        if (Math.abs(currentY - jumpDistance) <= Math.abs(targetY)) {
            pathStack.push("S");
            if (explore(targetX, targetY, currentX, currentY - jumpDistance, step + 1)) return true;
            pathStack.pop();
        }

        // Try moving East
        if (Math.abs(currentX + jumpDistance) <= Math.abs(targetX)) {
            pathStack.push("E");
            if (explore(targetX, targetY, currentX + jumpDistance, currentY, step + 1)) return true;
            pathStack.pop();
        }

        // Try moving West
        if (Math.abs(currentX - jumpDistance) <= Math.abs(targetX)) {
            pathStack.push("W");
            if (explore(targetX, targetY, currentX - jumpDistance, currentY, step + 1)) return true;
            pathStack.pop();
        }

        return false;
    }

    public static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastScanner(String fileName) {
            try {
                reader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
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