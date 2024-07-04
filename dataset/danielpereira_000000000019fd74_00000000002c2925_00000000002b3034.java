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
            String word = words.get(0).word.replaceAll("\\*", "");
            Pattern firstWord = words.get(0);
            for (int x = 1; x < words.size(); x++) {
                Pattern currentWord = words.get(x);
                if (!currentWord.matches(firstWord)) {
                    matches = false;
                    break;
                } else {
                    String newWord = currentWord.newWord(firstWord);
                    if (newWord.length() > word.length()) {
                        word = newWord;
                    }
                }
            }

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
            if (word.startsWith("*")) {
                this.parts = new String[]{word.substring(1)};
            } else {
                this.parts = word.split("\\*");
            }
            this.length = word.length();
            this.word = word;
        }

        public boolean matches(Pattern pattern) {
            if (pattern.parts.length == 1 && parts.length == 1) {
                boolean oppositeSides = (word.startsWith("*") && pattern.word.endsWith("*")) || (pattern.word.startsWith("*") && word.endsWith("*"));
                if (oppositeSides) {
                    return true;
                }
                if (word.startsWith("*")) {
                    return pattern.parts[0].endsWith(parts[0]);
                }
                return pattern.parts[0].startsWith(parts[0]);
            }
            if (pattern.parts.length == 1) {
                return pattern.parts[0].startsWith(parts[0]) && pattern.parts[0].endsWith(parts[1]);
            }
            if (parts.length == 1) {
                return pattern.parts[0].startsWith(parts[0]) && pattern.parts[1].endsWith(parts[0]);
            }
            boolean matchesFirst = pattern.parts[0].startsWith(parts[0]);
            boolean matchesSecond = pattern.parts[1].endsWith(parts[1]);
            return matchesFirst && matchesSecond;
        }

        private String newWord(Pattern pattern) {
            boolean wholeWord = parts.length == 1 && pattern.parts.length == 1;
            boolean oppositeSides = (word.startsWith("*") && pattern.word.endsWith("*")) || (pattern.word.startsWith("*") && word.endsWith("*"));
            if (wholeWord && oppositeSides && !parts[0].equals(pattern.parts[0])) {
                if (word.startsWith("*")) {
                    return pattern.parts[0] + parts[0];
                } else {
                    return parts[0] + pattern.parts[0];
                }
            }
            return word.replaceAll("\\*", "");
        }

        public int length() {
            return length - 1;
        }
    }

}