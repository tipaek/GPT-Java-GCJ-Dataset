import java.util.*;

public class Solution {
    private static final String OUTPUT_TEMPLATE = "Case #%d: %s";

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

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(scanner.next());
        }

        patterns.sort(Comparator.comparingInt(String::length));

        boolean isValidPattern = true;
        String leftPart = extractLeftPart(patterns.get(0));
        String rightPart = extractRightPart(patterns.get(0));

        for (String pattern : patterns) {
            String currentLeft = extractLeftPart(pattern);
            String currentRight = extractRightPart(pattern);

            if (!isMatching(leftPart, currentLeft) || !isMatching(new StringBuilder(rightPart).reverse().toString(), new StringBuilder(currentRight).reverse().toString())) {
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
        System.out.println(String.format(OUTPUT_TEMPLATE, caseNum, result));
    }

    private String extractLeftPart(String pattern) {
        int index = pattern.indexOf('*');
        return (index == -1) ? pattern : pattern.substring(0, index);
    }

    private String extractRightPart(String pattern) {
        int index = pattern.indexOf('*');
        return (index == -1) ? "" : pattern.substring(index + 1);
    }

    private boolean isMatching(String part1, String part2) {
        int minLength = Math.min(part1.length(), part2.length());
        for (int i = 0; i < minLength; i++) {
            if (part1.charAt(i) != part2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}