package nestingDepth;

import java.util.*;

public class Solution {

    private int T;
    private List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        Solution nestingDepth = new Solution();
        nestingDepth.readInput();

        for (int x = 0; x < nestingDepth.strings.size(); x++) {
            String string = nestingDepth.strings.get(x);
            String newString = nestingDepth.applyParentheses(string);
            System.out.println(String.format("Case #%d: %s", x + 1, newString));
        }
    }

    private String applyParentheses(String string) {
        StringBuilder newString = new StringBuilder();
        int openParentheses = 0;
        int currentValue = 0;

        for (char c : string.toCharArray()) {
            int newCharValue = Character.getNumericValue(c);

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
        Scanner reader = new Scanner(System.in);
        if (reader.hasNextLine()) {
            T = Integer.parseInt(reader.nextLine());
        }

        for (int i = 0; i < T; i++) {
            if (reader.hasNextLine()) {
                strings.add(reader.nextLine());
            }
        }

        reader.close();
    }
}