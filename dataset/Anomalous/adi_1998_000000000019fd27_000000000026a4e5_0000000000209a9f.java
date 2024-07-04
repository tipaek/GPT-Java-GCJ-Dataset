import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String openParentheses = "(((((((((";
        String closeParentheses = ")))))))))";

        for (int t1 = 0; t1 < t; t1++) {
            String str = sc.next();
            int length = str.length();
            int[] cumulativeTotal = new int[length];
            cumulativeTotal[0] = str.charAt(0) - '0';
            
            for (int i = 1; i < length; i++) {
                int difference = str.charAt(i) - str.charAt(i - 1);
                cumulativeTotal[i] = cumulativeTotal[i - 1] + difference;
            }

            StringBuilder result = new StringBuilder();
            if (cumulativeTotal[0] > 0) {
                result.append(openParentheses, 0, cumulativeTotal[0]);
            }
            result.append(str.charAt(0));

            for (int i = 1; i < length; i++) {
                int difference = cumulativeTotal[i] - cumulativeTotal[i - 1];
                if (difference > 0) {
                    result.append(openParentheses, 0, difference);
                } else if (difference < 0) {
                    result.append(closeParentheses, 0, -difference);
                }
                result.append(str.charAt(i));
            }

            if (cumulativeTotal[length - 1] > 0) {
                result.append(closeParentheses, 0, cumulativeTotal[length - 1]);
            }

            System.out.println("Case #" + (t1 + 1) + ": " + result);
        }

        sc.close();
    }
}