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
            int numPatterns = Integer.parseInt(reader.readLine());
            List<Pattern> patterns = new ArrayList<>(numPatterns);
            
            for (int j = 0; j < numPatterns; j++) {
                patterns.add(new Pattern(reader.readLine()));
            }
            
            patterns.sort((a, b) -> b.getLength() - a.getLength());
            boolean isMatch = true;
            String longestPattern = patterns.get(0).getPattern().replace("*", "");
            Pattern referencePattern = patterns.get(0);
            
            for (int j = 1; j < patterns.size(); j++) {
                Pattern currentPattern = patterns.get(j);
                if (!currentPattern.matches(referencePattern)) {
                    isMatch = false;
                    break;
                } else {
                    String newPattern = currentPattern.createNewPattern(referencePattern);
                    if (newPattern.length() > longestPattern.length()) {
                        longestPattern = newPattern;
                    }
                }
            }
            
            if (isMatch) {
                System.out.printf("Case #%d: %s%n", (i + 1), longestPattern);
            } else {
                System.out.printf("Case #%d: *%n", (i + 1));
            }
        }
    }

    private static class Pattern {
        private final String[] parts;
        private final int length;
        private final String pattern;

        public Pattern(String pattern) {
            if (pattern.startsWith("*")) {
                this.parts = new String[]{pattern.substring(1)};
            } else {
                this.parts = pattern.split("\\*");
            }
            this.length = pattern.length();
            this.pattern = pattern;
        }

        public boolean matches(Pattern other) {
            if (other.parts.length == 1 && parts.length == 1) {
                boolean oppositeSides = (pattern.startsWith("*") && other.pattern.endsWith("*")) || 
                                        (other.pattern.startsWith("*") && pattern.endsWith("*"));
                if (oppositeSides) return true;
                if (pattern.startsWith("*")) return other.parts[0].endsWith(parts[0]);
                return other.parts[0].startsWith(parts[0]);
            }
            
            if (other.parts.length == 1) {
                return other.parts[0].startsWith(parts[0]) && other.parts[0].endsWith(parts[1]);
            }
            
            if (parts.length == 1) {
                return other.parts[0].startsWith(parts[0]) && other.parts[1].endsWith(parts[0]);
            }
            
            boolean matchesFirst = other.parts[0].startsWith(parts[0]);
            boolean matchesSecond = other.parts[1].endsWith(parts[1]);
            return matchesFirst && matchesSecond;
        }

        public String createNewPattern(Pattern other) {
            boolean singlePart = parts.length == 1 && other.parts.length == 1;
            boolean oppositeSides = (pattern.startsWith("*") && other.pattern.endsWith("*")) || 
                                    (other.pattern.startsWith("*") && pattern.endsWith("*"));
            
            if (singlePart && oppositeSides && !parts[0].equals(other.parts[0])) {
                if (pattern.startsWith("*")) {
                    return other.parts[0] + parts[0];
                } else {
                    return parts[0] + other.parts[0];
                }
            }
            return pattern.replace("*", "");
        }

        public int getLength() {
            return length - 1;
        }

        public String getPattern() {
            return pattern;
        }
    }
}