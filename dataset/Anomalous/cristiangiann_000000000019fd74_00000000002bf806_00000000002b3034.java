import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int numPatterns = Integer.parseInt(scanner.nextLine());
            List<String> result = new ArrayList<>();
            result.add("");
            result.add("*");
            result.add("*");
            result.add("");

            List<String> patterns = new ArrayList<>();
            for (int i = 0; i < numPatterns; i++) {
                patterns.add(scanner.nextLine());
            }

            for (String pattern : patterns) {
                boolean startsWithValidPrefix = checkPrefix(pattern, result);
                boolean endsWithValidSuffix = checkSuffix(pattern, result);

                if (startsWithValidPrefix && endsWithValidSuffix) {
                    mergePatternIntoResult(pattern, result);
                } else {
                    result.clear();
                    result.add("*");
                    break;
                }
            }

            System.out.print("Case #" + (caseIndex + 1) + ": ");
            printResult(result);
            System.out.println();
        }
    }

    private static void printResult(List<String> result) {
        if (result.size() == 1) {
            System.out.print("*");
        } else {
            for (String part : result) {
                if (!part.equals("*")) {
                    System.out.print(part);
                }
            }
        }
    }

    private static void mergePatternIntoResult(String pattern, List<String> result) {
        String[] parts = pattern.split("\\*");

        if (!pattern.startsWith("*") && checkPrefix(pattern, result)) {
            String currentPrefix = result.get(0);
            if (currentPrefix.length() < parts[0].length()) {
                result.set(0, parts[0]);
            }
        }

        if (!pattern.endsWith("*") && checkSuffix(pattern, result)) {
            String currentSuffix = result.get(result.size() - 1);
            if (currentSuffix.length() < parts[parts.length - 1].length()) {
                result.set(result.size() - 1, parts[parts.length - 1]);
            }
        }

        for (int i = 1; i < parts.length - 1; i++) {
            result.add(2, parts[i]);
        }
    }

    private static boolean checkSuffix(String pattern, List<String> result) {
        if (pattern.endsWith("*")) {
            return true;
        }
        String[] parts = pattern.split("\\*");
        return isValidSuffix(result, parts[parts.length - 1]);
    }

    private static boolean checkPrefix(String pattern, List<String> result) {
        if (pattern.startsWith("*")) {
            return true;
        }
        return isValidPrefix(result, pattern.split("\\*")[0]);
    }

    private static boolean isValidSuffix(List<String> result, String suffix) {
        if (result.isEmpty()) {
            return true;
        }

        String currentSuffix = "";
        int index = result.size() - 1;
        while (!result.get(index).equals("*")) {
            currentSuffix = result.get(index) + currentSuffix;
            index--;
        }

        int minLength = Math.min(currentSuffix.length(), suffix.length());
        return suffix.substring(suffix.length() - minLength).equals(currentSuffix.substring(currentSuffix.length() - minLength));
    }

    private static boolean isValidPrefix(List<String> result, String prefix) {
        String currentPrefix = "";
        int index = 0;
        while (!result.get(index).equals("*")) {
            currentPrefix += result.get(index);
            index++;
        }

        int minLength = Math.min(currentPrefix.length(), prefix.length());
        return prefix.substring(0, minLength).equals(currentPrefix.substring(0, minLength));
    }
}