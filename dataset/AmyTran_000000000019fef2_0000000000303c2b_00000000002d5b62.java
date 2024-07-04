
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = Integer.parseInt(sc.nextToken());

        for (int i = 0; i < numberOfTest; i++) {
            // Input
            int X = sc.nextInt();
            int Y = sc.nextInt();

            jump(X, Y);
            if (stack.isEmpty()) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder res = new StringBuilder();
                while (!stack.isEmpty()) {
                    res.append(stack.pop());
                }
                res.reverse();
                System.out.println("Case #" + (i + 1) + ": " + res.toString());
            }
        }
    }

    private static void jump(int X, int Y) {
        jump(X, Y, 0, 0, 1);
    }

    private static boolean jump(int X, int Y, int fromX, int fromY, int i) {
        if (fromX == X && Y == fromY) return true;
        if (fromX == 0 && fromY == 0) stack.clear();

        int jumpLength = (int) Math.pow(2, i - 1);
        if (fromX == X) {
            if (fromY + jumpLength == Y) {
                stack.push("N");
                return jump(X, Y, fromX, fromY + jumpLength, i + 1);
            } else if (fromY - jumpLength == Y) {
                stack.push("S");
                return jump(X, Y, fromX, fromY - jumpLength, i + 1);
            }
        }

        if (fromY == Y) {
            if (fromX + jumpLength == X) {
                stack.push("E");
                return jump(X, Y, fromX + jumpLength, fromY, i + 1);
            } else if (fromX - jumpLength == X) {
                stack.push("W");
                return jump(X, Y, fromX - jumpLength, fromY, i + 1);
            }
        }

        if (Math.abs(fromX + jumpLength) <= Math.abs(X)) {
            stack.push("E");
            if (jump(X, Y, fromX + jumpLength, fromY, i + 1)) {
                return true;
            } else {
                stack.pop();
            }
        }

        if (Math.abs(fromX - jumpLength) <= Math.abs(X)) {
            stack.push("W");
            if (jump(X, Y, fromX - jumpLength, fromY, i + 1)) {
                return true;
            } else {
                stack.pop();
            }
        }

        if (Math.abs(fromY + jumpLength) <= Math.abs(Y)) {
            stack.push("N");
            if (jump(X, Y, fromX, fromY + jumpLength, i + 1)) {
                return true;
            } else {
                stack.pop();
            }
        }

        if (Math.abs(fromY - jumpLength) <= Math.abs(Y)) {
            stack.push("S");
            if (jump(X, Y, fromX, fromY - jumpLength, i + 1)) {
                return true;
            } else {
                stack.pop();
            }
        }
        return false;
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
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
