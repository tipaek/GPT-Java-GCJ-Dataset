import java.io.*;
import java.util.*;

public class Solution {

    static class Code implements Comparable<Code> {
        char ch;
        int count;
        int max;


        @Override
        public int compareTo(Code o) {
            if (max != o.max) {
                return max - o.max;
            }

            return count - o.count;
        }
    }

    private String getAns(int u, long[] queries, String[] resp) {
        Set<Character> firstChSet = new HashSet<>();
        Set<Character> allCh = new HashSet<>();
        Map<Character, Integer> repCount = new HashMap<>();

        for (int i = 0; i < resp.length; i++) {
            firstChSet.add(resp[i].charAt(0));

            for (int j = 0; j < resp[i].length(); j++) {
                final char ch = resp[i].charAt(j);
                allCh.add(ch);

                if (!repCount.containsKey(ch)) {
                    repCount.put(ch, 0);
                }

                repCount.put(ch, repCount.get(ch) + 1);
            }
        }

        char zero = '-';
        for (char ch : allCh) {
            if (!firstChSet.contains(ch)) {
                zero = ch;
            }
        }

        Map<Character, Integer> chMaxMap = new HashMap<>();
        for (char ch : firstChSet) {
            chMaxMap.put(ch, 9);
        }

        for (int i = 0; i < resp.length; i++) {
            String val = String.valueOf(queries[i]);

            if (val.length() == resp[i].length()) {
                char firstCh = resp[i].charAt(0);
                int chMax = chMaxMap.get(firstCh);
                int firstDig = val.charAt(0) - '0';

                chMaxMap.put(firstCh, Math.min(chMax, firstDig));
            }
        }

        List<Code> codes = new ArrayList<>();
        for (char ch : chMaxMap.keySet()) {
            Code code = new Code();
            code.ch = ch;
            code.max = chMaxMap.get(ch);
            code.count = repCount.get(ch);

            codes.add(code);
        }

        Collections.sort(codes);

        StringBuilder sb = new StringBuilder();
        sb.append(zero);

        for (int i = 0; i < codes.size(); i++) {
            sb.append(codes.get(i).ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int testCount = in.nextInt();
        for (int i = 0; i < testCount; i++) {
            int u = in.nextInt();

            final int qCount = 10000;
            long[] q = new long[qCount];
            String[] r = new String[qCount];
            for (int j = 0; j < qCount; j++) {
                q[j] = in.nextInt();
                r[j] = in.next();
            }

            writeTestCase(out, i + 1, new Solution().getAns(u, q, r));
        }

        out.close();
    }

    static void writeTestCase(PrintWriter writer, int num, Object res) {
        writer.println(String.format("Case #%d: %s", num, res.toString()));
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public int[] nextIntArr(int n) {
            int[] arr = new int[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextInt();
            }

            return arr;
        }

        public long[] nextLongArr(int n) {
            long[] arr = new long[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextLong();
            }

            return arr;
        }

        public double[] nextDoubleArr(int n) {
            double[] arr = new double[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextDouble();
            }

            return arr;
        }
    }
}