import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(final String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int u = in.nextInt();
            char[] answer = new char[10];

            Map<Integer, Set<Character>> buckets = new HashMap<>();
            Set<Character> digits = new HashSet<>();

            for (int j = 1; j <= 4000; j++) {
                int q = in.nextInt();
                String r = in.next();

                int key = (int) Math.ceil(q / 10);
                Set<Character> bucket = buckets.getOrDefault(key, new HashSet<>());
                if (r.length() > 1) {
                    bucket.add(r.charAt(0));
                }
                for (int k = 0; k < r.length(); k++) {
                    digits.add(r.charAt(k));
                }
                buckets.putIfAbsent(key, bucket);
            }
            buckets.put(10, digits);

            for (int j = 10; j > 0; j--) {
                Set<Character> b1 = buckets.get(j);
                Set<Character> b2 = buckets.get(j - 1);

                b1.removeAll(b2);
                answer[j % 10] = b1.iterator().next();
            }

            out.printf("Case #%d: %s%n", i, String.valueOf(answer));
        }
    }
}
