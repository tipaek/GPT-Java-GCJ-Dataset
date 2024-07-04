package nestingDepth;

import java.util.*;

public class NestingDepth {

    private int T;
    private List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        NestingDepth nestingDepth = new NestingDepth();
        nestingDepth.readInput();

        for (int i = 0; i < nestingDepth.strings.size(); i++) {
            String inputString = nestingDepth.strings.get(i);
            String resultString = nestingDepth.applyParentheses(inputString);
            System.out.println(String.format("Case #%d: %s", i + 1, resultString));
        }
    }

    private String applyParentheses(String input) {
        List<Integer> digits = new ArrayList<>();
        input.chars().forEach(ch -> digits.add(Character.getNumericValue(ch)));
        int min = Collections.min(digits);
        int max = Collections.max(digits);

        StringBuilder result = new StringBuilder();
        int openParentheses = 0;
        int currentValue = min;

        // Open initial parentheses
        for (int i = 0; i < min; i++) {
            result.append("(");
            openParentheses++;
        }

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            if (digit == currentValue) {
                result.append(digit);
            } else if (digit < currentValue) {
                while (openParentheses > digit) {
                    result.append(")");
                    openParentheses--;
                }
                result.append(digit);
                currentValue = digit;
            } else {
                while (openParentheses < digit) {
                    result.append("(");
                    openParentheses++;
                }
                result.append(digit);
                currentValue = digit;
            }
        }

        // Close remaining open parentheses
        while (openParentheses > 0) {
            result.append(")");
            openParentheses--;
        }

        return result.toString();
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