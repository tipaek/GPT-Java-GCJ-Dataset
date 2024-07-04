import java.util.*;

public class Solution_PatternMatching {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution_PatternMatching().processCase(caseNum, scanner);
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

        for (String pattern : patterns) {
            System.out.println(pattern);
        }

        boolean isPatternValid = true;
        String basePattern = patterns.get(0);
        int asteriskIndex = basePattern.indexOf("*");
        String leftPart = basePattern.substring(0, asteriskIndex);
        String rightPart = basePattern.substring(asteriskIndex + 1);

        System.out.println(String.format("Initial leftPart = %s, rightPart = %s", leftPart, rightPart));

        for (String pattern : patterns) {
            asteriskIndex = pattern.indexOf("*");
            String currentLeft = pattern.substring(0, asteriskIndex);
            String currentRight = pattern.substring(asteriskIndex + 1);

            if (!isMatching(leftPart, currentLeft) || !isMatching(new StringBuilder(rightPart).reverse().toString(), new StringBuilder(currentRight).reverse().toString())) {
                isPatternValid = false;
                break;
            }

            if (currentLeft.length() > leftPart.length()) {
                leftPart = currentLeft;
            }

            if (currentRight.length() > rightPart.length()) {
                rightPart = currentRight;
            }

            System.out.println(String.format("Updated leftPart = %s, rightPart = %s", leftPart, rightPart));
        }

        String result = isPatternValid ? leftPart + rightPart : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean isMatching(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}