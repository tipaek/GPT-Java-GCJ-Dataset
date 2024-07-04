import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String inputString = scanner.next();
            String balancedString = balanceParentheses(inputString, 1);
            System.out.println("Case #" + testCase + ": " + balancedString);
        }
    }

    public static String balanceParentheses(String input, int level) {
        StringBuilder stringBuilder = new StringBuilder(input);
        int parenthesesBalance = 0;

        for (int i = 0; i < stringBuilder.length(); i++) {
            char currentChar = stringBuilder.charAt(i);

            if (currentChar == '(') {
                parenthesesBalance++;
            } else if (currentChar == ')') {
                parenthesesBalance--;
            }

            if (Character.getNumericValue(currentChar) == level) {
                if (parenthesesBalance != level) {
                    int leftIndex = i;
                    int rightIndex = i;

                    // Move left
                    while (leftIndex - 1 >= 0 && Character.getNumericValue(stringBuilder.charAt(leftIndex - 1)) >= level) {
                        leftIndex--;
                    }

                    // Move right
                    while (rightIndex + 1 < stringBuilder.length() && Character.getNumericValue(stringBuilder.charAt(rightIndex + 1)) >= level) {
                        rightIndex++;
                    }
                    rightIndex++;

                    stringBuilder.insert(rightIndex, ')');
                    stringBuilder.insert(leftIndex, '(');
                    break;
                }
            }
        }

        if (input.equals(stringBuilder.toString())) {
            if (level < 9) {
                return balanceParentheses(stringBuilder.toString(), level + 1);
            }
        } else {
            return balanceParentheses(stringBuilder.toString(), level);
        }

        return stringBuilder.toString();
    }
}