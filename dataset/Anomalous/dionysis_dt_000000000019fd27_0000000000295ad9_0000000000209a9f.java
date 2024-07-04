package nestingDepth;

import java.util.*;

public class Solution {

    private int testCaseCount;
    private List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();
        solution.processInput();
    }

    private void processInput() {
        for (int i = 0; i < strings.size(); i++) {
            String inputString = strings.get(i);
            String resultString = applyParentheses(inputString);
            System.out.println(String.format("Case #%d: %s", i + 1, resultString));
        }
    }

    private String applyParentheses(String input) {
        StringBuilder sb = new StringBuilder();
        int currentDepth = 0;

        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            while (currentDepth < digit) {
                sb.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                sb.append(')');
                currentDepth--;
            }
            sb.append(digit);
        }

        while (currentDepth > 0) {
            sb.append(')');
            currentDepth--;
        }

        return sb.toString();
    }

    private void readInput() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            testCaseCount = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < testCaseCount; i++) {
            if (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        }

        scanner.close();
    }
}