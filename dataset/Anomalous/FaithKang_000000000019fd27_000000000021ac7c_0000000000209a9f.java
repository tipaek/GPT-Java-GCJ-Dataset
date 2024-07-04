import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            String s = sc.next();
            StringBuilder answer = new StringBuilder();
            int closingNum = 0;

            for (int i = 0; i < s.length(); i++) {
                int currentNum = Character.getNumericValue(s.charAt(i));
                if (i == 0) {
                    appendParentheses(answer, currentNum, true);
                    closingNum = currentNum;
                } else {
                    int previousNum = Character.getNumericValue(s.charAt(i - 1));
                    if (currentNum > previousNum) {
                        appendParentheses(answer, currentNum - previousNum, true);
                        closingNum += currentNum - previousNum;
                    } else if (currentNum < previousNum) {
                        appendParentheses(answer, previousNum - currentNum, false);
                        closingNum -= previousNum - currentNum;
                    }
                }
                answer.append(s.charAt(i));
            }
            appendParentheses(answer, closingNum, false);
            System.out.println("Case #" + test_case + ": " + answer.toString());
        }
        
        sc.close();
    }

    private static void appendParentheses(StringBuilder answer, int count, boolean isOpen) {
        char parenthesis = isOpen ? '(' : ')';
        for (int j = 0; j < count; j++) {
            answer.append(parenthesis);
        }
    }
}