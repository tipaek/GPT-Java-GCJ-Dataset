import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    private static Stack<String> pathStack = new Stack<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            if (findPath(targetX, targetY)) {
                StringBuilder result = new StringBuilder();
                while (!pathStack.isEmpty()) {
                    result.append(pathStack.pop());
                }
                System.out.println("Case #" + (t + 1) + ": " + result.reverse().toString());
            } else {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean findPath(int targetX, int targetY) {
        return findPath(targetX, targetY, 0, 0, 1);
    }

    private static boolean findPath(int targetX, int targetY, int currentX, int currentY, int step) {
        if (currentX == targetX && currentY == targetY) return true;
        if (currentX == 0 && currentY == 0) pathStack.clear();

        int jumpDistance = (int) Math.pow(2, step - 1);

        if (tryMove(targetX, targetY, currentX, currentY + jumpDistance, step, "N")) return true;
        if (tryMove(targetX, targetY, currentX, currentY - jumpDistance, step, "S")) return true;
        if (tryMove(targetX, targetY, currentX + jumpDistance, currentY, step, "E")) return true;
        if (tryMove(targetX, targetY, currentX - jumpDistance, currentY, step, "W")) return true;

        return false;
    }

    private static boolean tryMove(int targetX, int targetY, int newX, int newY, int step, String direction) {
        if (Math.abs(newX) <= Math.abs(targetX) && Math.abs(newY) <= Math.abs(targetY)) {
            pathStack.push(direction);
            if (findPath(targetX, targetY, newX, newY, step + 1)) {
                return true;
            }
            pathStack.pop();
        }
        return false;
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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