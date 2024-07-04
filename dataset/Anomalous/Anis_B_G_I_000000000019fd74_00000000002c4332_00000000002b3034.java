import java.util.*;

public class Solution {

    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(scanner.next());
        }

        patterns.sort(Comparator.comparingInt(String::length));

        boolean isPatternValid = true;
        String prefix = extractPrefix(patterns.get(0));
        String suffix = extractSuffix(patterns.get(0));

        for (String pattern : patterns) {
            String currentPrefix = extractPrefix(pattern);
            String currentSuffix = extractSuffix(pattern);

            if (!prefixMatches(prefix, currentPrefix) || !suffixMatches(suffix, currentSuffix)) {
                isPatternValid = false;
                break;
            }

            if (currentPrefix.length() > prefix.length()) {
                prefix = currentPrefix;
            }
            if (currentSuffix.length() > suffix.length()) {
                suffix = currentSuffix;
            }
        }

        String result = isPatternValid ? prefix + suffix : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
        System.out.println();
    }

    private String extractPrefix(String pattern) {
        int index = pattern.indexOf('*');
        return index == -1 ? pattern : pattern.substring(0, index);
    }

    private String extractSuffix(String pattern) {
        int index = pattern.indexOf('*');
        return index == -1 ? "" : pattern.substring(index + 1);
    }

    private boolean prefixMatches(String prefix, String currentPrefix) {
        int minLength = Math.min(prefix.length(), currentPrefix.length());
        for (int i = 0; i < minLength; i++) {
            if (prefix.charAt(i) != currentPrefix.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean suffixMatches(String suffix, String currentSuffix) {
        int minLength = Math.min(suffix.length(), currentSuffix.length());
        for (int i = 0; i < minLength; i++) {
            if (suffix.charAt(suffix.length() - 1 - i) != currentSuffix.charAt(currentSuffix.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}