import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            List<Pattern> words = new ArrayList<>(t);
            for (int x = 0; x < n; x++) {
                words.add(new Pattern(reader.readLine()));
            }
            words.sort((a, b) -> b.length() - a.length());
            boolean matches = true;
            for (int x = 0; x < words.size() - 1; x++) {
                Pattern currentWord = words.get(x);
                Pattern nextWord = words.get(x + 1);
                if (!currentWord.matches(nextWord)) {
                    matches = false;
                    break;
                }
            }
            String word = words.get(0).word.replaceAll("\\*", "");
            if (matches) {
                System.out.println(String.format("Case #%d: %s", (i + 1), word));
            } else {
                System.out.println(String.format("Case #%d: *", (i + 1)));
            }
        }
    }

    private static class Pattern {
        private final String[] parts;
        private final int length;
        private final String word;

        public Pattern(String word) {
            this.parts = word.split("\\*");
            this.length = word.length();
            this.word = word;
        }

        public boolean matches(Pattern pattern) {
            boolean matchesFirst = parts[0].startsWith(pattern.parts[0]) || pattern.parts[0].startsWith(parts[0]);
            boolean matchesSecond = parts.length == 1 || pattern.parts.length == 1 || parts[1].endsWith(pattern.parts[1]) || pattern.parts[1].startsWith(parts[1]);
            return matchesFirst && matchesSecond;
        }

        public int length() {
            return length;
        }
    }

}