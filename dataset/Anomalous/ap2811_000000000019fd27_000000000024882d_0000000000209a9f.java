import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int o = 1; o <= t; o++) {
            String s = sc.next();
            int[] digits = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                digits[i] = s.charAt(i) - '0';
            }

            StringBuilder result = new StringBuilder();
            result.append("Case #").append(o).append(": ");
            for (int i = 0; i < digits[0]; i++) {
                result.append("(");
            }
            result.append(digits[0]);

            for (int i = 1; i < digits.length; i++) {
                int diff = digits[i] - digits[i - 1];
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        result.append("(");
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        result.append(")");
                    }
                }
                result.append(digits[i]);
            }

            for (int i = 0; i < digits[digits.length - 1]; i++) {
                result.append(")");
            }
            System.out.println(result.toString());
        }
        sc.close();
    }
}