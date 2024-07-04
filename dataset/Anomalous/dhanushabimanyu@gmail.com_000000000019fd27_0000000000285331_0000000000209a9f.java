import java.util.Scanner;

public class Solution {

    static int countChar(StringBuilder sb, char ch) {
        int count = 0;
        for (int j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) == ch) {
                count++;
            }
        }
        return count;
    }

    static String addChars(int count, char ch) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String str = scanner.next();
            int len = str.length();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < len; j++) {
                int n = Character.getNumericValue(str.charAt(j));
                int open = countChar(sb, '(');
                int close = countChar(sb, ')');

                if (n == 0) {
                    sb.append(addChars(open - close, ')')).append(0);
                } else if (open == close) {
                    sb.append(addChars(n, '(')).append(n);
                } else if (open - close == n) {
                    sb.append(n);
                } else if (open - close < n) {
                    sb.append(addChars(n - (open - close), '(')).append(n);
                } else if (open - close > n) {
                    sb.append(addChars((open - close) - n, ')')).append(n);
                }

                if (j == len - 1) {
                    sb.append(addChars(open - close, ')'));
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }

        scanner.close();
    }
}