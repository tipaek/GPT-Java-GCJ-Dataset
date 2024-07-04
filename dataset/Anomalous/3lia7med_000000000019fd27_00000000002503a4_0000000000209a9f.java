import java.util.*;
import java.io.*;

public class Solution {

    public static String openParentheses(int count) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append('(');
        }
        return s.toString();
    }

    public static String closeParentheses(int count) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(')');
        }
        return s.toString();
    }

    public static char getMinChar(String s) {
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
            char minChar = '0';
            boolean isFirst = true;
            String s = input.nextLine();
            System.out.printf("Case #%d: ", c + 1);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    System.out.print('0');
                } else {
                    if (s.substring(i + 1).indexOf('0') >= 0) {
                        char currentChar = s.charAt(i);
                        StringBuilder currentSequence = new StringBuilder().append(currentChar);

                        for (int j = i + 1; j < s.length() && s.charAt(j) == currentChar; j++, i++) {
                            currentSequence.append(currentChar);
                        }

                        if (i + 1 < s.length() && s.charAt(i) > s.charAt(i + 1) && s.charAt(i + 1) != minChar) {
                            System.out.print(openParentheses(s.charAt(i + 1) - minChar)
                                    + openParentheses(currentChar - s.charAt(i + 1) - (minChar - '0'))
                                    + currentSequence
                                    + closeParentheses(currentChar - s.charAt(i + 1) - (minChar - '0'))
                                    + closeParentheses(s.charAt(i + 1) - minChar)
                                    + s.charAt(i + 1));
                            i++;
                            char nextChar = s.charAt(i);
                            for (int u = i + 1; u < s.length() && s.charAt(u) == nextChar; u++, i++) {
                                System.out.print(nextChar);
                            }
                        } else {
                            System.out.print(openParentheses(currentChar - '0' - 1) + currentSequence + closeParentheses(currentChar - '0' - 1));
                        }
                    } else {
                        if (isFirst) {
                            minChar = getMinChar(s.substring(i));
                            System.out.print(openParentheses(minChar - '0'));
                            isFirst = false;
                        }

                        if (s.charAt(i) == minChar) {
                            System.out.print(minChar);
                            continue;
                        }

                        char currentChar = s.charAt(i);
                        StringBuilder currentSequence = new StringBuilder().append(currentChar);

                        for (int j = i + 1; j < s.length() && s.charAt(j) == currentChar; j++, i++) {
                            currentSequence.append(currentChar);
                        }

                        if (i + 1 < s.length() && s.charAt(i) > s.charAt(i + 1) && s.charAt(i + 1) != minChar) {
                            System.out.print(openParentheses(s.charAt(i + 1) - minChar)
                                    + openParentheses(currentChar - s.charAt(i + 1) - (minChar - '0'))
                                    + currentSequence
                                    + closeParentheses(currentChar - s.charAt(i + 1) - (minChar - '0'))
                                    + closeParentheses(s.charAt(i + 1) - minChar)
                                    + s.charAt(i + 1));
                            i++;
                            char nextChar = s.charAt(i);
                            for (int u = i + 1; u < s.length() && s.charAt(u) == nextChar; u++, i++) {
                                System.out.print(nextChar);
                            }
                        } else {
                            System.out.print(openParentheses(currentChar - minChar) + currentSequence + closeParentheses(currentChar - minChar));
                        }
                    }
                }
            }
            System.out.println(closeParentheses(minChar - '0'));
        }
        input.close();
    }
}