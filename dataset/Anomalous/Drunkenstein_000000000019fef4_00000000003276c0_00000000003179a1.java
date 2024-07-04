import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    private static InputStream inputStream;
    private static PrintWriter out;
    private static InputReader in;
    private static int test;

    private static void solve() throws Exception {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> counter = new HashMap<>();
        Set<Character> possible = new HashSet<>();
        List<String> integers = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            integers.add(in.next());
            strings.add(in.next());

            String integerPart = integers.get(i);
            String stringPart = strings.get(i);

            if (integerPart.length() == stringPart.length() || integerPart.equals("-1")) {
                int digit = integerPart.charAt(0) - '0';
                char firstChar = stringPart.charAt(0);
                map.put(firstChar, Math.min(map.getOrDefault(firstChar, 10), digit));
                counter.put(firstChar, counter.getOrDefault(firstChar, 0) + 1);
                for (char c : stringPart.toCharArray()) {
                    possible.add(c);
                }
            }
        }

        List<Integer> freq = new ArrayList<>(counter.values());
        Collections.sort(freq);

        List<Character> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
                if (entry.getValue().equals(freq.get(i))) {
                    result.add(entry.getKey());
                }
            }
        }

        for (char c : possible) {
            if (!counter.containsKey(c)) {
                result.add(c);
            }
        }
        Collections.reverse(result);

        StringBuilder sb = new StringBuilder();
        for (char ch : result) {
            sb.append(ch);
        }
        out.println(sb.toString());
    }

    private static BigInteger calcHash(int[] arr, int size) {
        BigInteger hash = BigInteger.ZERO;
        for (int i = 0; i < size; i++) {
            hash = hash.multiply(BigInteger.TEN).add(BigInteger.valueOf(arr[i]));
        }
        return hash;
    }

    private static void printCase() {
        out.print("Case #" + test + ": ");
    }

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int tests = in.nextInt();
            for (test = 1; test <= tests; test++) {
                printCase();
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String str = reader.readLine();
                    if (str == null) return "";
                    tokenizer = new StringTokenizer(str);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}