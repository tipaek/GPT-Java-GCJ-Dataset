package nestingDepth;

import java.util.Scanner;

public class Solution {

    private int T;

    public static void main(String[] args) {
        try {
            Solution solution = new Solution();
            solution.readInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String applyParentheses(String string) {
        int currentValue = 0;
        int openParentheses = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            int newCharValue = Character.getNumericValue(string.charAt(i));
            if (newCharValue == currentValue) {
                sb.append(newCharValue);
            } else if (newCharValue < currentValue) {
                while (openParentheses > newCharValue) {
                    sb.append(')');
                    openParentheses--;
                }
                sb.append(newCharValue);
                currentValue = newCharValue;
            } else {
                while (openParentheses < newCharValue) {
                    sb.append('(');
                    openParentheses++;
                }
                sb.append(newCharValue);
                currentValue = newCharValue;
            }
        }

        while (openParentheses > 0) {
            sb.append(')');
            openParentheses--;
        }

        return sb.toString();
    }

    private void readInput() {
        Scanner reader = new Scanner(System.in);
        if (reader.hasNextLine()) {
            T = Integer.parseInt(reader.nextLine());
        }

        for (int i = 0; i < T; i++) {
            String inputString = reader.nextLine();
            String result = applyParentheses(inputString);
            System.out.println(String.format("Case #%d: %s", i + 1, result));
        }

        reader.close();
    }
}