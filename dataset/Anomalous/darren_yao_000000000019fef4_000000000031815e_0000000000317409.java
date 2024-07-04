import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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
    }

    private static final InputReader inputReader = new InputReader(System.in);
    private static final PrintWriter printWriter = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = inputReader.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = inputReader.nextInt();
            int y = inputReader.nextInt();
            String directions = inputReader.next();
            int n = directions.length();
            boolean foundSolution = false;
            int steps = 0;

            for (steps = 0; steps < n; steps++) {
                char direction = directions.charAt(steps);
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }

                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= steps + 1) {
                    foundSolution = true;
                    break;
                }
            }

            if (foundSolution) {
                printWriter.printf("Case #%d: %d%n", testCase, steps + 1);
            } else {
                printWriter.printf("Case #%d: IMPOSSIBLE%n", testCase);
            }
        }
        printWriter.close();
    }
}