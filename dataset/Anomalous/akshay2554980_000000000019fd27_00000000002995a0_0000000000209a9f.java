import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < t; ++j) {
            String s = sc.next();
            int l = s.length();
            StringBuilder ans = new StringBuilder();
            int openBrackets = 0;

            for (int f = 0; f < l; ++f) {
                int currentDigit = s.charAt(f) - '0';
                int nextDigit = (f < l - 1) ? s.charAt(f + 1) - '0' : 0;

                while (openBrackets < currentDigit) {
                    ans.append('(');
                    openBrackets++;
                }
                while (openBrackets > currentDigit) {
                    ans.append(')');
                    openBrackets--;
                }
                ans.append(currentDigit);
            }

            while (openBrackets > 0) {
                ans.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + (j + 1) + ": " + ans.toString());
        }
    }
}