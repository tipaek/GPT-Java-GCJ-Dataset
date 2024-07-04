import java.util.*;

public class Solution {

    private String findCommonString(List<String> strings) {
        if (strings.isEmpty()) {
            return "";
        }
        strings.sort((s1, s2) -> s2.length() - s1.length());
        String common = strings.get(0);

        for (String current : strings) {
            if (!common.contains(current)) {
                return "";
            }
        }
        return common;
    }
    
    private String findPattern(String[] patterns) {
        List<List<String>> groups = new ArrayList<>();
        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            for (int j = 0; j < parts.length; j++) {
                while (groups.size() < (j + 1)) {
                    groups.add(new ArrayList<>());
                }
                groups.get(j).add(parts[j]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (List<String> group : groups) {
            result.append(findCommonString(group));
        }
        return result.toString();
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
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int numberOfPatterns = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[numberOfPatterns];
            for (int j = 0; j < numberOfPatterns; j++) {
                patterns[j] = scanner.nextLine();
            }
            String result = solution.findPattern(patterns);
            solution.printResult(result, i);
        }
    }
}