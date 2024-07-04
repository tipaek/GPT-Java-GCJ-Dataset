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

        boolean isPatternMatching = true;
        String initialPattern = patterns.get(0);
        int starIndex = initialPattern.indexOf("*");
        String leftPart = initialPattern.substring(0, starIndex);
        String rightPart = starIndex < initialPattern.length() ? initialPattern.substring(starIndex + 1) : "";

        for (String pattern : patterns) {
            starIndex = pattern.indexOf("*");
            String currentLeft = pattern.substring(0, starIndex);
            String currentRight = starIndex < pattern.length() ? pattern.substring(starIndex + 1) : "";

            if (!isMatching(leftPart, currentLeft)) {
                isPatternMatching = false;
                break;
            }

            if (currentLeft.length() > leftPart.length()) {
                leftPart = currentLeft;
            }

            if (!isMatching(new StringBuilder(rightPart).reverse().toString(), new StringBuilder(currentRight).reverse().toString())) {
                isPatternMatching = false;
                break;
            }

            if (currentRight.length() > rightPart.length()) {
                rightPart = currentRight;
            }
        }

        String result = isPatternMatching ? leftPart + rightPart : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean isMatching(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int i = 0;
        while (i < len1 && i < len2) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}