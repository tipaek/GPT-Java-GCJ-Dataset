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

        boolean isValidPattern = true;
        String firstPattern = patterns.get(0);
        int asteriskIndex = firstPattern.indexOf("*");
        String leftPrefix = firstPattern.substring(0, asteriskIndex);
        String rightSuffix = firstPattern.substring(asteriskIndex + 1);

        for (String pattern : patterns) {
            asteriskIndex = pattern.indexOf("*");
            String currentLeftPrefix = pattern.substring(0, asteriskIndex);
            String currentRightSuffix = pattern.substring(asteriskIndex + 1);

            if (!isPrefixMatching(leftPrefix, currentLeftPrefix) || !isSuffixMatching(rightSuffix, currentRightSuffix)) {
                isValidPattern = false;
                break;
            }

            if (currentLeftPrefix.length() > leftPrefix.length()) {
                leftPrefix = currentLeftPrefix;
            }

            if (currentRightSuffix.length() > rightSuffix.length()) {
                rightSuffix = currentRightSuffix;
            }
        }

        String result = isValidPattern ? leftPrefix + rightSuffix : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean isPrefixMatching(String prefix1, String prefix2) {
        int minLength = Math.min(prefix1.length(), prefix2.length());
        for (int i = 0; i < minLength; i++) {
            if (prefix1.charAt(i) != prefix2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatching(String suffix1, String suffix2) {
        int minLength = Math.min(suffix1.length(), suffix2.length());
        for (int i = 0; i < minLength; i++) {
            if (suffix1.charAt(suffix1.length() - 1 - i) != suffix2.charAt(suffix2.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}