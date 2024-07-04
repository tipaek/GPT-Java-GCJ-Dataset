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

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveCases();
        solution.close();
    }

    private void solveCases() {
        int t = readInt();
        for (int i = 1; i <= t; i++) {
            pw.println("Case #" + i + ": " + solve());
        }
    }

    private String solve() {
        int u = readInt();
        String[] responses = new String[10000];
        Set<Character> digits = new HashSet<>();
        Set<Character> firstChars = new HashSet<>();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            responses[i] = stringArray()[1];
            char[] chars = responses[i].toCharArray();
            for (char c : chars) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
                digits.add(c);
            }
            if (responses[i].length() == u - 1) {
                firstChars.add(chars[0]);
            }
        }

        Character zeroDigit = null;
        for (Character c : digits) {
            if (!firstChars.contains(c)) {
                zeroDigit = c;
                break;
            }
        }

        StringBuilder result = new StringBuilder().append(zeroDigit);
        digits.remove(zeroDigit);

        while (!digits.isEmpty()) {
            char maxChar = '\0';
            int maxFrequency = -1;
            for (Character c : digits) {
                int frequency = frequencyMap.get(c);
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                    maxChar = c;
                }
            }
            result.append(maxChar);
            digits.remove(maxChar);
        }

        return result.toString();
    }

    private void close() {
        pw.close();
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private String[] stringArray() {
        StringTokenizer st = new StringTokenizer(readLine());
        int n = st.countTokens();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = st.nextToken();
        }
        return array;
    }
}