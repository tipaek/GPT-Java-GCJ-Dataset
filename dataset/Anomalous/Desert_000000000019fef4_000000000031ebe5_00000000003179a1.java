import java.io.*;
import java.util.*;

public class Solution {

    static class Code implements Comparable<Code> {
        char character;
        int frequency;
        int maxDigit;

        @Override
        public int compareTo(Code other) {
            if (maxDigit != other.maxDigit) {
                return maxDigit - other.maxDigit;
            }
            return frequency - other.frequency;
        }
    }

    private String determineAnswer(int u, long[] queries, String[] responses) {
        Set<Character> firstCharacters = new HashSet<>();
        Set<Character> allCharacters = new HashSet<>();
        Map<Character, Integer> characterFrequency = new HashMap<>();

        for (String response : responses) {
            firstCharacters.add(response.charAt(0));
            for (char ch : response.toCharArray()) {
                allCharacters.add(ch);
                characterFrequency.put(ch, characterFrequency.getOrDefault(ch, 0) + 1);
            }
        }

        char zeroCharacter = '-';
        for (char ch : allCharacters) {
            if (!firstCharacters.contains(ch)) {
                zeroCharacter = ch;
                break;
            }
        }

        Map<Character, Integer> maxDigitMap = new HashMap<>();
        for (char ch : firstCharacters) {
            maxDigitMap.put(ch, 9);
        }

        for (int i = 0; i < responses.length; i++) {
            String queryValue = String.valueOf(queries[i]);
            if (queryValue.length() == responses[i].length()) {
                char firstChar = responses[i].charAt(0);
                int maxDigit = maxDigitMap.get(firstChar);
                int firstDigit = queryValue.charAt(0) - '0';
                maxDigitMap.put(firstChar, Math.min(maxDigit, firstDigit));
            }
        }

        List<Code> codes = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : maxDigitMap.entrySet()) {
            Code code = new Code();
            code.character = entry.getKey();
            code.maxDigit = entry.getValue();
            code.frequency = characterFrequency.get(entry.getKey());
            codes.add(code);
        }

        Collections.sort(codes);

        StringBuilder result = new StringBuilder();
        result.append(zeroCharacter);
        for (Code code : codes) {
            result.append(code.character);
        }

        return result.toString();
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
            long[] queries = new long[qCount];
            String[] responses = new String[qCount];
            for (int j = 0; j < qCount; j++) {
                queries[j] = in.nextLong();
                responses[j] = in.next();
            }

            writeTestCase(out, i + 1, new Solution().determineAnswer(u, queries, responses));
        }

        out.close();
    }

    static void writeTestCase(PrintWriter writer, int testCaseNumber, Object result) {
        writer.println(String.format("Case #%d: %s", testCaseNumber, result.toString()));
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        public double[] nextDoubleArray(int n) {
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextDouble();
            }
            return array;
        }
    }
}