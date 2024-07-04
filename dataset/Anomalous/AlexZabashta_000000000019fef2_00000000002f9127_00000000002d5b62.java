import java.io.*;
import java.util.*;

public class Expogo {

    private final Random random = new Random();

    private String solve(long x, long y, int d) {
        StringBuilder builder = new StringBuilder();

        while (--d >= 0) {
            long absX = Math.abs(x);
            long absY = Math.abs(y);
            long step = 1L << d;

            if (absX > absY) {
                if (x < 0) {
                    x += step;
                    builder.append('W');
                } else {
                    x -= step;
                    builder.append('E');
                }
            } else {
                if (y < 0) {
                    y += step;
                    builder.append('S');
                } else {
                    y -= step;
                    builder.append('N');
                }
            }
        }

        return (x == 0 && y == 0) ? builder.reverse().toString() : null;
    }

    private String solve(int x, int y) {
        for (int d = 1; d <= 50; d++) {
            String result = solve(x, y, d);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    private void run(Interactor interactor) {
        int testCases = interactor.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int x = interactor.nextInt();
            int y = interactor.nextInt();
            String answer = solve(x, y);
            if (answer == null) {
                answer = "IMPOSSIBLE";
            }
            interactor.printf(Locale.ENGLISH, "Case #%d: %s%n", test, answer);
        }
    }

    private static class Interactor extends PrintWriter {

        private final BufferedReader reader;
        private StringTokenizer tokenizer = new StringTokenizer("");

        public Interactor(InputStream inputStream, OutputStream outputStream) {
            super(outputStream);
            this.reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        @Override
        public void close() {
            super.close();
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }

        private String next() {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(nextLine());
            }
            return tokenizer.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (Interactor interactor = new Interactor(System.in, System.out)) {
            new Expogo().run(interactor);
        }
    }
}