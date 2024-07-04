import java.util.*;

public class SolutionPatternMatching {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; caseNum++) {
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

        for (String pattern : patterns) {
            System.out.println(pattern);
        }

        boolean isPatternMatch = true;
        String previousPattern = patterns.get(0);
        int asteriskIndex = previousPattern.indexOf('*');
        String previousLeft = previousPattern.substring(0, asteriskIndex);
        String previousRight = asteriskIndex < previousPattern.length() - 1 ? previousPattern.substring(asteriskIndex + 1) : "";

        System.out.printf("Initial previousLeft = %s, previousRight = %s%n", previousLeft, previousRight);

        for (String currentPattern : patterns) {
            asteriskIndex = currentPattern.indexOf('*');
            String currentLeft = currentPattern.substring(0, asteriskIndex);
            String currentRight = asteriskIndex < currentPattern.length() - 1 ? currentPattern.substring(asteriskIndex + 1) : "";

            if (!isPrefixMatch(previousLeft, currentLeft)) {
                isPatternMatch = false;
                break;
            }

            if (currentLeft.length() > previousLeft.length()) {
                previousLeft = currentLeft;
            }

            if (!isSuffixMatch(previousRight, currentRight)) {
                isPatternMatch = false;
                break;
            }

            if (currentRight.length() > previousRight.length()) {
                previousRight = currentRight;
            }

            System.out.printf("Updated previousLeft = %s, previousRight = %s%n", previousLeft, previousRight);
        }

        String result = isPatternMatch ? previousLeft + previousRight : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
    }

    private boolean isPrefixMatch(String prefix1, String prefix2) {
        int minLength = Math.min(prefix1.length(), prefix2.length());
        for (int i = 0; i < minLength; i++) {
            if (prefix1.charAt(i) != prefix2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatch(String suffix1, String suffix2) {
        int minLength = Math.min(suffix1.length(), suffix2.length());
        for (int i = 0; i < minLength; i++) {
            if (suffix1.charAt(suffix1.length() - 1 - i) != suffix2.charAt(suffix2.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}