package nestingDepth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private int testCaseCount;
    private List<String> inputStrings = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();
        solution.processInput();
    }

    private void processInput() {
        for (int i = 0; i < inputStrings.size(); i++) {
            String processedString = applyParentheses(inputStrings.get(i));
            System.out.println(String.format("Case #%d: %s", i + 1, processedString));
        }
    }

    private String applyParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }

    private void readInput() {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            testCaseCount = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < testCaseCount; i++) {
            if (scanner.hasNextLine()) {
                inputStrings.add(scanner.nextLine());
            }
        }

        scanner.close();
    }
}