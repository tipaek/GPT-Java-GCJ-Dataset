import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        new Solution().start();
    }

    void start() {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            String digits = scan.next();
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < digits.length(); j++) {
                if (digits.charAt(j) == '0') {
                    if (j > 0 && digits.charAt(j - 1) == '1') {
                        result.append(')');
                    }
                    result.append('0');
                    continue;
                }
                if (j > 0 && digits.charAt(j - 1) == '1') {
                    result.append('1');
                    continue;
                }
                result.append("(1");
            }
            if (digits.length() > 0 && digits.charAt(digits.length() - 1) == '1') {
                result.append(")");
            }
            System.out.println("Case #" + (i+1) + ": " + result.toString());
        }
    }

}
