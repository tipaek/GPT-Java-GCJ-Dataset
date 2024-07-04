import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            char[] characters = input.toCharArray();
            int length = characters.length;
            int top = 0;
            ArrayList<String> result = new ArrayList<>(4);

            for (int i = 0; i < length; i++) {
                int currentDigit = characters[i] - '0';

                if (i == 0) {
                    top = currentDigit == 0 ? 1 : currentDigit + 1;
                    addParentheses(result, currentDigit, '(');
                    result.add(Character.toString(characters[i]));
                    addParentheses(result, currentDigit, ')');
                } else {
                    int previousDigit = characters[i - 1] - '0';
                    if (currentDigit >= previousDigit) {
                        int difference = currentDigit - previousDigit;
                        addParentheses(result, difference, '(');
                        result.add(Character.toString(characters[i]));
                        addParentheses(result, difference, ')');
                    } else {
                        int difference = previousDigit - currentDigit;
                        top += difference;
                        result.add(Character.toString(characters[i]));
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (String s : result) {
                output.append(s);
            }

            System.out.println("Case #" + caseNumber + ": " + output);
            caseNumber++;
        }

        scanner.close();
    }

    private static void addParentheses(ArrayList<String> result, int count, char parenthesis) {
        for (int i = 0; i < count; i++) {
            result.add(Character.toString(parenthesis));
        }
    }
}