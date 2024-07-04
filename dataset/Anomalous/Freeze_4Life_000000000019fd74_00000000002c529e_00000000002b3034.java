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

        for (String pattern : patterns) {
            System.out.println(pattern);
        }

        boolean isPatternValid = true;
        String firstPattern = patterns.get(0);
        int starIndex = firstPattern.indexOf("*");
        String leftPart = firstPattern.substring(0, starIndex);
        String rightPart = starIndex < firstPattern.length() ? firstPattern.substring(starIndex + 1) : "";

        System.out.printf("Initial leftPart = %s, rightPart = %s%n", leftPart, rightPart);

        for (String pattern : patterns) {
            starIndex = pattern.indexOf("*");
            String currentLeft = pattern.substring(0, starIndex);
            String currentRight = starIndex < pattern.length() ? pattern.substring(starIndex + 1) : "";

            if (!isMatching(leftPart, currentLeft)) {
                isPatternValid = false;
                break;
            }

            if (currentLeft.length() > leftPart.length()) {
                leftPart = currentLeft;
            }

            if (!isMatching(new StringBuilder(rightPart).reverse().toString(), new StringBuilder(currentRight).reverse().toString())) {
                isPatternValid = false;
                break;
            }

            if (currentRight.length() > rightPart.length()) {
                rightPart = currentRight;
            }

            System.out.printf("Updated leftPart = %s, rightPart = %s%n", leftPart, rightPart);
        }

        String result = isPatternValid ? leftPart + rightPart : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
    }

    private boolean isMatching(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}