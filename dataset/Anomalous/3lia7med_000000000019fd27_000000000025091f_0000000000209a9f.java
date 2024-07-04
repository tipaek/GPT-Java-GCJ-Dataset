import java.util.*;
import java.io.*;

public class Solution {

    public static String generateParentheses(int count, char parenthesis) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(parenthesis);
        }
        return sb.toString();
    }

    public static char getMinimumChar(String s) {
        char minChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < minChar) {
                minChar = s.charAt(i);
            }
        }
        return minChar;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        input.nextLine();

        for (int c = 0; c < t; c++) {
            String s = input.nextLine();
            System.out.printf("Case #%d: ", c + 1);

            char minChar = '0';
            boolean isEnd = true;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    System.out.print('0');
                } else {
                    if (s.substring(i + 1).contains("0")) {
                        char currentChar = s.charAt(i);
                        StringBuilder charGroup = new StringBuilder();
                        charGroup.append(currentChar);

                        while (i + 1 < s.length() && s.charAt(i + 1) == currentChar) {
                            charGroup.append(currentChar);
                            i++;
                        }

                        if (i + 1 < s.length() && s.charAt(i) > s.charAt(i + 1) && s.charAt(i + 1) != minChar) {
                            int openCount = s.charAt(i + 1) - minChar;
                            int nestedCount = currentChar - s.charAt(i + 1) - (minChar - '0');
                            System.out.print(generateParentheses(openCount, '(')
                                    + generateParentheses(nestedCount, '(')
                                    + charGroup
                                    + generateParentheses(nestedCount, ')')
                                    + generateParentheses(openCount, ')')
                                    + s.charAt(i + 1));
                            i++;
                            char nextChar = s.charAt(i);
                            while (i + 1 < s.length() && s.charAt(i + 1) == nextChar) {
                                System.out.print(nextChar);
                                i++;
                            }
                        } else {
                            int openCount = currentChar - '0' - 1;
                            System.out.print(generateParentheses(openCount, '(') + charGroup + generateParentheses(openCount, ')'));
                        }
                    } else {
                        if (isEnd) {
                            minChar = getMinimumChar(s.substring(i));
                            System.out.print(generateParentheses(minChar - '0', '('));
                            isEnd = false;
                        }

                        if (s.charAt(i) == minChar) {
                            System.out.print(minChar);
                            continue;
                        }

                        char currentChar = s.charAt(i);
                        StringBuilder charGroup = new StringBuilder();
                        charGroup.append(currentChar);

                        while (i + 1 < s.length() && s.charAt(i + 1) == currentChar) {
                            charGroup.append(currentChar);
                            i++;
                        }

                        if (i + 1 < s.length() && s.charAt(i) > s.charAt(i + 1) && s.charAt(i + 1) != minChar) {
                            int openCount = s.charAt(i + 1) - minChar;
                            int nestedCount = currentChar - s.charAt(i + 1) - (minChar - '0');
                            System.out.print(generateParentheses(openCount, '(')
                                    + generateParentheses(nestedCount, '(')
                                    + charGroup
                                    + generateParentheses(nestedCount, ')')
                                    + generateParentheses(openCount, ')')
                                    + s.charAt(i + 1));
                            i++;
                            char nextChar = s.charAt(i);
                            while (i + 1 < s.length() && s.charAt(i + 1) == nextChar) {
                                System.out.print(nextChar);
                                i++;
                            }
                        } else {
                            int openCount = currentChar - minChar;
                            System.out.print(generateParentheses(openCount, '(') + charGroup + generateParentheses(openCount, ')'));
                        }
                    }
                }
            }
            System.out.println(generateParentheses(minChar - '0', ')'));
        }
        input.close();
    }
}