import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(System.out)) {
            FastReader in = new FastReader(System.in);
            Task.solve(new FastReader(System.in), System.out);
        }
    }

    static class Task {
        public static void solve(FastReader in, PrintStream out) {
            int t = in.nextInt();

            for (int x = 1; x <= t; x++) {
                int n = in.nextInt();
                int trace = 0, row = 0, col = 0;
                Map<Integer, List> map = new HashMap(n);
                boolean[] hasDuplicateCol = new boolean[n];
                for (int i = 0; i < n; i++) {
                    boolean hasDuplicateRow = false;
                    List<Integer> rowList = new ArrayList<>(n);
                    for (int j = 0; j < n; j++) {
                        int m = in.nextInt();
                        if (i == j) {
                            trace += m;
                        }

                        if (!hasDuplicateRow) {
                            if (rowList.contains(m)) {
                                hasDuplicateRow = true;
                            } else {
                                rowList.add(m);
                            }
                        }

                        if (!hasDuplicateCol[j]) {
                            if (map.containsKey(j)) {
                                List<Integer> colList = map.get(j);
                                if (colList.contains(m)) {
                                    hasDuplicateCol[j] = true;
                                } else {
                                    colList.add(m);
                                    map.put(j, colList);
                                }
                            } else {
                                List<Integer> colList = new ArrayList<>(n);
                                colList.add(m);
                                map.put(j, colList);
                            }
                        }
                    }

                    if (hasDuplicateRow) {
                        ++row;
                    }
                }

                for (int i = 0; i < n; i++) {
                    if (hasDuplicateCol[i]) ++col;
                }

                out.println("Case #" + x + ": " + trace + " " + row + " " + col);
            }
            out.close();

        }
    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader(InputStream f) {
            reader = new BufferedReader(new InputStreamReader(f), 32768);
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
