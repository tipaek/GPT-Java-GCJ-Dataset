package nestingDepth;

import java.util.*;

public class Solution {

    private int T;
    private List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();
        solution.processStrings();
    }

    private void processStrings() {
        for (int i = 0; i < strings.size(); i++) {
            String originalString = strings.get(i);
            String transformedString = applyParentheses(originalString);
            System.out.println(String.format("Case #%d: %s", i + 1, transformedString));
        }
    }

    private String applyParentheses(String string) {
        StringBuilder newString = new StringBuilder();
        int openParentheses = 0;
        int currentValue = 0;

        for (char ch : string.toCharArray()) {
            int newCharValue = Character.getNumericValue(ch);

            while (openParentheses < newCharValue) {
                newString.append("(");
                openParentheses++;
            }

            while (openParentheses > newCharValue) {
                newString.append(")");
                openParentheses--;
            }

            newString.append(newCharValue);
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