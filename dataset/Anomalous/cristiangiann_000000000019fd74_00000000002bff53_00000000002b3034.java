import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int patternCount = Integer.parseInt(scanner.nextLine());
            List<String> patterns = new ArrayList<>();
            for (int i = 0; i < patternCount; i++) {
                patterns.add(scanner.nextLine());
            }
            List<String> result = processPatterns(patterns);
            System.out.print("Case #" + (caseIndex + 1) + ": ");
            printResult(result);
            System.out.println();
        }
    }

    private static List<String> processPatterns(List<String> patterns) {
        List<String> result = new ArrayList<>();
        result.add("");
        result.add("*");
        result.add("*");
        result.add("");

        for (String pattern : patterns) {
            boolean startsWithValidPattern = checkStart(pattern, result);
            boolean endsWithValidPattern = checkEnd(pattern, result);
            if (startsWithValidPattern && endsWithValidPattern) {
                addPatternToResult(pattern, result);
            } else {
                result.clear();
                result.add("*");
                break;
            }
        }
        return result;
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

    private static void addPatternToResult(String pattern, List<String> result) {
        String[] parts = pattern.split("\\*");
        if (!pattern.startsWith("*") && checkStart(pattern, result)) {
            String currentStart = result.get(0);
            if (currentStart.length() < parts[0].length()) {
                result.set(0, parts[0]);
            }
        }
        if (!pattern.endsWith("*") && checkEnd(pattern, result)) {
            String currentEnd = result.get(result.size() - 1);
            if (currentEnd.length() < parts[parts.length - 1].length()) {
                result.set(result.size() - 1, parts[parts.length - 1]);
            }
        }
        for (int i = 1; i < parts.length - 1; i++) {
            result.add(2, parts[i]);
        }
        if (!pattern.endsWith("*")) {
            result.add(2, parts[parts.length - 1]);
        }
    }

    private static boolean checkEnd(String pattern, List<String> result) {
        if (pattern.endsWith("*")) {
            return true;
        }
        String[] parts = pattern.split("\\*");
        return checkEndString(result, parts[parts.length - 1]);
    }

    private static boolean checkStart(String pattern, List<String> result) {
        if (pattern.startsWith("*")) {
            return true;
        }
        return checkStartString(result, pattern.split("\\*")[0]);
    }

    private static boolean checkEndString(List<String> result, String endPart) {
        if (result.isEmpty()) {
            return true;
        }
        StringBuilder end = new StringBuilder();
        int index = result.size() - 1;
        String temp = result.get(index);
        while (!temp.equals("*")) {
            end.insert(0, temp);
            index--;
            temp = result.get(index);
        }
        int length = Math.min(end.length(), endPart.length());
        return endPart.regionMatches(true, endPart.length() - length, end.toString(), end.length() - length, length);
    }

    private static boolean checkStartString(List<String> result, String startPart) {
        StringBuilder start = new StringBuilder();
        int index = 0;
        String temp = result.get(index);
        while (!temp.equals("*")) {
            start.append(temp);
            index++;
            temp = result.get(index);
        }
        int length = Math.min(start.length(), startPart.length());
        return startPart.regionMatches(true, 0, start.toString(), 0, length);
    }
}