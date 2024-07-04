import java.util.Scanner;

public class Main {

    public static String generateParentheses(int count, char parenthesis) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(parenthesis);
        }
        return s.toString();
    }

    public static char getMinCharacter(String s) {
        char minChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < minChar) {
                minChar = s.charAt(i);
            }
        }
        return minChar;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
                    if (s.substring(i + 1).contains("0")) {
                        char currentChar = s.charAt(i);
                        StringBuilder no = new StringBuilder().append(currentChar);
                        for (int j = i + 1; j < s.length() && s.charAt(j) == currentChar; j++, i++) {
                            no.append(currentChar);
                        }
                        if (i + 1 < s.length() && s.charAt(i) > s.charAt(i + 1) && s.charAt(i + 1) != minChar) {
                            System.out.print(generateParentheses(s.charAt(i + 1) - minChar, '(')
                                    + generateParentheses(currentChar - s.charAt(i + 1) - (minChar - '0'), '(')
                                    + no
                                    + generateParentheses(currentChar - s.charAt(i + 1) - (minChar - '0'), ')')
                                    + generateParentheses(s.charAt(i + 1) - minChar, ')')
                                    + s.charAt(i + 1));
                            i++;
                            char nextChar = s.charAt(i);
                            for (int u = i + 1; u < s.length() && s.charAt(u) == nextChar; u++, i++) {
                                System.out.print(nextChar);
                            }
                        } else {
                            System.out.print(generateParentheses(currentChar - '0' - 1, '(') + no + generateParentheses(currentChar - '0' - 1, ')'));
                        }
                    } else {
                        if (firstNonZero) {
                            minChar = getMinCharacter(s.substring(i));
                            System.out.print(generateParentheses(minChar - '0', '('));
                            firstNonZero = false;
                        }

                        if (s.charAt(i) == minChar) {
                            System.out.print(minChar);
                            continue;
                        }

                        char currentChar = s.charAt(i);
                        StringBuilder no = new StringBuilder().append(currentChar);
                        for (int j = i + 1; j < s.length() && s.charAt(j) == currentChar; j++, i++) {
                            no.append(currentChar);
                        }

                        if (i + 1 < s.length() && s.charAt(i) > s.charAt(i + 1) && s.charAt(i + 1) != minChar) {
                            System.out.print(generateParentheses(s.charAt(i + 1) - minChar, '(')
                                    + generateParentheses(currentChar - s.charAt(i + 1) - (minChar - '0'), '(')
                                    + no
                                    + generateParentheses(currentChar - s.charAt(i + 1) - (minChar - '0'), ')')
                                    + generateParentheses(s.charAt(i + 1) - minChar, ')')
                                    + s.charAt(i + 1));
                            i++;
                            char nextChar = s.charAt(i);
                            for (int u = i + 1; u < s.length() && s.charAt(u) == nextChar; u++, i++) {
                                System.out.print(nextChar);
                            }
                        } else {
                            System.out.print(generateParentheses(currentChar - minChar, '(') + no + generateParentheses(currentChar - minChar, ')'));
                        }
                    }
                }
            }
            System.out.println(generateParentheses(minChar - '0', ')'));
        }
        input.close();
    }
}