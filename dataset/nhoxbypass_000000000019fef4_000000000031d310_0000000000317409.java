import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = Integer.parseInt(sc.nextToken());

        for (int i = 0; i < numberOfTest; i++) {
            // Input
            int X = sc.nextInt();
            int Y = sc.nextInt();
            char[] moves = sc.nextToken().toCharArray();

            String res = solve(X, Y, moves);
            System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }

    public static String solve(int x, int y, char[] moves) {
        int targetX = x, targetY = y;
        for (int i = 0; i < moves.length; i++) {
            char m = moves[i];
            if (m == 'N') {
                targetY++;
            } else if (m == 'E') {
                targetX++;
            } else if (m == 'S') {
                targetY--;
            } else {
                targetX--;
            }
            if (Math.abs(targetX) + Math.abs(targetY) <= i + 1) {
                return (i + 1) + "";
            }
        }
        return "IMPOSSIBLE";
    }

    /*private static int solve(int x, int y, char[] moves) {
        int currX = x;
        int currY = y;
        for (int i = 0; i < moves.length; i++) {
            char m = moves[i];
            if (m == 'N') {
                currY++;
            } else if (m == 'S') {
                currY--;
            } else if (m == 'E') {
                currX++;
            } else {
                currX--;
            }

            // Check to see if we can reach there
           int step = moveTo(currX, currY, i + 1);
            if (step < minStep)
                minStep = step;
        }

        return minStep;
    }

    private static int moveTo(int targetX, int targetY, int maxStep) {
        int currX = 0, currY = 0;
        for (int i = 0; i < maxStep; i++) {
            if (currX == targetX) {
                if (currY == targetY)
                    return i;

                if (currY < targetY)
                    currY++;
                else
                    currY--;
            } else {
                if (currX < targetX)
                    currX++;
                else
                    currX--;
            }
        }

        if (currX == targetX && currY == targetY) {
            return maxStep;
        } else {
            return Integer.MAX_VALUE;
        }
    }*/

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
