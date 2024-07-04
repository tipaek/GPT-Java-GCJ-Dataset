import java.io.*;
import java.util.*;

public class Solution {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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

    static InputReader input = new InputReader(System.in);
    static PrintWriter output = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = input.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int u = input.nextInt();
            List<Query> queries = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                queries.add(new Query(input.nextInt(), input.next()));
            }
            Collections.sort(queries);

            String[] answer = new String[11];
            Set<String> seen = new HashSet<>();
            for (Query query : queries) {
                int p = query.num;
                String s = query.s;
                if (p >= 1 && p <= 9 && !seen.contains(s)) {
                    answer[p] = s;
                    seen.add(s);
                } else if (p == 10 && !seen.contains(s)) {
                    answer[10] = s.substring(1);
                    seen.add(s);
                }
            }

            output.print("Case #" + caseNum + ": ");
            output.print(answer[10]);
            for (int i = 1; i <= 9; i++) {
                output.print(answer[i]);
            }
            output.println();
        }
        output.close();
    }

    static class Query implements Comparable<Query> {
        int num;
        String s;

        public Query(int num, String s) {
            this.num = num;
            this.s = s;
        }

        @Override
        public int compareTo(Query other) {
            return Integer.compare(this.num, other.num);
        }
    }
}