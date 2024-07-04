import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int caseNumber = 1;

        while (n > 0) {
            String input = in.nextLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentNum = Character.getNumericValue(input.charAt(i));

                if (i == 0) {
                    appendParentheses(result, currentNum, openParentheses);
                    openParentheses = currentNum;
                } else {
                    int previousNum = Character.getNumericValue(input.charAt(i - 1));
                    if (currentNum > previousNum) {
                        appendParentheses(result, currentNum - previousNum, 0);
                    } else if (currentNum < previousNum) {
                        appendParentheses(result, 0, previousNum - currentNum);
                    }
                }
                result.append(input.charAt(i));
            }

            appendParentheses(result, 0, openParentheses);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
            n--;
        }
    }

    private static void appendParentheses(StringBuilder result, int openCount, int closeCount) {
        for (int i = 0; i < openCount; i++) {
            result.append('(');
        }
        for (int i = 0; i < closeCount; i++) {
            result.append(')');
        }
    }
}