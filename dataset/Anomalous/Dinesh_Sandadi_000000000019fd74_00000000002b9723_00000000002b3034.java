import java.util.*;

public class Solution {

    private String findCommonString(List<String> strings) {
        if (strings.isEmpty()) {
            return "";
        }
        // Sort strings by length in descending order
        strings.sort((s1, s2) -> s2.length() - s1.length());
        String common = strings.get(0);

        for (String current : strings) {
            if (!common.contains(current)) {
                return "";
            }
        }
        return common;
    }

    private String processPatterns(String[] patterns) {
        List<List<String>> groups = new ArrayList<>();
        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            for (int j = 0; j < parts.length; j++) {
                while (groups.size() <= j) {
                    groups.add(new ArrayList<>());
                }
                groups.get(j).add(parts[j]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (List<String> group : groups) {
            result.append(findCommonString(group));
        }

        return groups.isEmpty() ? "A" : result.toString();
    }

    private void printResult(String result, int testCaseNumber) {
        if (result.isEmpty()) {
            result = "*";
        }
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int testCaseNumber = 1; testCaseNumber <= testCaseCount; testCaseNumber++) {
            int patternCount = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[patternCount];
            for (int i = 0; i < patternCount; i++) {
                patterns[i] = scanner.nextLine();
            }
            String result = solution.processPatterns(patterns);
            solution.printResult(result, testCaseNumber);
        }
    }
}