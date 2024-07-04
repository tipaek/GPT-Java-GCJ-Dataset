import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            String s = in.next();
            int n = s.length();
            int[] digits = new int[n];
            for (int i = 0; i < n; i++) {
                digits[i] = s.charAt(i) - '0';
            }
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;
            for (int i = 0; i < n; i++) {
                while (openParentheses < digits[i]) {
                    result.append('(');
                    openParentheses++;
                }
                while (openParentheses > digits[i]) {
                    result.append(')');
                    openParentheses--;
                }
                result.append(digits[i]);
            }
            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }
            System.out.println("Case #" + x + ": " + result.toString());
        }
        in.close();
    }
}