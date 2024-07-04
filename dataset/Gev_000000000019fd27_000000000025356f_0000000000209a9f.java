import java.util.*;

public class Solution {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            char[] digits = scanner.nextLine().toCharArray();
            int prev = 0;
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < digits.length; j++) {
                int diff = (digits[j] - '0') - prev;
                str.append(addParanthesis(diff)).append(digits[j]);
                prev = digits[j] - '0';
            }
            str.append(addParanthesis(-prev));
            System.out.println(String.format("Case #%d: %s", i, str.toString()));
        }
    }

    private static String addParanthesis(int diff) {
        if (diff > 0)
            return new String(new char[diff]).replace("\0", "(");
        if (diff < 0)
            return new String(new char[-diff]).replace("\0", ")");

        return "";
    }
}