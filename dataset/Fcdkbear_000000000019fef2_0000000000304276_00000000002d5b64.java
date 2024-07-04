import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;

public class Solution {

    private static List<Integer> transform(List<Integer> now, int a, int b) {
        List<Integer> result = new ArrayList<>();
        for (int i = a; i < a + b; ++i) {
            result.add(now.get(i));
        }
        for (int i = 0; i < a; ++i) {
            result.add(now.get(i));
        }
        for (int i = a + b; i < now.size(); ++i) {
            result.add(now.get(i));
        }
        return result;
    }

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            int rank = in.nextInt();
            int suit = in.nextInt();
            List<Integer> have  = new ArrayList<>();
            for (int i = 0; i < suit; ++i) {
                for (int j = 1; j <= rank; ++j) {
                    have.add(j);
                }
            }
            List<Integer> need = new ArrayList<>();
            for (int j = 1; j <= rank; ++j) {
                for (int i = 0; i < suit; ++i) {
                    need.add(j);
                }
            }
            LinkedList<List<Integer>> q = new LinkedList<>();
            q.push(have);
            Map<List<Integer>, Integer> distance = new HashMap<>();
            Map<List<Integer>, Integer> howA = new HashMap<>();
            Map<List<Integer>, Integer> howB = new HashMap<>();
            Map<List<Integer>, List<Integer>> from = new HashMap<>();
            distance.put(have, 0);
            int res = 0;
            while (q.size() > 0) {
                List<Integer> now = q.pop();
                if (now.equals(need)) {
                    break;
                }
                int d = distance.get(now);
                for (int a = 1; a < now.size(); ++a) {
                    for (int b = 1; a + b <= now.size(); ++b) {
                        List<Integer> next = transform(now, a, b);
                        if (!distance.containsKey(next)) {
                            distance.put(next, d + 1);
                            howA.put(next, a);
                            howB.put(next, b);
                            q.add(next);
                            from.put(next, now);
                        }
                    }
                }
            }
            res = distance.get(need);
            out.printf("Case #%d: %d\n", testNumber, res);
            List<Integer> as = new ArrayList<>();
            List<Integer> bs = new ArrayList<>();
            while (!need.equals(have)) {
                as.add(howA.get(need));
                bs.add(howB.get(need));
                need = from.get(need);
            }
            Collections.reverse(as);
            Collections.reverse(bs);
            for (int i = 0; i < as.size(); ++i) {
                out.printf("%d %d\n", as.get(i), bs.get(i));
            }
            out.flush();
        }
        out.close();

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
        public long nextLong() {
            return Long.parseLong(next());
        }


    }
}
