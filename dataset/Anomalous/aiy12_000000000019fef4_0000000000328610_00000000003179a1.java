import java.io.*;
import java.util.*;

public class Solution {

    private HashMap<Character, Character> confirmedMaps;
    private HashMap<Character, HashSet<Character>> digitMapping;

    private class Query implements Comparable<Query> {
        String M, R;

        public Query(String M, String R) {
            this.M = M;
            this.R = R;

            for (int i = 0; i < R.length(); i++) {
                digitMapping.putIfAbsent(R.charAt(i), new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')));
            }
        }

        @Override
        public int compareTo(Query q) {
            return M.compareTo(q.M);
        }
    }

    public void run() throws Exception {
        FastScanner file = new FastScanner();
        int T = file.nextInt();

        for (int test = 1; test <= T; test++) {
            int U = file.nextInt();
            confirmedMaps = new HashMap<>();
            digitMapping = new HashMap<>();

            List<Query> queries = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                queries.add(new Query(file.next(), file.next()));
            }

            Collections.sort(queries);
            boolean ok = false;

            for (Query q : queries) {
                if (q.M.equals("-1")) {
                    ok = true;
                    break;
                }

                if (q.M.length() == q.R.length()) {
                    int idx = 0;
                    while (idx < q.M.length() && confirmedMaps.containsKey(q.R.charAt(idx)) &&
                            confirmedMaps.get(q.R.charAt(idx)) == q.M.charAt(idx)) {
                        idx++;
                    }

                    if (idx != q.M.length() && !confirmedMaps.containsKey(q.R.charAt(idx))) {
                        HashSet<Character> toRemove = new HashSet<>();
                        for (char c : digitMapping.get(q.R.charAt(idx))) {
                            if (c >= q.M.charAt(idx)) {
                                toRemove.add(c);
                            }
                        }
                        digitMapping.get(q.R.charAt(idx)).removeAll(toRemove);

                        if (digitMapping.get(q.R.charAt(idx)).size() == 1) {
                            char ans = digitMapping.get(q.R.charAt(idx)).iterator().next();
                            confirmedMaps.put(q.R.charAt(idx), ans);

                            for (char c : digitMapping.keySet()) {
                                digitMapping.get(c).remove(ans);
                            }
                        }
                    }
                }
            }

            if (!ok) {
                for (char c : digitMapping.keySet()) {
                    if (digitMapping.get(c).size() == 1) {
                        char ans = digitMapping.get(c).iterator().next();
                        confirmedMaps.put(c, ans);
                    }
                }

                char[] mapping = new char[11];
                for (char c : confirmedMaps.keySet()) {
                    mapping[confirmedMaps.get(c) - '0' + 1] = c;
                }
                mapping[0] = mapping[10];

                System.out.print("Case #" + test + ": ");
                for (int i = 0; i < 10; i++) {
                    System.out.print(mapping[i]);
                }
                System.out.println();

            } else {
                HashMap<Character, Long> digitFrequency = new HashMap<>();

                for (Query q : queries) {
                    for (int j = 0; j < q.R.length(); j++) {
                        digitFrequency.put(q.R.charAt(j), digitFrequency.getOrDefault(q.R.charAt(j), 0L) + 1);
                    }
                }

                List<Pair> arr = new ArrayList<>();
                for (Map.Entry<Character, Long> entry : digitFrequency.entrySet()) {
                    arr.add(new Pair(entry.getValue(), entry.getKey()));
                }

                Collections.sort(arr);

                char[] mapping = new char[11];
                for (int i = 1; i < 11; i++) {
                    mapping[i] = arr.get(i - 1).let;
                }
                mapping[0] = mapping[10];

                System.out.print("Case #" + test + ": ");
                for (int i = 0; i < 10; i++) {
                    System.out.print(mapping[i]);
                }
                System.out.println();
            }
        }
    }

    private class Pair implements Comparable<Pair> {
        long frq;
        char let;

        public Pair(long a, char b) {
            frq = a;
            let = b;
        }

        @Override
        public int compareTo(Pair p) {
            return Long.compare(p.frq, frq);
        }
    }

    private static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}