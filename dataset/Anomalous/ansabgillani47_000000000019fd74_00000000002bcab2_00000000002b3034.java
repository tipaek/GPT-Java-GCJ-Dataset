import java.util.*;

public class SolutionPatternMatching {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new SolutionPatternMatching().processCase(caseNum, scanner);
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

        boolean isPatternMatching = true;
        String firstPattern = patterns.get(0);
        int asteriskIndex = firstPattern.indexOf('*');
        String leftPart = firstPattern.substring(0, asteriskIndex);
        String rightPart = firstPattern.substring(asteriskIndex + 1);

        for (String pattern : patterns) {
            asteriskIndex = pattern.indexOf('*');
            String currentLeft = pattern.substring(0, asteriskIndex);
            String currentRight = pattern.substring(asteriskIndex + 1);

            if (!isPrefixMatching(leftPart, currentLeft) || !isSuffixMatching(rightPart, currentRight)) {
                isPatternMatching = false;
                break;
            }

            if (currentLeft.length() > leftPart.length()) {
                leftPart = currentLeft;
            }
            if (currentRight.length() > rightPart.length()) {
                rightPart = currentRight;
            }
        }

        String result = isPatternMatching ? leftPart + rightPart : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
    }

    private boolean isPrefixMatching(String first, String second) {
        for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatching(String first, String second) {
        for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
            if (first.charAt(first.length() - 1 - i) != second.charAt(second.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}