import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int numPatterns = Integer.parseInt(scanner.nextLine());
            List<String> patterns = new ArrayList<>();
            for (int i = 0; i < numPatterns; i++) {
                patterns.add(scanner.nextLine());
            }

            List<String> result = new ArrayList<>();
            result.add("");
            result.add("*");
            result.add("*");
            result.add("");

            boolean isValid = true;
            for (String pattern : patterns) {
                if (matchesStart(pattern, result) && matchesEnd(pattern, result)) {
                    integratePattern(pattern, result);
                } else {
                    result.clear();
                    result.add("*");
                    isValid = false;
                    break;
                }
            }

            System.out.print("Case #" + (caseIndex + 1) + ": ");
            printResult(result, isValid);
            System.out.println();
        }
    }

    private static void printResult(List<String> result, boolean isValid) {
        if (!isValid || result.size() == 1) {
            System.out.print("*");
        } else {
            for (String part : result) {
                if (!part.equals("*")) {
                    System.out.print(part);
                }
            }
        }
    }

    private static void integratePattern(String pattern, List<String> result) {
        String[] parts = pattern.split("\\*");

        if (!pattern.startsWith("*") && matchesStart(pattern, result)) {
            String currentStart = result.get(0);
            if (currentStart.length() < parts[0].length()) {
                result.set(0, parts[0]);
            }
        }

        if (!pattern.endsWith("*") && matchesEnd(pattern, result)) {
            String currentEnd = result.get(result.size() - 1);
            if (currentEnd.length() < parts[parts.length - 1].length()) {
                result.set(result.size() - 1, parts[parts.length - 1]);
            }
        }

        for (int i = 1; i < parts.length - 1; i++) {
            result.add(2, parts[i]);
        }

        if (pattern.endsWith("*")) {
            result.add(2, parts[parts.length - 1]);
        }
    }

    private static boolean matchesEnd(String pattern, List<String> result) {
        if (pattern.endsWith("*")) return true;
        String[] parts = pattern.split("\\*");
        return matchesEndPart(result, parts[parts.length - 1]);
    }

    private static boolean matchesStart(String pattern, List<String> result) {
        if (pattern.startsWith("*")) return true;
        return matchesStartPart(result, pattern.split("\\*")[0]);
    }

    private static boolean matchesEndPart(List<String> result, String part) {
        if (result.isEmpty()) return true;

        StringBuilder endBuilder = new StringBuilder();
        int index = result.size() - 1;
        while (!result.get(index).equals("*")) {
            endBuilder.insert(0, result.get(index));
            index--;
        }
        String end = endBuilder.toString();
        int minLength = Math.min(end.length(), part.length());
        return end.substring(end.length() - minLength).equals(part.substring(part.length() - minLength));
    }

    private static boolean matchesStartPart(List<String> result, String part) {
        StringBuilder startBuilder = new StringBuilder();
        int index = 0;
        while (!result.get(index).equals("*")) {
            startBuilder.append(result.get(index));
            index++;
        }
        String start = startBuilder.toString();
        int minLength = Math.min(start.length(), part.length());
        return start.substring(0, minLength).equals(part.substring(0, minLength));
    }
}