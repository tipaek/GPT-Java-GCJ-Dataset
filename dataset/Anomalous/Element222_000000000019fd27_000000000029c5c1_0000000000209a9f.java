import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(sc.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            System.out.print("Case #" + (caseIndex + 1) + ": ");
            String number = sc.nextLine();
            char[] digits = number.toCharArray();
            boolean openParenthesis = false;

            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == '1') {
                    if (!openParenthesis) {
                        System.out.print("(");
                        openParenthesis = true;
                    }
                } else if (digits[i] == '0') {
                    if (openParenthesis) {
                        System.out.print(")");
                        openParenthesis = false;
                    }
                }
                System.out.print(digits[i]);
            }

            if (openParenthesis) {
                System.out.print(")");
            }
            System.out.println();
        }
        sc.close();
    }
}