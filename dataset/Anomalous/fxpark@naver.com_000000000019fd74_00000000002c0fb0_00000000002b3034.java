import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer = null;

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private void solve() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(nextToken());

        for (int i = 0; i < testCases; ++i) {
            String result = processTestCase();
            writer.println(String.format("Case #%d: %s", i + 1, result));
        }

        reader.close();
        writer.close();
    }

    private String processTestCase() throws IOException {
        int n = Integer.parseInt(nextToken());
        List<String> patterns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            patterns.add(nextToken());
        }

        patterns.sort(Comparator.comparing(String::length).reversed());

        StringBuilder resultBuilder = new StringBuilder();

        while (!patterns.get(0).isEmpty()) {
            char currentChar = '*';
            int baseLength = patterns.get(0).length();

            for (int i = 0; i < patterns.size(); i++) {
                String pattern = patterns.get(i);

                if (pattern.isEmpty()) continue;

                char lastChar = pattern.charAt(pattern.length() - 1);

                if (lastChar == '*') {
                    if (currentChar != '*') {
                        if (baseLength == 1) {
                            patterns.set(i, pattern.substring(0, pattern.length() - 1));
                        } else if (baseLength == pattern.length()) {
                            if (pattern.charAt(pattern.length() - 2) == currentChar) {
                                patterns.set(i, pattern.substring(0, pattern.length() - 2));
                            }
                        }
                    }
                } else {
                    if (currentChar != '*' && currentChar != lastChar) {
                        return "*";
                    }

                    currentChar = lastChar;
                    patterns.set(i, pattern.substring(0, pattern.length() - 1));
                }
            }

            if (currentChar == '*') {
                for (int i = 0; i < patterns.size(); i++) {
                    String pattern = patterns.get(i);

                    if (pattern.isEmpty()) continue;

                    if (pattern.length() == baseLength) {
                        patterns.set(i, pattern.substring(0, pattern.length() - 1));
                    }
                }
            }

            patterns.sort(Comparator.comparing(String::length).reversed());

            if (currentChar != '*') {
                resultBuilder.append(currentChar);
            }

            for (String pattern : patterns) {
                if (pattern.isEmpty()) {
                    return resultBuilder.reverse().toString();
                }
            }
        }

        return resultBuilder.reverse().toString();
    }
}