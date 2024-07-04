import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            int numberOfPatterns = Integer.parseInt(reader.readLine());
            List<Pattern> patterns = new ArrayList<>(numberOfPatterns);

            for (int j = 0; j < numberOfPatterns; j++) {
                patterns.add(new Pattern(reader.readLine()));
            }

            patterns.sort((p1, p2) -> p2.getLength() - p1.getLength());

            boolean allMatch = true;
            for (int j = 0; j < patterns.size() - 1; j++) {
                if (!patterns.get(j).matches(patterns.get(j + 1))) {
                    allMatch = false;
                    break;
                }
            }

            String result = allMatch ? patterns.get(0).getWord().replace("*", "") : "*";
            System.out.println(String.format("Case #%d: %s", i + 1, result));
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

        public boolean matches(Pattern other) {
            boolean firstPartMatches = parts[0].startsWith(other.parts[0]) || other.parts[0].startsWith(parts[0]);
            boolean secondPartMatches = parts.length < 2 || other.parts.length < 2 || parts[1].endsWith(other.parts[1]) || other.parts[1].endsWith(parts[1]);
            return firstPartMatches && secondPartMatches;
        }

        public int getLength() {
            return length;
        }

        public String getWord() {
            return word;
        }
    }
}