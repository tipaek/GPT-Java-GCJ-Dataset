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

        boolean isPatternMatching = true;
        String firstPattern = patterns.get(0);
        int starIndex = firstPattern.indexOf("*");
        String prefix = firstPattern.substring(0, starIndex);
        String suffix = firstPattern.substring(starIndex + 1);

        System.out.printf("Initial prefix = %s, suffix = %s%n", prefix, suffix);

        for (String pattern : patterns) {
            starIndex = pattern.indexOf("*");
            String currentPrefix = pattern.substring(0, starIndex);
            String currentSuffix = pattern.substring(starIndex + 1);

            if (!isMatching(prefix, currentPrefix) || !isMatching(new StringBuilder(suffix).reverse().toString(), new StringBuilder(currentSuffix).reverse().toString())) {
                isPatternMatching = false;
                break;
            }

            if (currentPrefix.length() > prefix.length()) {
                prefix = currentPrefix;
            }

            if (currentSuffix.length() > suffix.length()) {
                suffix = currentSuffix;
            }

            System.out.printf("Updated prefix = %s, suffix = %s%n", prefix, suffix);
        }

        String result = isPatternMatching ? prefix + suffix : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
    }

    private boolean isMatching(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}