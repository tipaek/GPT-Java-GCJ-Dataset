import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfPatterns = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[numberOfPatterns];

            for (int patternIndex = 0; patternIndex < numberOfPatterns; patternIndex++) {
                patterns[patternIndex] = scanner.nextLine();
            }

            System.out.println(findPattern(patterns, caseIndex));
        }

        scanner.close();
    }

    public static String findPattern(String[] patterns, int caseIndex) {
        List<List<String>> splitPatterns = new ArrayList<>();

        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            List<String> partsList = new ArrayList<>(Arrays.asList(parts));

            if (pattern.startsWith("*")) {
                partsList.add(0, "#");
            }

            if (pattern.endsWith("*")) {
                partsList.add("#");
            }

            splitPatterns.add(partsList);
        }

        String longestSuffix = "";
        String longestPrefix = "";

        for (List<String> parts : splitPatterns) {
            String suffix = parts.get(parts.size() - 1);
            String prefix = parts.get(0);

            if (suffix.length() > longestSuffix.length()) {
                longestSuffix = suffix;
            }

            if (prefix.length() > longestPrefix.length()) {
                longestPrefix = prefix;
            }
        }

        for (List<String> parts : splitPatterns) {
            String suffix = parts.get(parts.size() - 1);
            String prefix = parts.get(0);

            if (!suffix.equals("#") && !longestSuffix.endsWith(suffix)) {
                return String.format("Case #%d: *", caseIndex + 1);
            }

            if (!prefix.equals("#") && !longestPrefix.startsWith(prefix)) {
                return String.format("Case #%d: *", caseIndex + 1);
            }
        }

        StringBuilder resultBuilder = new StringBuilder();

        for (List<String> parts : splitPatterns) {
            for (int i = 1; i < parts.size() - 1; i++) {
                resultBuilder.append(parts.get(i));
            }
        }

        String result = resultBuilder.toString();

        if (!longestPrefix.equals("#")) {
            result = longestPrefix + result;
        }

        if (!longestSuffix.equals("#")) {
            result += longestSuffix;
        }

        return String.format("Case #%d: %s", caseIndex + 1, result);
    }
}