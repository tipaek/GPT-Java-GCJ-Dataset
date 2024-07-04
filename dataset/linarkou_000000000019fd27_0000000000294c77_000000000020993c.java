import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    public static void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int index = 1; index <= t; ++index) {
            int n = in.nextInt();
            int trace = 0;
            List<Set<Integer>> rows = new ArrayList<>();
            List<Set<Integer>> columns = new ArrayList<>();
            Set<Integer> rowsDuplicated = new HashSet<>();
            Set<Integer> columnsDuplicated = new HashSet<>();
            for (int i = 0; i < n; ++i) {
                rows.add(new HashSet<>());
                columns.add(new HashSet<>());
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    int k = in.nextInt();
                    if (i == j) {
                        trace += k;
                    }
                    if (rows.get(i).contains(k)) {
                        rowsDuplicated.add(i);
                    } else {
                        rows.get(i).add(k);
                    }

                    if (columns.get(i).contains(k)) {
                        columnsDuplicated.add(i);
                    } else {
                        columns.get(i).add(k);
                    }
                }
            }
            out.print("Case #");
            out.print(index);
            out.print(": ");
            out.print(trace);
            out.print(" ");
            out.print(rowsDuplicated.size());
            out.print(" ");
            out.println(columnsDuplicated.size());
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

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

        public void skip() {
            tokenizer = null;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}