import java.util.*;

public class Main {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Main().processCase(caseNum, scanner);
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
        String prefix = patterns.get(0).split("\\*")[0];
        String suffix = patterns.get(0).contains("*") ? patterns.get(0).substring(patterns.get(0).indexOf("*") + 1) : "";

        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*", 2);
            String currentPrefix = parts[0];
            String currentSuffix = parts.length > 1 ? parts[1] : "";

            if (!prefix.startsWith(currentPrefix) && !currentPrefix.startsWith(prefix)) {
                isPatternValid = false;
                break;
            }

            if (!suffix.endsWith(currentSuffix) && !currentSuffix.endsWith(suffix)) {
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
}