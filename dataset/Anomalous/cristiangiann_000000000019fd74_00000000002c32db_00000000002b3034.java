import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        for (int caseNum = 0; caseNum < testCases; caseNum++) {
            int patternCount = Integer.parseInt(in.nextLine());
            List<String> patterns = new ArrayList<>();

            for (int i = 0; i < patternCount; i++) {
                patterns.add(in.nextLine());
            }

            List<String> result = new ArrayList<>();
            result.add("");
            result.add("*");
            result.add("*");
            result.add("");

            boolean isValid = true;
            for (String pattern : patterns) {
                if (!isPatternValid(pattern, result)) {
                    isValid = false;
                    break;
                }
                updateResultWithPattern(pattern, result);
            }

            System.out.print("Case #" + (caseNum + 1) + ": ");
            if (isValid) {
                printResult(result);
            } else {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printResult(List<String> result) {
        for (String part : result) {
            if (!part.equals("*")) {
                System.out.print(part);
            }
        }
    }

    private static void updateResultWithPattern(String pattern, List<String> result) {
        String[] parts = pattern.split("\\*");
        if (!pattern.startsWith("*") && isPrefixValid(parts[0], result.get(0))) {
            result.set(0, parts[0]);
        }
        if (!pattern.endsWith("*") && isSuffixValid(parts[parts.length - 1], result.get(result.size() - 1))) {
            result.set(result.size() - 1, parts[parts.length - 1]);
        }
        for (int i = 1; i < parts.length - 1; i++) {
            result.add(2, parts[i]);
        }
    }

    private static boolean isPatternValid(String pattern, List<String> result) {
        String[] parts = pattern.split("\\*");
        return (pattern.startsWith("*") || isPrefixValid(parts[0], result.get(0))) &&
               (pattern.endsWith("*") || isSuffixValid(parts[parts.length - 1], result.get(result.size() - 1)));
    }

    private static boolean isPrefixValid(String prefix, String existingPrefix) {
        int length = Math.min(prefix.length(), existingPrefix.length());
        return prefix.substring(0, length).equals(existingPrefix.substring(0, length));
    }

    private static boolean isSuffixValid(String suffix, String existingSuffix) {
        int length = Math.min(suffix.length(), existingSuffix.length());
        return suffix.substring(suffix.length() - length).equals(existingSuffix.substring(existingSuffix.length() - length));
    }
}