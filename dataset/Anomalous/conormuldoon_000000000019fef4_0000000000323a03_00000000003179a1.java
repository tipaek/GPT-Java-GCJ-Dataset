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

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveCases();
        solution.close();
    }

    private void solveCases() {
        int testCases = readInt();
        for (int i = 1; i <= testCases; i++) {
            writer.println("Case #" + i + ": " + solve());
        }
    }

    private String solve() {
        int u = readInt();
        String[] responses = new String[10000];
        Set<Character> singleDigitChars = new HashSet<>();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            responses[i] = readStringArray()[1];
            char[] chars = responses[i].toCharArray();
            for (char c : chars) {
                frequencyMap.merge(c, 1, Integer::sum);
            }
            if (responses[i].length() == 1) {
                singleDigitChars.add(responses[i].charAt(0));
            }
        }

        StringBuilder result = new StringBuilder();
        Set<Character> characters = new HashSet<>(frequencyMap.keySet());

        while (!characters.isEmpty()) {
            int maxFrequency = 0;
            char maxChar = '#';
            for (Character c : characters) {
                int frequency = frequencyMap.get(c);
                if (frequency >= maxFrequency) {
                    maxFrequency = frequency;
                    maxChar = c;
                }
            }
            if (characters.size() == 1) {
                result.insert(0, maxChar);
            } else {
                result.append(maxChar);
            }
            characters.remove(maxChar);
        }

        return result.toString();
    }

    private void close() {
        writer.close();
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String readString() {
        return readLine();
    }

    private long readLong() {
        return Long.parseLong(readLine());
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private String[] readStringArray() {
        StringTokenizer tokenizer = new StringTokenizer(readLine());
        int tokenCount = tokenizer.countTokens();
        String[] tokens = new String[tokenCount];
        for (int i = 0; i < tokenCount; i++) {
            tokens[i] = tokenizer.nextToken();
        }
        return tokens;
    }

    private int[] readIntArray() {
        String[] stringArray = readStringArray();
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    private double[] readDoubleArray() {
        String[] stringArray = readStringArray();
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }

    private long[] readLongArray() {
        String[] stringArray = readStringArray();
        long[] longArray = new long[stringArray.length];
        for (int i = 0; i < longArray.length; i++) {
            longArray[i] = Long.parseLong(stringArray[i]);
        }
        return longArray;
    }

    private double readDouble() {
        return Double.parseDouble(readLine());
    }
}