import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int openParens = 0;
            int caseNumber = i + 1;

            for (char ch : s.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                while (openParens < digit) {
                    result.append('(');
                    openParens++;
                }
                while (openParens > digit) {
                    result.append(')');
                    openParens--;
                }
                result.append(digit);
            }

            while (openParens > 0) {
                result.append(')');
                openParens--;
            }

            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }
    }
}