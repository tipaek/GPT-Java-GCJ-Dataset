import java.io.*;
import java.util.*;

public class Solution {
    private FastScanner scanner;

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    public void run() throws Exception {
        scanner = new FastScanner();

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.println("Case #" + testCase + ":");

            int N = scanner.nextInt();

            if (N == 1) {
                System.out.println("1 1");
                continue;
            }

            if (N == 2) {
                System.out.println("1 1");
                System.out.println("2 2");
                continue;
            }

            if (N == 3) {
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("2 2");
                continue;
            }

            System.out.println("1 1");
            System.out.println("2 2");

            int steps = 2;
            int sum = 2;
            List<Step> stepsList = new ArrayList<>();

            int row = 3, col = 2;
            while (sum <= N) {
                sum += steps++;
                stepsList.add(new Step(row, col));
                row++;
                col++;
            }
            stepsList.remove(stepsList.size() - 1);
            row -= 2;
            col -= 1;
            sum -= --steps;

            while (sum < N) {
                stepsList.add(new Step(row++, col++));
                sum++;
            }

            for (Step step : stepsList) {
                System.out.println(step.row + " " + step.col);
            }
        }
    }

    private static class Step {
        int row, col;

        public Step(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}