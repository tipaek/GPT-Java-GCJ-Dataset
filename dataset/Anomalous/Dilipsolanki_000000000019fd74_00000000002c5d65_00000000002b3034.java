import java.util.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; caseNum++) {
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

        boolean isMatching = true;
        String longestLeft = "";
        String longestRight = "";
        
        String firstPattern = patterns.get(0);
        int firstAsteriskIndex = firstPattern.indexOf('*');
        String firstLeft = firstPattern.substring(0, firstAsteriskIndex);
        String firstRight = firstPattern.substring(firstAsteriskIndex + 1);

        for (String pattern : patterns) {
            int asteriskIndex = pattern.indexOf('*');
            String leftPart = pattern.substring(0, asteriskIndex);
            String rightPart = pattern.substring(asteriskIndex + 1);

            if (!isPrefixMatching(longestLeft, leftPart) || !isSuffixMatching(longestRight, rightPart)) {
                isMatching = false;
                break;
            }

            if (leftPart.length() > longestLeft.length()) {
                longestLeft = leftPart;
            }
            if (rightPart.length() > longestRight.length()) {
                longestRight = rightPart;
            }
        }

        String result = isMatching ? longestLeft + longestRight : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean isPrefixMatching(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatching(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(str1.length() - 1 - i) != str2.charAt(str2.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}