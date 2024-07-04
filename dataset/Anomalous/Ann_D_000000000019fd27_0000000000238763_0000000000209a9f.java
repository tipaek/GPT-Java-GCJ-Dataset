import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            String s = sc.next();
            char[] chars = s.toCharArray();
            int[] openBrackets = new int[chars.length];
            int[] closeBrackets = new int[chars.length];

            openBrackets[0] = chars[0] - '0';
            closeBrackets[0] = chars[0] - '0';

            for (int j = 1; j < chars.length; j++) {
                int currentDigit = chars[j] - '0';
                int previousDigit = chars[j - 1] - '0';

                if (currentDigit <= previousDigit) {
                    closeBrackets[j - 1] -= currentDigit;
                    closeBrackets[j] = currentDigit;
                } else {
                    closeBrackets[j] = closeBrackets[j - 1] + (currentDigit - previousDigit);
                    openBrackets[j] = currentDigit - previousDigit;
                    closeBrackets[j - 1] = 0;
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < chars.length; j++) {
                for (int k = 0; k < openBrackets[j]; k++) {
                    System.out.print("(");
                }

                System.out.print(chars[j]);

                for (int k = 0; k < closeBrackets[j]; k++) {
                    System.out.print(")");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}