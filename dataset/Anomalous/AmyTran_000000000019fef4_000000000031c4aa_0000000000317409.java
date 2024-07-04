import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTests = sc.nextInt();

        for (int i = 0; i < numberOfTests; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String path = sc.nextToken();
            System.out.println("Case #" + (i + 1) + ": " + solve(X, Y, path));
        }
    }

    public static String solve(int x, int y, String path) {
        int currentX = x, currentY = y;
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            switch (direction) {
                case 'N': currentY++; break;
                case 'E': currentX++; break;
                case 'S': currentY--; break;
                case 'W': currentX--; break;
            }
            if (Math.abs(currentX) + Math.abs(currentY) <= i + 1) {
                return String.valueOf(i + 1);
            }
        }
        return "IMPOSSIBLE";
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