import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int caseNumber = 1;

        while (n > 0) {
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();
            int openParentheses = 0;

            for (int i = 0; i < s.length(); i++) {
                int num = Character.getNumericValue(s.charAt(i));

                if (i == 0) {
                    appendParentheses(sb, num, openParentheses);
                    openParentheses = num;
                } else {
                    int prevNum = Character.getNumericValue(s.charAt(i - 1));
                    if (num > prevNum) {
                        appendParentheses(sb, num - prevNum, 0);
                    } else if (num < prevNum) {
                        appendParentheses(sb, 0, prevNum - num);
                    }
                    openParentheses = num;
                }

                sb.append(s.charAt(i));

                if (i == s.length() - 1) {
                    appendParentheses(sb, 0, openParentheses);
                }
            }

            System.out.println("Case #" + caseNumber + ": " + sb);
            caseNumber++;
            n--;
        }
    }

    private static void appendParentheses(StringBuilder sb, int openCount, int closeCount) {
        for (int i = 0; i < openCount; i++) {
            sb.append('(');
        }
        for (int i = 0; i < closeCount; i++) {
            sb.append(')');
        }
    }
}