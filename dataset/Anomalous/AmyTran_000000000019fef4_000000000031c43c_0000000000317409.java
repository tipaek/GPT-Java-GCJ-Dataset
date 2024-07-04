import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.nextToken();
            System.out.println("Case #" + (i + 1) + ": " + findMinimumSteps(x, y, path));
        }
    }

    public static String findMinimumSteps(int x, int y, String path) {
        int currentX = x, currentY = y;
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
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