
import java.io.*;

/**
 * ESAb ATAd
 */
public final class Solution {

    /**
     * Your code here!
     *
     * @param r read input from this
     * @param w write output to this
     */
    private static void run(StreamReader r, PrintWriter w) {
        int[] s = readInts(r.readLine());
            int n = s[0];
            int b = s[1];

        for (int t = 0; t < n; t++) {
            int[] result = new int[b+1];

            for (int guess = 1; guess <= 11; guess++) {
                boolean isMutatingGuess = guess > 1 && guess % 10 == 1;

                w.println(guess);
                w.flush();

                int[] read = readInts(r.readLine());
                result[guess] = read[0];
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < result.length; i++) {
                sb.append(result[i]);
            }

            w.println(sb);
            w.flush();
        }


    }

    private static int[] readInts(String line) {
        String[] parts = line.split(" ");
        int[] ints = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            ints[i] = Integer.parseInt(parts[i]);
        }
        return ints;
    }

    private static String solveCase(StreamReader r) {
        final String s = r.nextString();

        StringBuilder sb = new StringBuilder();

        int currentDepth = 0;

        for (char digit : s.toCharArray()) {
            int d = digit - '0';
            if (d != currentDepth) {
                if (d > currentDepth) {
                    int difference = d - currentDepth;
                    for (int i = 0; i < difference; i++) {
                        sb.append('(');
                    }
                } else {
                    int difference = currentDepth - d;
                    for (int i = 0; i < difference; i++) {
                        sb.append(')');
                    }
                }
                currentDepth = d;
            }

            sb.append(d);
        }

        for (int i = 0; i < currentDepth; i++) {
            sb.append(')');
        }

        return sb.toString();
    }

    /**
     * Pipes {@link System#in} to {@link #run} and writes output to {@link System#out}
     *
     * @param args Ignored
     */
    public static void main(String[] args) {
        try (final PrintWriter writer = new PrintWriter(System.out)) {
            run(new StreamReader(System.in), writer);
        }
    }

    /**
     * Use for unit testing.
     * Pipe a string into {@link #run} and get result as a string.
     *
     * @param input input string
     * @return output string
     */
    public static String run(final String input) {
        final StringWriter out = new StringWriter();
        run(new StreamReader(new ByteArrayInputStream(input.getBytes())), new PrintWriter(out));
        return out.toString();
    }

    public static class StreamReader {
        private final BufferedReader reader;
        private int lp;
        private String[] line;

        public StreamReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public String nextString() {
            if (line == null || lp == line.length) {
                final String s = readLine();
                if (s == null) return null;
                line = s.split(" ");
                lp = 0;
            }
            return line[lp++];
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

        public long nextLong() {
            return Long.parseLong(nextString());
        }

        public double nextDouble() {
            return Double.parseDouble(nextString());
        }

        public void moveToNextLine() {
            if (line == null || lp == line.length)
                readLine();
            else
                lp = line.length;
        }

        public StreamReader skip() {
            nextString();
            return this;
        }

        public void loopNextInt(Runnable r) {
            final int loops = nextInt();
            for (int i = 0; i < loops; i++)
                r.run();
        }

        public interface Case {
            void run(final int c);
        }

        public void loopCase(Case r) {
            final int loops = nextInt();
            for (int i = 1; i <= loops; i++)
                r.run(i);
        }
    }
}
