import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfPatterns = Integer.parseInt(scanner.nextLine());
            List<String> result = initializeResult();
            List<String> patterns = readPatterns(scanner, numberOfPatterns);

            for (String pattern : patterns) {
                boolean startsWithValidPrefix = isValidPrefix(pattern, result);
                boolean endsWithValidSuffix = isValidSuffix(pattern, result);

                if (startsWithValidPrefix && endsWithValidSuffix) {
                    mergePatternIntoResult(pattern, result);
                } else {
                    result = createWildcardResult();
                    break;
                }
            }

            printCaseResult(caseNumber, result);
        }
    }

    private static List<String> initializeResult() {
        List<String> result = new ArrayList<>();
        result.add("");
        result.add("\\*");
        result.add("");
        return result;
    }

    private static List<String> readPatterns(Scanner scanner, int numberOfPatterns) {
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < numberOfPatterns; i++) {
            patterns.add(scanner.nextLine());
        }
        return patterns;
    }

    private static boolean isValidPrefix(String pattern, List<String> result) {
        if (pattern.charAt(0) == '*') return true;
        return isMatchingPrefix(result, pattern.split("\\*")[0]);
    }

    private static boolean isValidSuffix(String pattern, List<String> result) {
        if (pattern.charAt(pattern.length() - 1) == '*') return true;
        String[] parts = pattern.split("\\*");
        return isMatchingSuffix(result, parts[parts.length - 1]);
    }

    private static void mergePatternIntoResult(String pattern, List<String> result) {
        String[] parts = (pattern + "*").split("\\*");

        if (!parts[0].isEmpty() && isValidPrefix(pattern, result)) {
            updateResultStart(result, parts[0]);
        }

        if (pattern.charAt(pattern.length() - 1) != '*' && isValidSuffix(pattern, result)) {
            updateResultEnd(result, parts[parts.length - 1]);
        }

        for (int i = 1; i < parts.length; i++) {
            result.add(1, parts[i]);
        }
    }

    private static void updateResultStart(List<String> result, String newStart) {
        String currentStart = result.get(0);
        if (currentStart.length() < newStart.length()) {
            result.set(0, newStart);
        }
    }

    private static void updateResultEnd(List<String> result, String newEnd) {
        String currentEnd = result.get(result.size() - 1);
        if (currentEnd.length() < newEnd.length()) {
            result.set(result.size() - 1, newEnd);
        }
    }

    private static List<String> createWildcardResult() {
        List<String> wildcardResult = new ArrayList<>();
        wildcardResult.add("\\*");
        return wildcardResult;
    }

    private static void printCaseResult(int caseNumber, List<String> result) {
        System.out.print("Case #" + caseNumber + ": ");
        if (result.size() == 1) {
            System.out.print("*");
        } else {
            for (String part : result) {
                if (!part.equals("\\*")) {
                    System.out.print(part);
                }
            }
        }
        System.out.println();
    }

    private static boolean isMatchingPrefix(List<String> result, String prefix) {
        StringBuilder currentPrefix = new StringBuilder();
        int index = 0;
        while (!result.get(index).equals("\\*")) {
            currentPrefix.append(result.get(index));
            index++;
        }
        return prefix.startsWith(currentPrefix.toString());
    }

    private static boolean isMatchingSuffix(List<String> result, String suffix) {
        StringBuilder currentSuffix = new StringBuilder();
        int index = result.size() - 1;
        while (!result.get(index).equals("\\*")) {
            currentSuffix.insert(0, result.get(index));
            index--;
        }
        return suffix.endsWith(currentSuffix.toString());
    }
}