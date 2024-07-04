import java.util.*;

public class Solution {

    private String findCommonSuffix(List<String> list) {
        if (list.isEmpty()) return "";
        list.sort((s1, s2) -> s2.length() - s1.length());
        String commonSuffix = list.get(0);

        for (String str : list) {
            if (!commonSuffix.endsWith(str)) return "";
        }

        return commonSuffix;
    }

    private String findCommonPrefix(List<String> list) {
        if (list.isEmpty()) return "";
        list.sort((s1, s2) -> s2.length() - s1.length());
        String commonPrefix = list.get(0);

        for (String str : list) {
            if (!commonPrefix.startsWith(str)) return "";
        }

        return commonPrefix;
    }

    private String assembleString(String[] patterns) {
        List<String> prefixes = new ArrayList<>();
        List<String> suffixes = new ArrayList<>();
        StringBuilder middlePart = new StringBuilder();

        for (String pattern : patterns) {
            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            int firstAsterisk = pattern.indexOf('*');
            int lastAsterisk = pattern.lastIndexOf('*');

            for (int i = 0; i < firstAsterisk; i++) {
                prefix.append(pattern.charAt(i));
            }
            prefixes.add(prefix.toString());

            for (int i = pattern.length() - 1; i > lastAsterisk; i--) {
                suffix.insert(0, pattern.charAt(i));
            }
            suffixes.add(suffix.toString());

            for (int i = firstAsterisk + 1; i < lastAsterisk; i++) {
                if (pattern.charAt(i) != '*') {
                    middlePart.append(pattern.charAt(i));
                }
            }
        }

        if (prefixes.isEmpty() && suffixes.isEmpty()) return "A";

        String commonPrefix = findCommonPrefix(prefixes);
        String commonSuffix = findCommonSuffix(suffixes);

        return commonPrefix + middlePart.toString() + commonSuffix;
    }

    private void printResult(String result, int testCaseNumber) {
        if (result.isEmpty() || result.length() > 10000) result = "*";
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
            int patternCount = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[patternCount];
            for (int i = 0; i < patternCount; i++) {
                patterns[i] = scanner.nextLine();
            }
            String result = solution.assembleString(patterns);
            solution.printResult(result, testCaseNumber);
        }
    }
}