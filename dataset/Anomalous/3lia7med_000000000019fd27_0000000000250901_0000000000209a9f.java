import java.util.*;
import java.io.*;

public class Solution {

    public static String generateParentheses(int count, char type) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(type);
        }
        return s.toString();
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
            boolean end = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    System.out.print('0');
                } else {
                    if (s.substring(i + 1).contains("0")) {
                        char n = s.charAt(i);
                        StringBuilder no = new StringBuilder().append(n);
                        for (int j = i + 1; j < s.length() && s.charAt(j) == n; j++, i++) {
                            no.append(n);
                        }
                        if (i + 1 < s.length() && s.charAt(i) > s.charAt(i + 1) && s.charAt(i + 1) != minChar) {
                            System.out.print(generateParentheses(s.charAt(i + 1) - minChar, '(')
                                    + generateParentheses(n - s.charAt(i + 1) - (minChar - '0'), '(')
                                    + no + generateParentheses(n - s.charAt(i + 1) - (minChar - '0'), ')')
                                    + generateParentheses(s.charAt(i + 1) - minChar, ')')
                                    + s.charAt(i + 1));
                            i++;
                            char k = s.charAt(i);
                            for (int u = i + 1; u < s.length() && s.charAt(u) == k; u++, i++) {
                                System.out.print(k);
                            }
                        } else {
                            System.out.print(generateParentheses(n - '0' - 1, '(') + no + generateParentheses(n - '0' - 1, ')'));
                        }
                    } else {
                        if (end) {
                            minChar = getMinimumChar(s.substring(i));
                            System.out.print(generateParentheses(minChar - '0', '('));
                            end = false;
                        }

                        if (s.charAt(i) == minChar) {
                            System.out.print(minChar);
                            continue;
                        }

                        char n = s.charAt(i);
                        StringBuilder no = new StringBuilder().append(n);
                        for (int j = i + 1; j < s.length() && s.charAt(j) == n; j++, i++) {
                            no.append(n);
                        }
                        if (i + 1 < s.length() && s.charAt(i) > s.charAt(i + 1) && s.charAt(i + 1) != minChar) {
                            System.out.print(generateParentheses(s.charAt(i + 1) - minChar, '(')
                                    + generateParentheses(n - s.charAt(i + 1) - (minChar - '0'), '(')
                                    + no + generateParentheses(n - s.charAt(i + 1) - (minChar - '0'), ')')
                                    + generateParentheses(s.charAt(i + 1) - minChar, ')')
                                    + s.charAt(i + 1));
                            i++;
                            char k = s.charAt(i);
                            for (int u = i + 1; u < s.length() && s.charAt(u) == k; u++, i++) {
                                System.out.print(k);
                            }
                        } else {
                            System.out.print(generateParentheses(n - minChar, '(') + no + generateParentheses(n - minChar, ')'));
                        }
                    }
                }
            }
            System.out.println(generateParentheses(minChar - '0', ')'));
        }
        input.close();
    }
}