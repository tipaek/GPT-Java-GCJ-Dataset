import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {

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
    private static final PrintWriter outputWriter = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = inputReader.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = inputReader.nextInt();
            int y = inputReader.nextInt();
            String directions = inputReader.next();
            int length = directions.length();
            boolean foundAnswer = false;
            int step = 0;

            for (step = 0; step < length; step++) {
                char direction = directions.charAt(step);
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
                if (distance <= step + 1) {
                    foundAnswer = true;
                    break;
                }
            }

            if (foundAnswer) {
                outputWriter.println("Case #" + caseNumber + ": " + (step + 1));
            } else {
                outputWriter.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }

        outputWriter.close();
    }
}