import java.io.*;
import java.util.*;

public class Solution {

    Random random = new Random();

    String solve(long x, long y, int d) {
        StringBuilder builder = new StringBuilder();

        while (--d >= 0) {
            long ax = Math.abs(x);
            long ay = Math.abs(y);

            long step = 1L << d;

            if (ax > ay) {
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

        if (x == 0 && y == 0) {
            return builder.reverse().toString();
        } else {
            return null;
        }
    }

    String solve(int x, int y) {
        for (int d = 1; d <= 50; d++) {
            String result = solve(x, y, d);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    void run(Interactor interactor) {
        int tests = interactor.nextInt();
        for (int test = 1; test <= tests; test++) {
            int x = interactor.nextInt();
            int y = interactor.nextInt();

            String ans = solve(x, y);
            if (ans == null) {
                ans = "IMPOSSIBLE";
            }
            interactor.printf(Locale.ENGLISH, "Case #%d: %s%n", test, ans);
        }
    }

    static class Interactor extends PrintWriter {

        final BufferedReader reader;
        StringTokenizer tokenizer = new StringTokenizer("");

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

        boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }

        String next() {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(nextLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (Interactor interactor = new Interactor(System.in, System.out)) {
            new Solution().run(interactor);
        }
    }
}