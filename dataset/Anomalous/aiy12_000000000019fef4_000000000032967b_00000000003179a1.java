import java.io.*;
import java.util.*;

public class Solution {

    private Map<Character, Character> confirmedMaps;
    private Map<Character, Set<Character>> digitMapping;

    class Query implements Comparable<Query> {
        String M, R;

        Query(String M, String R) {
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
            boolean ok = true;

            if (!ok) {
                updateConfirmedMaps();
                printResult(test);
            } else {
                Map<Character, Long> digitFrequency = new HashMap<>();
                for (Query q : queries) {
                    char lastChar = q.R.charAt(q.R.length() - 1);
                    digitFrequency.put(lastChar, digitFrequency.getOrDefault(lastChar, 0L) + 1);
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

    private void updateConfirmedMaps() {
        for (char c : digitMapping.keySet()) {
            if (digitMapping.get(c).size() == 1) {
                char ans = digitMapping.get(c).iterator().next();
                confirmedMaps.put(c, ans);
            }
        }
    }

    private void printResult(int test) {
        char[] mapping = new char[11];
        for (Map.Entry<Character, Character> entry : confirmedMaps.entrySet()) {
            mapping[entry.getValue() - '0' + 1] = entry.getKey();
        }
        mapping[0] = mapping[10];

        System.out.print("Case #" + test + ": ");
        for (int i = 0; i < 10; i++) {
            System.out.print(mapping[i]);
        }
        System.out.println();
    }

    class Pair implements Comparable<Pair> {
        long frq;
        char let;

        Pair(long frq, char let) {
            this.frq = frq;
            this.let = let;
        }

        @Override
        public int compareTo(Pair p) {
            return Long.compare(p.frq, frq);
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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

        String nextLine() {
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