import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Pattern {
        String prefix, suffix;

        Pattern(String prefix, String suffix) {
            this.prefix = prefix;
            this.suffix = suffix;
        }
    }

    private void process() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfPatterns = scanner.nextInt();
            List<Pattern> patterns = new ArrayList<>();
            for (int i = 0; i < numberOfPatterns; i++) {
                String pattern = scanner.next();
                if (pattern.charAt(0) == '*') {
                    patterns.add(new Pattern("", pattern.substring(1)));
                } else if (pattern.charAt(pattern.length() - 1) == '*') {
                    patterns.add(new Pattern(pattern.substring(0, pattern.length() - 1), ""));
                } else {
                    String[] parts = pattern.split("\\*");
                    patterns.add(new Pattern(parts[0], parts[1]));
                }
            }

            patterns.sort(Comparator.comparingInt(p -> p.prefix.length()));

            boolean isValid = true;
            for (int i = 1; i < patterns.size(); i++) {
                isValid &= patterns.get(i).prefix.startsWith(patterns.get(i - 1).prefix);
            }
            String result = isValid ? patterns.get(patterns.size() - 1).prefix : "*";

            if (isValid) {
                patterns.sort(Comparator.comparingInt(p -> p.suffix.length()));
                for (int i = 1; i < patterns.size(); i++) {
                    isValid &= patterns.get(i).suffix.endsWith(patterns.get(i - 1).suffix);
                }
                result = isValid ? result + patterns.get(patterns.size() - 1).suffix : "*";
            }

            System.out.printf("Case #%d: %s\n", caseNumber, result);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().process();
    }
}