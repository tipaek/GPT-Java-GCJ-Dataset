import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int numberPatterns = scanner.nextInt();
            List<String> startPatterns = new ArrayList<>();
            List<String> middlePatterns = new ArrayList<>();
            List<String> mixedPatterns = new ArrayList<>();
            List<String> endPatterns = new ArrayList<>();
            String jackpot = null;

            for (int i = 0; i < numberPatterns; i++) {
                String pattern = scanner.next();
                if (!pattern.contains("*")) {
                    jackpot = pattern;
                } else if (pattern.startsWith("*") && pattern.endsWith("*")) {
                    if (!mixedPatterns.contains(pattern)) mixedPatterns.add(pattern);
                } else if (pattern.endsWith("*")) {
                    if (!startPatterns.contains(pattern)) startPatterns.add(pattern);
                } else if (pattern.startsWith("*")) {
                    if (!endPatterns.contains(pattern)) endPatterns.add(pattern);
                } else {
                    if (!middlePatterns.contains(pattern)) middlePatterns.add(pattern);
                }
            }

            if (jackpot != null) {
                System.out.println("Case #" + t + ": " + jackpot);
                continue;
            }

            startPatterns.sort(Comparator.comparingInt(String::length));
            middlePatterns.sort(Comparator.comparingInt(String::length));
            mixedPatterns.sort(Comparator.comparingInt(String::length));
            endPatterns.sort(Comparator.comparingInt(String::length));

            if (isListInvalid(startPatterns) || isListInvalid(endPatterns) || isListInvalid(middlePatterns) || isListInvalid(mixedPatterns)) {
                System.out.println("Case #" + t + ": *");
                continue;
            }

            String start = getLastElementOrNull(startPatterns);
            String middle = getLastElementOrNull(middlePatterns);
            String mixed = getLastElementOrNull(mixedPatterns);
            String end = getLastElementOrNull(endPatterns);

            String result = "None";
            if (middle != null) {
                if (isInvalidPattern(start, middle, true) || isInvalidPattern(end, middle, false)) {
                    System.out.println("Case #" + t + ": *");
                    continue;
                }
                result = middle.replace("*", "");
            } else {
                result = constructResult(start, mixed, end);
            }
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static boolean isListInvalid(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            String current = list.get(i);
            String previous = list.get(i - 1).replace("*", "(.*)");
            if (!current.matches(previous)) return true;
        }
        return false;
    }

    private static String getLastElementOrNull(List<String> list) {
        return list.isEmpty() ? null : list.get(list.size() - 1);
    }

    private static boolean isInvalidPattern(String pattern, String middle, boolean isStart) {
        if (pattern == null) return false;
        if (isStart) return !middle.startsWith(pattern);
        return !middle.endsWith(pattern);
    }

    private static String constructResult(String start, String mixed, String end) {
        StringBuilder result = new StringBuilder();
        if (start != null) result.append(start.replace("*", ""));
        if (mixed != null) result.append(mixed.replace("*", ""));
        if (end != null) result.append(end.replace("*", ""));
        return result.toString();
    }
}