package nestingDepth;

import java.util.*;

public class Solution {

    private int T;
    private List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        Solution nestingDepth = new Solution();
        nestingDepth.readInput();
        nestingDepth.processInput();
    }

    private void processInput() {
        for (int i = 0; i < strings.size(); i++) {
            String inputString = strings.get(i);
            String resultString = applyParentheses(inputString);
            System.out.println(String.format("Case #%d: %s", i + 1, resultString));
        }
    }

    private String applyParentheses(String inputString) {
        StringBuilder newString = new StringBuilder();
        int openParentheses = 0;
        int currentValue = 0;

        for (char ch : inputString.toCharArray()) {
            int digit = Character.getNumericValue(ch);

            while (openParentheses < digit) {
                newString.append("(");
                openParentheses++;
            }
            while (openParentheses > digit) {
                newString.append(")");
                openParentheses--;
            }

            newString.append(digit);
            currentValue = digit;
        }

        while (openParentheses > 0) {
            newString.append(")");
            openParentheses--;
        }

        return newString.toString();
    }

    private void readInput() {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            T = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < T; i++) {
            if (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        }

        scanner.close();
    }
}