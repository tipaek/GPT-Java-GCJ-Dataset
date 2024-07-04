package nestingDepth;

import java.util.*;

public class NestingDepth {

    private int T;
    private List<String> strings = new ArrayList<>();
    private List<String> newStrings = new ArrayList<>();

    public static void main(String[] args) {
        NestingDepth nestingDepth = new NestingDepth();
        nestingDepth.readInput();

        for (int i = 0; i < nestingDepth.strings.size(); i++) {
            String inputString = nestingDepth.strings.get(i);
            String processedString = nestingDepth.applyParentheses(inputString);
            System.out.printf("Case #%d: %s%n", i + 1, processedString);
        }
    }

    private String applyParentheses(String inputString) {
        List<Integer> digits = new ArrayList<>();
        inputString.chars().forEach(c -> digits.add(Character.getNumericValue(c)));

        int minDigit = Collections.min(digits);
        int maxDigit = Collections.max(digits);

        StringBuilder resultString = new StringBuilder();
        int openParentheses = 0;
        int currentValue = minDigit;

        // Open initial parentheses to match the minimum digit
        resultString.append("(".repeat(Math.max(0, minDigit)));
        openParentheses += minDigit;

        for (int i = 0; i < inputString.length(); i++) {
            int currentDigit = Character.getNumericValue(inputString.charAt(i));

            if (currentDigit == currentValue) {
                resultString.append(currentDigit);
            } else if (currentDigit < currentValue) {
                while (openParentheses > currentDigit) {
                    resultString.append(")");
                    openParentheses--;
                }
                resultString.append(currentDigit);
                currentValue = currentDigit;
            } else {
                while (openParentheses < currentDigit) {
                    resultString.append("(");
                    openParentheses++;
                }
                resultString.append(currentDigit);
                currentValue = currentDigit;
            }
        }

        // Close remaining open parentheses
        resultString.append(")".repeat(Math.max(0, openParentheses)));

        return resultString.toString();
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