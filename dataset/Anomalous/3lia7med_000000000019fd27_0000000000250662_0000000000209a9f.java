import java.util.*;
import java.io.*;

public class Solution {

    public static String generateParentheses(int count, char type) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(type);
        }
        return sb.toString();
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
            boolean firstNonZero = true;
            String s = input.nextLine();
            System.out.printf("Case #%d: ", c + 1);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    System.out.print('0');
                } else {
                    if (firstNonZero) {
                        minChar = getMinChar(s.substring(i));
                        System.out.print(generateParentheses(minChar - '0', '('));
                        firstNonZero = false;
                    }

                    if (s.charAt(i) == minChar) {
                        System.out.print(minChar);
                        continue;
                    }

                    char currentChar = s.charAt(i);
                    StringBuilder repeatedChars = new StringBuilder();
                    repeatedChars.append(currentChar);

                    while (i + 1 < s.length() && s.charAt(i + 1) == currentChar) {
                        repeatedChars.append(currentChar);
                        i++;
                    }

                    if (i + 1 < s.length() && s.charAt(i) > s.charAt(i + 1) && s.charAt(i + 1) != minChar) {
                        int openBefore = s.charAt(i + 1) - minChar;
                        int openAfter = currentChar - s.charAt(i + 1);
                        System.out.print(generateParentheses(openBefore, '(') + generateParentheses(openAfter, '(') + repeatedChars + generateParentheses(openAfter, ')') + generateParentheses(openBefore, ')') + s.charAt(i + 1));
                        i++;
                        char nextChar = s.charAt(i);
                        while (i + 1 < s.length() && s.charAt(i + 1) == nextChar) {
                            System.out.print(nextChar);
                            i++;
                        }
                    } else {
                        int openCount = currentChar - minChar;
                        System.out.print(generateParentheses(openCount, '(') + repeatedChars + generateParentheses(openCount, ')'));
                    }
                }
            }
            System.out.println(generateParentheses(minChar - '0', ')'));
        }
        input.close();
    }
}