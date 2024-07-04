import java.util.*;

public class Solution {

    private String findCommonEnd(List<String> strings) {
        if (strings.isEmpty()) return "";
        strings.sort((s1, s2) -> s2.length() - s1.length());
        String commonSuffix = strings.get(0);

        for (String str : strings) {
            if (!commonSuffix.endsWith(str)) return "";
        }
        return commonSuffix;
    }

    private String findCommonStart(List<String> strings) {
        if (strings.isEmpty()) return "";
        strings.sort((s1, s2) -> s2.length() - s1.length());
        String commonPrefix = strings.get(0);

        for (String str : strings) {
            if (!commonPrefix.startsWith(str)) return "";
        }
        return commonPrefix;
    }

    private String processPatterns(String[] patterns) {
        List<String> prefixes = new ArrayList<>();
        List<String> suffixes = new ArrayList<>();
        StringBuilder middlePart = new StringBuilder();

        for (String pattern : patterns) {
            int firstAsterisk = pattern.indexOf('*');
            int lastAsterisk = pattern.lastIndexOf('*');

            prefixes.add(pattern.substring(0, firstAsterisk));
            suffixes.add(new StringBuilder(pattern.substring(lastAsterisk + 1)).reverse().toString());

            for (int j = firstAsterisk + 1; j < lastAsterisk; j++) {
                if (pattern.charAt(j) != '*') {
                    middlePart.append(pattern.charAt(j));
                }
            }
        }

        if (prefixes.isEmpty() && suffixes.isEmpty()) return "A";

        String commonPrefix = findCommonStart(prefixes);
        String commonSuffix = findCommonEnd(suffixes);

        return commonPrefix + middlePart.toString() + commonSuffix;
    }

    private void printResult(String result, int testCaseNumber) {
        if (result.isEmpty()) result = "*";
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int patternCount = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[patternCount];
            for (int i = 0; i < patternCount; i++) {
                patterns[i] = scanner.nextLine();
            }
            String result = solution.processPatterns(patterns);
            solution.printResult(result, testCase);
        }
    }
}