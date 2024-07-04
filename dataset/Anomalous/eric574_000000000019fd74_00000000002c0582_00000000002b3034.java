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

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(scanner.next());
        }

        patterns.sort(Comparator.comparingInt(String::length));

        boolean isPatternValid = true;
        String prefix = getPrefix(patterns.get(0));
        String suffix = getSuffix(patterns.get(0));

        for (String pattern : patterns) {
            String currentPrefix = getPrefix(pattern);
            String currentSuffix = getSuffix(pattern);

            if (!isPrefixCompatible(prefix, currentPrefix) || !isSuffixCompatible(suffix, currentSuffix)) {
                isPatternValid = false;
                break;
            }

            if (currentPrefix.length() > prefix.length()) {
                prefix = currentPrefix;
            }

            if (currentSuffix.length() > suffix.length()) {
                suffix = currentSuffix;
            }
        }

        String result = isPatternValid ? prefix + suffix : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private String getPrefix(String pattern) {
        int starIndex = pattern.indexOf('*');
        return starIndex == -1 ? pattern : pattern.substring(0, starIndex);
    }

    private String getSuffix(String pattern) {
        int starIndex = pattern.indexOf('*');
        return starIndex == -1 ? "" : pattern.substring(starIndex + 1);
    }

    private boolean isPrefixCompatible(String prefix, String currentPrefix) {
        for (int i = 0; i < Math.min(prefix.length(), currentPrefix.length()); i++) {
            if (prefix.charAt(i) != currentPrefix.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixCompatible(String suffix, String currentSuffix) {
        for (int i = 0; i < Math.min(suffix.length(), currentSuffix.length()); i++) {
            if (suffix.charAt(suffix.length() - 1 - i) != currentSuffix.charAt(currentSuffix.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}