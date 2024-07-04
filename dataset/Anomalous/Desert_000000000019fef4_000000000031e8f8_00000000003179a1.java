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

    private String computeAnswer(int u, long[] queries, String[] responses) {
        Set<Character> leadingCharacters = new HashSet<>();
        Set<Character> allCharacters = new HashSet<>();
        Map<Character, Integer> characterFrequency = new HashMap<>();

        for (String response : responses) {
            leadingCharacters.add(response.charAt(0));
            for (char ch : response.toCharArray()) {
                allCharacters.add(ch);
                characterFrequency.put(ch, characterFrequency.getOrDefault(ch, 0) + 1);
            }
        }

        char zeroChar = '-';
        for (char ch : allCharacters) {
            if (!leadingCharacters.contains(ch)) {
                zeroChar = ch;
                break;
            }
        }

        Map<Character, Integer> maxDigitMap = new HashMap<>();
        for (char ch : leadingCharacters) {
            maxDigitMap.put(ch, 9);
        }

        for (int i = 0; i < responses.length; i++) {
            String value = String.valueOf(queries[i]);
            if (value.length() == responses[i].length()) {
                char firstChar = responses[i].charAt(0);
                int currentMaxDigit = maxDigitMap.get(firstChar);
                int firstDigit = value.charAt(0) - '0';
                maxDigitMap.put(firstChar, Math.min(currentMaxDigit, firstDigit));
            }
        }

        List<Code> codeList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : maxDigitMap.entrySet()) {
            Code code = new Code();
            code.character = entry.getKey();
            code.maxDigit = entry.getValue();
            code.frequency = characterFrequency.get(entry.getKey());
            codeList.add(code);
        }

        Collections.sort(codeList);

        StringBuilder result = new StringBuilder();
        result.append(zeroChar);
        for (Code code : codeList) {
            result.append(code.character);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader inputReader = new InputReader(inputStream);
        PrintWriter outputWriter = new PrintWriter(outputStream);

        int testCases = inputReader.nextInt();
        for (int i = 0; i < testCases; i++) {
            int u = inputReader.nextInt();
            final int queryCount = 10000;
            long[] queries = new long[queryCount];
            String[] responses = new String[queryCount];
            for (int j = 0; j < queryCount; j++) {
                queries[j] = inputReader.nextLong();
                responses[j] = inputReader.next();
            }
            outputWriter.println(String.format("Case #%d: %s", i + 1, new Solution().computeAnswer(u, queries, responses)));
        }

        outputWriter.close();
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