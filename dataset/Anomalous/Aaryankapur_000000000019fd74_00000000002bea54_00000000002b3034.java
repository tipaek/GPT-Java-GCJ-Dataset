import java.util.*;

public class SolutionPatternMatching {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
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

        boolean isPatternValid = true;
        String previousPattern = patterns.get(0);
        int starIndex = previousPattern.indexOf('*');
        String previousLeft = previousPattern.substring(0, starIndex);
        String previousRight = starIndex < previousPattern.length() ? previousPattern.substring(starIndex + 1) : "";

        System.out.printf("11 previousLeft = %s, previousRight = %s%n", previousLeft, previousRight);

        for (String currentPattern : patterns) {
            starIndex = currentPattern.indexOf('*');
            String currentLeft = currentPattern.substring(0, starIndex);
            String currentRight = starIndex < currentPattern.length() ? currentPattern.substring(starIndex + 1) : "";

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

            System.out.printf("22 previousLeft = %s, previousRight = %s%n", previousLeft, previousRight);
        }

        String result = isPatternValid ? previousLeft + previousRight : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
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
        int prevLength = previous.length();
        int currLength = current.length();
        int minLength = Math.min(prevLength, currLength);

        for (int i = 1; i <= minLength; i++) {
            if (previous.charAt(prevLength - i) != current.charAt(currLength - i)) {
                return false;
            }
        }
        return true;
    }
}