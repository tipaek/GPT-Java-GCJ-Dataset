import java.util.*;

public class Fun {
    private static final String ANSWER_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int testCaseNum = 1; testCaseNum <= testCases; ++testCaseNum) {
                new Fun().processTestCase(testCaseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processTestCase(int testCaseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(scanner.next());
        }

        Collections.sort(patterns, Comparator.comparingInt(String::length));

        for (String pattern : patterns) {
            System.out.println(pattern);
        }

        boolean isValid = true;
        String firstPattern = patterns.get(0);
        int asteriskIndex = firstPattern.indexOf("*");
        String leftPart = firstPattern.substring(0, asteriskIndex);
        String rightPart = asteriskIndex < firstPattern.length() ? firstPattern.substring(asteriskIndex + 1) : "";

        System.out.println(String.format("Initial leftPart = %s , rightPart = %s", leftPart, rightPart));

        for (String pattern : patterns) {
            asteriskIndex = pattern.indexOf("*");
            String currentLeft = pattern.substring(0, asteriskIndex);
            String currentRight = asteriskIndex < pattern.length() ? pattern.substring(asteriskIndex + 1) : "";

            isValid = compareParts(leftPart, currentLeft, true) && compareParts(rightPart, currentRight, false);

            System.out.println(String.format("Comparing parts, isValid = %s", isValid));

            if (!isValid) break;

            if (currentLeft.length() > leftPart.length()) {
                leftPart = currentLeft;
            }
            if (currentRight.length() > rightPart.length()) {
                rightPart = currentRight;
            }

            System.out.println(String.format("Updated leftPart = %s , rightPart = %s", leftPart, rightPart));
        }

        String result = isValid ? leftPart + rightPart : "*";
        System.out.println(String.format(ANSWER_FORMAT, testCaseNum, result));
    }

    private boolean compareParts(String part1, String part2, boolean isLeftPart) {
        char[] chars1 = part1.toCharArray();
        char[] chars2 = part2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;

        if (isLeftPart) {
            for (int i = 0; i < Math.min(length1, length2); i++) {
                if (chars1[i] != chars2[i]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < Math.min(length1, length2); i++) {
                if (chars1[length1 - 1 - i] != chars2[length2 - 1 - i]) {
                    return false;
                }
            }
        }
        return true;
    }
}