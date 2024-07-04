import java.io.*;
import java.util.*;

public class Solution {
    private static final int READ_FROM_FILE = 0;
    private static final int WRITE_TO_FILE = 0;
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "A-large.out";

    private void run(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int d = in.nextInt();
        Map<Long, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long value = in.nextLong();
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        if (d == 2) {
            for (int count : frequencyMap.values()) {
                if (count > 1) {
                    out.print(0);
                    return;
                }
            }
            out.print(1);
            return;
        }

        if (d == 3) {
            Set<Long> keys = frequencyMap.keySet();
            boolean canInOne = false;

            for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
                int count = entry.getValue();
                if (count > 2) {
                    out.print(0);
                    return;
                }
                if (count == 2) {
                    long key = entry.getKey();
                    for (long k : keys) {
                        if (k > key) {
                            canInOne = true;
                            break;
                        }
                    }
                }
            }

            if (canInOne) {
                out.print(1);
                return;
            }

            for (long key : keys) {
                if (keys.contains(key * 2)) {
                    out.print(1);
                    return;
                }
            }
            out.print(2);
            return;
        }

        out.print(d - 1);
    }

    public static void main(String[] args) {
        InputReader in;
        PrintWriter out;
        try {
            if (READ_FROM_FILE == 1) {
                in = new InputReader(new FileInputStream(INPUT_FILE));
            } else {
                in = new InputReader(System.in);
            }
            if (WRITE_TO_FILE == 1) {
                out = new PrintWriter(OUTPUT_FILE);
            } else {
                out = new PrintWriter(System.out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Solution solution = new Solution();
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
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