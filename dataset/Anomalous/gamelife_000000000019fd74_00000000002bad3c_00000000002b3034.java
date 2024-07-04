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
        String leftPart = firstPattern.substring(0, asteriskIndex);
        String rightPart = firstPattern.substring(asteriskIndex + 1);

        for (String pattern : patterns) {
            asteriskIndex = pattern.indexOf("*");
            String currentLeft = pattern.substring(0, asteriskIndex);
            String currentRight = pattern.substring(asteriskIndex + 1);

            if (!isMatchingPrefix(leftPart, currentLeft) || !isMatchingSuffix(rightPart, currentRight)) {
                isValidPattern = false;
                break;
            }

            if (currentLeft.length() > leftPart.length()) {
                leftPart = currentLeft;
            }
            if (currentRight.length() > rightPart.length()) {
                rightPart = currentRight;
            }
        }

        String result = isValidPattern ? leftPart + rightPart : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean isMatchingPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isMatchingSuffix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(s1.length() - 1 - i) != s2.charAt(s2.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}