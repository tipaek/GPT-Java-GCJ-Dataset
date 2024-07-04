import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int caseNum = 1; caseNum <= n; caseNum++) {
            String s = sc.next();
            char[] charArray = s.toCharArray();
            StringBuilder ans = new StringBuilder();
            int openBrackets = 0;

            for (char c : charArray) {
                int digit = c - '0';

                while (openBrackets < digit) {
                    ans.append('(');
                    openBrackets++;
                }

                while (openBrackets > digit) {
                    ans.append(')');
                    openBrackets--;
                }

                ans.append(digit);
            }

            while (openBrackets > 0) {
                ans.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + caseNum + ": " + ans);
        }

        sc.close();
    }
}