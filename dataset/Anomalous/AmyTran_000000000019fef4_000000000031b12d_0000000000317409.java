import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTests = sc.nextInt();
        System.out.println(numberOfTests);

        for (int i = 0; i < numberOfTests; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.nextToken();
            System.out.println("Case #" + (i + 1) + ": " + solve(x, y, path));
        }
    }

    public static String solve(int x, int y, String path) {
        int currentX = x, currentY = y;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                currentY++;
            } else if (path.charAt(i) == 'S') {
                currentY--;
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

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
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