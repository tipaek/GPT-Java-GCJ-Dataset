import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int patternsCount = Integer.parseInt(scanner.nextLine());
            List<String> result = initializeResult();
            List<String> patterns = new ArrayList<>();

            for (int i = 0; i < patternsCount; i++) {
                patterns.add(scanner.nextLine());
            }

            for (String pattern : patterns) {
                if (isValidPattern(pattern, result)) {
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

    private static List<String> initializeResult() {
        List<String> result = new ArrayList<>();
        result.add("");
        result.add("*");
        result.add("*");
        result.add("");
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

    private static void mergePatternIntoResult(String pattern, List<String> result) {
        String[] segments = pattern.split("\\*");
        if (pattern.charAt(0) != '*' && isValidStart(pattern, result)) {
            String startSegment = result.get(0);
            if (startSegment.length() < segments[0].length()) {
                result.set(0, segments[0]);
            }
        }
        if (pattern.charAt(pattern.length() - 1) != '*' && isValidEnd(pattern, result)) {
            String endSegment = result.get(result.size() - 1);
            if (endSegment.length() < segments[segments.length - 1].length()) {
                result.set(result.size() - 1, segments[segments.length - 1]);
            }
        }
        for (int i = 1; i < segments.length - 1; i++) {
            result.add(2, segments[i]);
        }
        if (pattern.charAt(pattern.length() - 1) == '*' && segments.length != 1) {
            result.add(2, segments[segments.length - 1]);
        }
    }

    private static boolean isValidPattern(String pattern, List<String> result) {
        return isValidStart(pattern, result) && isValidEnd(pattern, result);
    }

    private static boolean isValidEnd(String pattern, List<String> result) {
        if (pattern.charAt(pattern.length() - 1) == '*') {
            return true;
        }
        String[] segments = pattern.split("\\*");
        return isValidEndSegment(result, segments[segments.length - 1]);
    }

    private static boolean isValidStart(String pattern, List<String> result) {
        if (pattern.charAt(0) == '*') {
            return true;
        }
        return isValidStartSegment(result, pattern.split("\\*")[0]);
    }

    private static boolean isValidEndSegment(List<String> result, String segment) {
        if (result.isEmpty()) {
            return true;
        }
        String endSegment = concatenateEndSegment(result);
        int minLength = Math.min(endSegment.length(), segment.length());
        return segment.substring(segment.length() - minLength).equalsIgnoreCase(endSegment.substring(endSegment.length() - minLength));
    }

    private static boolean isValidStartSegment(List<String> result, String segment) {
        String startSegment = concatenateStartSegment(result);
        int minLength = Math.min(startSegment.length(), segment.length());
        return segment.substring(0, minLength).equalsIgnoreCase(startSegment.substring(0, minLength));
    }

    private static String concatenateEndSegment(List<String> result) {
        StringBuilder endSegment = new StringBuilder();
        int index = result.size() - 1;
        while (!result.get(index).equals("*")) {
            endSegment.insert(0, result.get(index));
            index--;
        }
        return endSegment.toString();
    }

    private static String concatenateStartSegment(List<String> result) {
        StringBuilder startSegment = new StringBuilder();
        int index = 0;
        while (!result.get(index).equals("*")) {
            startSegment.append(result.get(index));
            index++;
        }
        return startSegment.toString();
    }
}