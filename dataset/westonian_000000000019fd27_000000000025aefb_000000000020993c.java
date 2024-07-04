import com.sun.javafx.binding.StringFormatter;

import java.io.*;
import java.math.BigInteger;

public final class Solution {

    /**
     * Your code here!
     *
     * @param r read input from this
     * @param w write output to this
     */
    private static void run(StreamReader r, PrintWriter w) {
        r.loopCase((c) -> {
            w.print("Case #" + c + ": ");

            w.println(solveCase(r));
        });
    }

    private static String solveCase(StreamReader r) {
        final int n = r.nextInt();
        int trace = 0;
        BigInteger expect = BigInteger.valueOf(1).shiftLeft(n).subtract(BigInteger.ONE);
        int rowMismatch = 0;
        int colMismatch = 0;
        BigInteger[] colSum = new BigInteger[n];

        for (int row = 0; row < n; row++) {
            BigInteger rowSum = BigInteger.ZERO;
            for (int col = 0; col < n; col++) {
                int cell = r.nextInt();
                if (row == col) trace += cell;
                BigInteger cellBi = BigInteger.valueOf(1).shiftLeft(cell - 1);
                rowSum = rowSum.add(cellBi);
                if(row == 0) colSum[col] = BigInteger.ZERO;
                colSum[col] = colSum[col].add(cellBi);
            }
            if (!rowSum.equals(expect)) {
                rowMismatch++;
            }
        }

        for (BigInteger c : colSum) {
            if (!c.equals(expect)) {
                colMismatch++;
            }
        }

        return String.format("%d %d %d", trace, rowMismatch, colMismatch);
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
