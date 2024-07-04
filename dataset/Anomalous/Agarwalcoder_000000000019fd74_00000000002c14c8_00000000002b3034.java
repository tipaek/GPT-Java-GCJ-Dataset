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

    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(scanner.next());
        }

        patterns.sort(Comparator.comparingInt(String::length));

        boolean isPatternValid = true;
        String previousPattern = patterns.get(0);
        int asteriskIndex = previousPattern.indexOf('*');
        String previousLeft = previousPattern.substring(0, asteriskIndex);
        String previousRight = previousPattern.substring(asteriskIndex + 1);

        for (String pattern : patterns) {
            asteriskIndex = pattern.indexOf('*');
            String currentLeft = pattern.substring(0, asteriskIndex);
            String currentRight = pattern.substring(asteriskIndex + 1);

            if (!isPrefixMatching(previousLeft, currentLeft) || !isSuffixMatching(previousRight, currentRight)) {
                isPatternValid = false;
                break;
            }

            if (currentLeft.length() > previousLeft.length()) {
                previousLeft = currentLeft;
            }

            if (currentRight.length() > previousRight.length()) {
                previousRight = currentRight;
            }
        }

        String result = isPatternValid ? previousLeft + previousRight : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean isPrefixMatching(String previous, String current) {
        int minLength = Math.min(previous.length(), current.length());
        for (int i = 0; i < minLength; i++) {
            if (previous.charAt(i) != current.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatching(String previous, String current) {
        int minLength = Math.min(previous.length(), current.length());
        for (int i = 0; i < minLength; i++) {
            if (previous.charAt(previous.length() - 1 - i) != current.charAt(current.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}