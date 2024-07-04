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

        boolean isPatternMatch = true;
        String firstPattern = patterns.get(0);
        String[] firstParts = firstPattern.split("\\*", 2);
        String leftPart = firstParts[0];
        String rightPart = firstParts.length > 1 ? firstParts[1] : "";

        System.out.printf("11 leftPart = %s , rightPart = %s%n", leftPart, rightPart);

        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*", 2);
            String currentLeft = parts[0];
            String currentRight = parts.length > 1 ? parts[1] : "";

            if (!leftPart.startsWith(currentLeft)) {
                isPatternMatch = false;
                break;
            }

            if (currentLeft.length() > leftPart.length()) {
                leftPart = currentLeft;
            }

            if (!rightPart.endsWith(currentRight)) {
                isPatternMatch = false;
                break;
            }

            if (currentRight.length() > rightPart.length()) {
                rightPart = currentRight;
            }

            System.out.printf("22 leftPart = %s , rightPart = %s%n", leftPart, rightPart);
        }

        String result = isPatternMatch ? leftPart + rightPart : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
    }
}