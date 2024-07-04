import java.io.*;
import java.util.*;

public class Solution {
    private static final int READ_FROM_FILE = 0;
    private static final int WRITE_TO_FILE = 0;
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "A-large.out";

    private void run(InputReader in, PrintWriter out) {
        int x = in.nextInt(), y = in.nextInt();
        String s = in.next();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (c) {
                case 'S': y--; break;
                case 'N': y++; break;
                case 'W': x--; break;
                case 'E': x++; break;
            }
            int distance = Math.abs(x) + Math.abs(y);
            if (distance <= i + 1) {
                out.print(i + 1);
                return;
            }
        }
        out.print("IMPOSSIBLE");
    }

    public static void main(String[] args) {
        InputReader in;
        PrintWriter out;
        try {
            in = (READ_FROM_FILE == 1) ? new InputReader(new FileInputStream(INPUT_FILE)) : new InputReader(System.in);
            out = (WRITE_TO_FILE == 1) ? new PrintWriter(OUTPUT_FILE) : new PrintWriter(System.out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Solution solution = new Solution();
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            out.print("Case #" + i + ": ");
            solution.run(in, out);
            out.println();
        }

        out.flush();
        out.close();
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public char nextCharacter() {
            return next().charAt(0);
        }
    }
}