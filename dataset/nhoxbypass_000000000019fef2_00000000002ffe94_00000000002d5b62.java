import java.io.*;
import java.util.*;

public class Solution {

    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = Integer.parseInt(sc.nextToken());

        for (int i = 0; i < numberOfTest; i++) {
            // Input
            int X = sc.nextInt();
            int Y = sc.nextInt();

            // Solve
            solve(X, Y);
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

    private static void solve(int X, int Y) {
        walk(X, Y, 0, 0, 1);
    }

    // i: start from 0
    private static boolean walk(int X, int Y, int currX, int currY, int i) {
        if (currX == X && Y == currY) {
            return true;
        }

        if (currX == 0 && currY == 0)
            stack.clear();

        boolean res = false;
        int step = (int) Math.pow(2, i - 1);

        //System.out.println("Traveled to: X=" + currX + ", Y=" + currY + ", step=" + step + ". Determine where to go next...");
        //System.out.println("Curr: " + stack);

        if (currX == X) {
            if (currY + step == Y) {
                stack.push("N");
                return walk(X, Y, currX, currY + step, i + 1);
            } else if (currY - step == Y) {
                stack.push("S");
                return walk(X, Y, currX, currY - step, i + 1);
            }
        }

        if (currY == Y) {
            if (currX + step == X) {
                stack.push("E");
                return walk(X, Y, currX + step, currY, i + 1);
            } else if (currX - step == X) {
                stack.push("W");
                return walk(X, Y, currX - step, currY, i + 1);
            }
        }

        if (Math.abs(currX + step) > Math.abs(X)) {
            res = false;
        } else {
            stack.push("E");
            res = walk(X, Y, currX + step, currY, i + 1);
            if (res) {
                //System.out.println("No idea why it return true :(((");
                return true;
            } else {
                stack.pop();
            }
        }

        if (Math.abs(currX - step) > Math.abs(X)) {
            res = false;
        } else {
            stack.push("W");
            res = walk(X, Y, currX - step, currY, i + 1);
            if (res) {
                //System.out.println("No idea why it return true :(((");
                return true;
            } else {
                stack.pop();
            }
        }

        if (Math.abs(currY + step) > Math.abs(Y)) {
            res = false;
        } else {
            stack.push("N");
            res = walk(X, Y, currX, currY + step, i + 1);
            if (res) {
                //System.out.println("No idea why it return true :(((");
                return true;
            } else {
                stack.pop();
            }
        }

        if (Math.abs(currY - step) > Math.abs(Y)) {
            return false;
        } else {
            stack.push("S");
            res = walk(X, Y, currX, currY - step, i + 1);
            if (res) {
                //System.out.println("No idea why it return true :(((");
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
