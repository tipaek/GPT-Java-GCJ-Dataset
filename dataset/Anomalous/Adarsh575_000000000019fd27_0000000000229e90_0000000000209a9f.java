import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = Integer.parseInt(sc.nextLine());

        for (int test = 1; test <= testcase; test++) {
            String S = sc.nextLine();
            StringBuilder ans = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < S.length(); i++) {
                int number = Character.getNumericValue(S.charAt(i));

                if (i == 0) {
                    ans.append(generateParentheses(number, '('));
                    ans.append(number);
                    currentDepth = number;
                } else {
                    int previousNumber = Character.getNumericValue(S.charAt(i - 1));

                    if (number > previousNumber) {
                        ans.append(generateParentheses(number - currentDepth, '('));
                    } else if (number < previousNumber) {
                        ans.append(generateParentheses(currentDepth - number, ')'));
                    }

                    ans.append(number);
                    currentDepth = number;
                }
            }

            ans.append(generateParentheses(currentDepth, ')'));
            System.out.println("Case #" + test + ": " + ans.toString());
        }

        sc.close();
    }

    private static String generateParentheses(int count, char parenthesis) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(parenthesis);
        }
        return sb.toString();
    }
}