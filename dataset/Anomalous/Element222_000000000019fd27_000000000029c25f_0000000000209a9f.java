import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < testCases; t++) {
            String number = sc.nextLine();
            char[] digits = number.toCharArray();
            boolean needOpenParenthesis = false;
            boolean hasOpenParenthesis = false;

            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == '1') {
                    if (!hasOpenParenthesis) {
                        System.out.print("(");
                        hasOpenParenthesis = true;
                        needOpenParenthesis = true;
                    }
                } else if (digits[i] == '0') {
                    if (needOpenParenthesis) {
                        System.out.print(")");
                        hasOpenParenthesis = false;
                        needOpenParenthesis = false;
                    }
                }
                System.out.print(digits[i]);
            }

            if (needOpenParenthesis) {
                System.out.println(")");
            } else {
                System.out.println();
            }
        }
        sc.close();
    }
}