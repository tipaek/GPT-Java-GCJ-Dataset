import java.util.*;

public class Solution {

    private String findCommonString(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        list.sort((s1, s2) -> s2.length() - s1.length());
        String common = list.get(0);

        for (String current : list) {
            if (!common.endsWith(current)) {
                return "";
            }
        }

        return common;
    }

    private String processPatterns(String[] patterns) {
        List<List<String>> groups = new ArrayList<>();
        for (String pattern : patterns) {
            String[] fragments = pattern.split("\\*");
            for (int j = 0; j < fragments.length; j++) {
                while (groups.size() <= j) {
                    groups.add(new ArrayList<>());
                }
                groups.get(j).add(fragments[j]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (List<String> group : groups) {
            result.append(findCommonString(group));
        }

        return groups.isEmpty() ? "A" : result.toString();
    }

    private void displayResult(String result, int testCase) {
        if (result.isEmpty()) {
            result = "*";
        }
        System.out.println("Case #" + testCase + ": " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int numPatterns = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[numPatterns];
            for (int j = 0; j < numPatterns; j++) {
                patterns[j] = scanner.nextLine();
            }
            String result = solution.processPatterns(patterns);
            solution.displayResult(result, i);
        }
    }
}