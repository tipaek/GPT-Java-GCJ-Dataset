import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Triple {
    int s;
    int e;
    int ind;
    Triple(int a, int b, int c) {
        s = a;
        e = b;
        ind = c;
    }
}

public class Solution {
    // TODO: do not forget
    private static final int READ_FROM_FILE = 0;
    private static final int WRITE_TO_FILE = 0;
    private static final String INPUT_FILE = "input.txt";
    //    private static final String INPUT_FILE = "A-large.in";
    private static final String OUTPUT_FILE = "A-large.out";

    private void run(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        List<Triple> l = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int s = in.nextInt(), e = in.nextInt();
            l.add(new Triple(s, e, i));
        }
        Collections.sort(l, new Comparator<Triple>() {
            @Override
            public int compare(Triple o1, Triple o2) {
                if (o1.s != o2.s) {
                    return o1.s - o2.s;
                }
                return o1.e - o2.e;
            }
        });

        char res[] = new char[n];
        int ce = 0, je = 0;
        for (int i = 0; i < n; ++i) {
            int ts = l.get(i).s, te = l.get(i).e, tind = l.get(i).ind;
            if (ts >= ce) {
                res[tind] = 'C';
                ce = te;
            } else if (ts >= je) {
                res[tind] = 'J';
                je = te;
            } else {
                out.print("IMPOSSIBLE");
                return;
            }
        }
        out.print(String.valueOf(res));
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
        for(int i = 1; i <= cases; ++i) {
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