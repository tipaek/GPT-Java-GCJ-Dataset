import java.util.*;

class SolutionPatternMatching {
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

        for (String pattern : patterns) {
            System.out.println(pattern);
        }

        boolean isPatternMatch = true;
        String firstPattern = patterns.get(0);
        int starIndex = firstPattern.indexOf("*");
        String leftPart = firstPattern.substring(0, starIndex);
        String rightPart = starIndex < firstPattern.length() ? firstPattern.substring(starIndex + 1) : "";

        System.out.println(String.format("Initial leftPart = %s, rightPart = %s", leftPart, rightPart));

        for (String pattern : patterns) {
            starIndex = pattern.indexOf("*");
            String currentLeft = pattern.substring(0, starIndex);
            String currentRight = starIndex < pattern.length() ? pattern.substring(starIndex + 1) : "";

            if (!isMatching(leftPart, currentLeft)) {
                isPatternMatch = false;
                break;
            }

            if (currentLeft.length() > leftPart.length()) {
                leftPart = currentLeft;
            }

            if (!isMatching(new StringBuilder(rightPart).reverse().toString(), new StringBuilder(currentRight).reverse().toString())) {
                isPatternMatch = false;
                break;
            }

            if (currentRight.length() > rightPart.length()) {
                rightPart = currentRight;
            }

            System.out.println(String.format("Updated leftPart = %s, rightPart = %s", leftPart, rightPart));
        }

        String result = isPatternMatch ? leftPart + rightPart : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean isMatching(String prev, String curr) {
        int minLength = Math.min(prev.length(), curr.length());
        for (int i = 0; i < minLength; i++) {
            if (prev.charAt(i) != curr.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}